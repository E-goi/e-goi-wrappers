
<%
	' David Carter-Tod, wccartd@wc.cc.va.us, June 1999
	' This code is covered by the GNU GPL,
	' http://www.opensource.org/licenses/gpl-license.html
	' One major issue I am still concerned about is the
	' destruction of Dictionary
	' objects which are created when a struct is returned
	' by the remote function
	' since the function passes around pointers (not deeply
	' tested yet, mind you)
	' the Dictionary object still needs to be set to nothing
	' at some point, doesn't it?

        ' Additional comments and indenting added by jjohn 8/2000
        ' $Date: 2001/02/17 15:36:13 $
'	http://david.carter-tod.com/XMLRPC/default.asp
'

' Globals

const XRPC_RESOLVE_TIMEOUT = 5000
const XRPC_CONNECT_TIMEOUT = 500
const XRPC_SEND_TIMEOUT 		= 1000
const XRPC_RECEIVE_TIMEOUT = 10000
const XERR_NONE = 0
const XERR_NOSERVER = -2147012867
const XERR_TIMEOUT = -2147012894 

Dim xmlText, serverResponseText
Dim returnArr(2)

' create a dictionary of valid server functions and their mappings
dim serverMappings
Set serverMappings = Server.CreateObject("Scripting.Dictionary")


' Problems arise when servers do not return a data type consistently when returning empty values.
'
' The problem arises most often when a Server.CreateObject() return type was expected, such as with
' <struct> returning Scripting.Dictionary, but the variant NULL is returned because the server
' returned not an empty <struct> but a plain empty <value>
'
' Because VBScript has different syntax for assigning variants and objects, and because this library
' has no other way of determining what the return type should have been, the most recent return value
' is stored in a global variable. That way  you can check the return type from the function and
' assign the return value programatically.
Dim XmlRpcReturnValue


' ----- Utility functions -----


' Concatenate new txt to global xmlText
sub addTxt(txt)
	xmlText = xmlText & txt & vbNewline
end sub

' Turn a numeric (?) date into a purty string
function dateToText(el)
	el = CStr(el)
	if Len(el)=1 then
		el = "0" & el
		end if
	dateToText = el
end function

Class Base64_Wrapper
  Private val
  Public Property Get Item()
     Item = val
  End Property
  Public Property Let Item(newword)
      val = newword
  End Property
End Class

function encodeAsBase64(item)
  Dim obj
  Set obj = New Base64_Wrapper
  obj.item=item
  set encodeAsBase64=obj
end function

' Given a VB object, determine its type
' and wrap it in XML tags. Calls addTxt to
' manipulate global xmlTxt
sub addItem(itm)

	' This mistakenly added empty "<string>" tags
	' for null and empty variables
  'response.write VarType(itm) & " " & vbArray
	Select Case VarType(itm)

		Case vbEmpty

		Case vbNull

		Case vbNothing

		Case vbInteger
			addTxt "<value>"
			addTxt "<i4>" & itm & "</i4>"
			addTxt "</value>"

		Case vbLong
			addTxt "<value>"
			addTxt "<i4>" & itm & "</i4>"
			addTxt "</value>"

           Case vbDecimal
                  addTxt "<value>"
                  addTxt "<i4>" & itm & "</i4>"
                  addTxt "</value>"

		Case vbSingle
			addTxt "<value>"
			addTxt "<double>" & itm & "</double>"
			addTxt "</value>"

		Case vbDouble
			addTxt "<value>"
			addTxt "<double>" & itm & "</double>"
			addTxt "</value>"

		Case vbCurrency
			addTxt "<value>"
			addTxt "<double>" & itm & "</double>"
			addTxt "</value>"

		Case vbDate
			addTxt "<value>"
			addTxt 	"<dateTime.iso8601>" _
				& Year(itm) _
				& dateToText(Month(itm)) _
				& dateToText(Day(itm))_
				& "T" _
				& dateToText(Hour(itm)) _
				& ":" _
				& dateToText(Minute(itm)) _
				& ":" _
				& dateToText(Second(itm)) _
				& "</dateTime.iso8601>"
			addTxt "</value>"

		Case vbString
			addTxt "<value>"
			' Whoops! These replaces were the wrong way
			' round - think about it.
			' should > ' and " also be fixed
			' (not in spec, but is part of XML spec)
			itm = Replace(itm, "&", "&amp;", 1, -1, 1)
			itm = Replace(itm, "<", "&lt;", 1, -1, 1)
			itm = Replace(itm, ">", "&gt;", 1, -1, 1)
			itm = Replace(itm, "'", "&apos;", 1, -1, 1)
			itm = Replace(itm, """", "&quot;", 1, -1, 1)

			' if we were able to use Response.BinaryWrite
			' here I think we'd be fine,
			' but how do we detect a binary object?
			addTxt "<string>" & itm & "</string>"
			addTxt "</value>"

		Case vbObject
			addTxt "<value>"
			if TypeName(itm)="Dictionary" then
				addTxt "<struct>"
				Dim a, b
				a=itm.keys
				b=itm.items
				for x = 0 to itm.count-1
					addTxt "<member>"
					addTxt "<name>" & a(x) & "</name>"
					addItem b(x)
					addTxt "</member>"
				next
				addTxt "</struct>"

			elseif TypeName(itm)="Recordset" then
				addTxt "<array>"
				addTxt "<data>"
				Do While Not itm.EOF
					' was missing the value tags which are a necessary
					' part of an array.
					addTxt "<value>"
					addTxt "<struct>"
					for each whatever in itm.fields
						addTxt "<member>"
						addTxt "<name>" & _
	                                               whatever.name & _
	                                               "</name>"
						addItem whatever.value
						addTxt "</member>"
					next
					addTxt "</struct>"
					addTxt "</value>"
					itm.MoveNext
					Loop
				addTxt "</data>"
				addTxt "</array>"
			elseif TypeName(itm)="Base64_Wrapper" then
			   set base64=Server.createObject("Base64Lib.Base64")
			   addTxt "<base64>" _
				  & base64.Encode(itm.item) _
				  & "</base64>"

				' addItem base64.Encode(itm)
				' Oh, this is funny how long this bug
				' was here
				set base64=nothing
			else
				set base64 = _
				  Server.createObject("Base64Lib.Base64")
				addTxt "<base64>" _
					& base64.Encode(itm) _
					& "</base64>"
				' addItem base64.Encode(itm)
				' Oh, this is funny how long
				' this bug was here
				set base64=nothing
			end if
			addTxt "</value>"

		Case vbBoolean
			addTxt "<value>"
			addTxt "<boolean>" & -1*CInt(itm) & "</boolean>"
			addTxt "</value>"

		Case vbByte
			addTxt "<value>"
			addTxt "<int>" & CInt(itm) & "</int>"
			addTxt "</value>"

		Case Else
			addTxt "<value>"
			if VarType(itm) > vbArray then
				addTxt "<array>"
				addTxt "<data>"

				for x = 0 to Ubound(itm, 1)
					addItem itm(x)
			 	next
				addTxt "</data>"
				addTxt "</array>"
			else
				' This was a string, but should the
				' default behavior be base64
				' which is much safer?
				'itm = Replace(itm, "&", "&amp;", 1, -1, 1)
				'itm = Replace(itm, "<", "&lt;", 1, -1, 1)
				'itm = Replace(itm, ">", "&gt;", 1, -1, 1)
				'itm = Replace(itm, "'", "&apos;", 1, -1, 1)
				'itm = Replace(itm, """", "&quot;", 1, -1, 1)
				'addTxt "<string>" & itm  & "</string>"

				set base64 = _
				    Server.createObject("Base64Lib.Base64")

				addTxt "<base64>" _
					& base64.Encode(itm) _
					& "</base64>"

				' addItem base64.Encode(itm)
				' Oh, this is funny how long
				' this bug was here
				set base64=nothing
			end if
			addTxt "</value>"

		'Not covered: vbError, vbVariant, vbDataObject
	End Select
end sub

' addendum to string conversion for recognized entities
function convertStr(str)
	convertStr=CStr(str)
	convertStr=Replace(convertStr, "&quot;", """", 1, -1, 1)
	convertStr=Replace(convertStr, "&apos;", "'", 1, -1, 1)
	convertStr=Replace(convertStr, "&gt;", ">", 1, -1, 1)
	convertStr=Replace(convertStr, "&lt;", "<", 1, -1, 1)
	convertStr=Replace(convertStr, "&amp;", "&", 1, -1, 1)
end function


' Extract values VB can use from XML input
' Tries to return an object of the appropriate type
function XMLToValue(xmlNd)

	XMLToValue= Null
		
	if xmlNd.childNodes.length > 0 then
		if NOT xmlNd.childNodes(0).nodeType = 3 then
			Select Case xmlNd.childNodes(0).tagName
		    
      			Case "int"
      				XMLToValue=CLng(xmlNd.childNodes(0).text)
		    
      			Case "i4"
      				' changed CInt to CLng for values over 32K ?
      				XMLToValue=CLng(xmlNd.childNodes(0).text)
		    
      			Case "boolean"
      				XMLToValue=CBool(xmlNd.childNodes(0).text)
		    
      			Case "string"
      				XMLToValue=convertStr(xmlNd.childNodes(0).text)
		    
      			Case "double"
      				XMLToValue=CDbl(xmlNd.childNodes(0).text)
		    
      			Case "dateTime.iso8601"
      				Dim dt,val
      				dt=xmlNd.childNodes(0).text
      				val = 	CDate(mid(dt, 1, 4) & "/"  _
      					& mid(dt, 5, 2) _
      					& "/" & mid(dt, 7, 2))
      				XMLToValue = dateadd("h", CInt(mid(dt, 10, 2)), val)
      				XMLToValue = dateadd("n", CInt(mid(dt, 13, 2)), val)
      				XMLToValue = dateadd("s", CInt(mid(dt, 16, 2)), val)
      				XMLToValue = val
		    
      			Case "array"
					dim arrLen
		  			arrLen = xmlNd.childNodes(0).childNodes(0).childNodes.length
					'response.write "**"&arrLen
		    
      				Dim valArr()
      				ReDim valArr(arrLen-1)
		    
      				dim i
      				For  i = 0 to arrLen-1
      					' Might get back a Dictionary
      					Dim tmp
      						Set tmp = capture_eval( XMLToValue( _
      					xmlNd.childNodes(0).childNodes(0).childNodes(i) ))
		    
      					if tmp.Item("is_object") Then
      					Set valArr(i) = tmp.Item("data")
      					Else
      					valArr(i) = tmp.Item("data")
      					End If
		    
      				Next
		    
      				XMLToValue = valArr
		    
      			Case "struct"
      				' How/when do we destroy this?
      				Set val = Server.CreateObject("Scripting.Dictionary")
      				Dim dictLen
		    
      				dictLen = xmlNd.childNodes(0).childNodes.length
      				For k = 0 to dictLen-1
      						'Add keys and items to dictionary
      				val.Add xmlNd.childNodes(0).childNodes(k).childNodes(0).text, _
	      			XMLToValue(xmlNd.childNodes(0).childNodes(k).childNodes(1))
		    
      				Next
		    
      				Set XMLToValue = val
		    
      			Case "base64"
      				set base64=Server.createObject("Base64Lib.Base64")
      				XMLToValue = base64.Decode(xmlNd.childNodes(0).text)
      				set base64=nothing
		    
      		End Select
		else
			XMLToValue=convertStr(xmlNd.text)
		end if
	end if
end function

' ----- Client only functions -----
' Wrap the incoming method and args into XML
' Return new XML request in xmlText
function functionToXML(methodName, paramArr)
	dim i
  
	' Clear the global return string
	xmlText=""

	' Begin header, method call
	addTxt  "<?xml version=""1.0""?>" _
		& "<methodCall>" _
		& "<methodName>" _
		& methodName  _
		& "</methodName>" _

	' If we have arguments, add them
	addTxt "<params>"
	if UBound(paramArr, 1)>=0 then
		for i = 0 to UBound(paramArr, 1)
			If Not IsEmpty(paramArr(i)) Then
			   addTxt "<param>"
			   addItem paramArr(i)
			   addTxt "</param>"
			End IF
		next
	end if
	addTxt "</params>"
	addTxt "</methodCall>"

	functionToXML = xmlText		' returning a global variable for convenience
end function

' -- Server Functions --

' Called by clients, this "public" function passes
' method calls and arguments to be wrapped up in XML,
' the requested method called, the response returned
' appropriately.
function xmlRPC(url, methodName, paramArr)
	Dim requestText
	'on error resume next
	err.Clear

	' go from simple ASCII to xmlrpc
	' Create the requestBody from the methodName and paramArr
	requestText = functionToXML(methodName, paramArr)
	'response.write "Preparing to send: " & server.htmlencode(requestText)
	'requestText = ""
  
	' Now use the redistributable parser objects alone
	' including server-safe XMLHTTP (yippee!)
	Set objXML = Server.CreateObject("MSXML2.ServerXMLHTTP")
	call objXML.setTimeouts(XRPC_RESOLVE_TIMEOUT, XRPC_CONNECT_TIMEOUT, XRPC_SEND_TIMEOUT, XRPC_RECEIVE_TIMEOUT)
	Set objLst = Server.CreateObject("MSXML2.DOMDocument")

	' Call the remote machine the request
	objXML.open "POST", url, false
	'response.Write url
	'response.Write err
	' This is necessary for some implementations (ZOPE).
	' Fixed April 24th, 2001 capitalization
	objXML.setRequestHeader "Content-Type", "text/xml"
	objXML.send(requestText)
	'response.Write objXML.status
	if objXML.status = "404" then err.raise XERR_NOSERVER
	'response.Write "bye"
	'response.Write err
	' when the server is a client, we don't want to write
	' xml, we want to raise an error.
	Call catchClientError( 1, "XMLHTTP object creation" )

	'Extract data from XML response
	serverResponseText = objXML.responseText
	'response.write server.htmlencode(serverresponsetext)
	' Here and further on in this function
	' you're call the writeFaultXML sub
	' but in this function, we're the client.
	' Should we just err.raise and let
	' the coder get a standard error message?
	' Why write XML to a web page?
	'
	' You're right. This error should be handled
	' better --jjohn

	' let's check those pesky HTTP headers
	If not objXML.status = 200 Then
	   Call catchClientError(objXML.status, "Problem on remote machine [" _
			      & serverResponseText & "]" _
			      & "xmlRPC(1.5)")
	End If

	If objXML.responseXML.parseError.errorCode <> 0 Then
		Call catchClientError(objXML.responseXML.parseError.errorCode, _
			  "There was an error parsing the response " _
			  & "from " & methodName _
			  & " xml {" &  serverResponseText _
			  & "} received from " _
			  & url _
			  & "*" & requestText & "* & vbnewline & xmlRPC(2)" )
	End If

	' Parsing response. There ought to be some response.
	Set objLst = objXML.responseXML.getElementsByTagName("param")

	If objLst.length = 0 Then
		' There were *no* <param> tags passed back
		Set objLst = objXML.responseXML.getElementsByTagName("member")

		Call catchClientError(999, " [The server at " _
			& url 			               _
			& " generated the following error]: <p>"   _
			& "[request: " & requestText & "]<p>"     _
			& "<BR>[answer: " & serverResponseText & "]" _
			& "xmlRPC(4)")

	else
		' If I have a struct, make sure the vbDictionary
		' gets assigned correctly for this function's return
		' value
		Dim tmp
		Set tmp = capture_eval(XMLToValue(objLst.item(0).childNodes(0)))
		If tmp.Item("is_object") Then
		   Set xmlRPC = tmp.Item("data")
		   Set xmlRpcReturnValue = xmlRpc
		Else
		   xmlRPC = tmp.Item("data")
		   xmlRpcReturnValue = xmlRpc
		End If

	end if

	'Kill everything
	Set objXML = Nothing
	Set objLst = Nothing

	requestText=""
end function

' ----- Server only functions -----
' Wrap response from method into XML
' return to requester
function returnValueToXML(returnVal)
	xmlText=""

	' I think we need to worry about character encoding here
	' e.g.  encoding=""UTF-16""?>

	addTxt "<?xml version=""1.0""?>"
	addTxt "<methodResponse>"
	addTxt "<params>"
	addTxt "<param>"
	addItem returnVal
	addTxt "</param>"
	addTxt "</params>"
	addTxt "</methodResponse>"
	returnValueToXML = xmlText
end function

' In case of error, send a note
' in XML
function writeFaultXML(errNum, errDesc, from)
	xmlText=""

	addTxt 	"<?xml version=""1.0""?>" _
	       	& "<methodResponse>" _
		& "<fault>" _
		& "<value>" _
		& "<struct>" _
		& "<member>" _
		& "<name>faultCode</name><value><int>" _
		& errNum _
		& "</int></value>" _
		& "</member>" _
		& "<member>" _
		& "<name>faultString</name><value><string>" _
		& Server.HTMLEncode(errDesc) & " : " & from _
		& "</string></value>" _
		& "</member>" _
		& "</struct>" _
		& "</value>" _
		& "</fault>" _
		& "</methodResponse>"

	response.write(xmlText)
	response.end
end function


sub addServerFunction(functionName, exposedName)
	serverMappings.Add functionName, exposedName
end sub

' Called by server (listener) piece.
sub rpcserver()
	dim i
  
	Response.ContentType = "text/XML"
	'on error resume next

	' REMOVED - Recall you'll need IE 5.x DLLs here
	' Set objserveXML = Server.CreateObject("Microsoft.XMLDOM")
	' Set objserveLst = Server.CreateObject("Microsoft.XMLDOM")

	' Now use the MS redistributable parser alone
	Set objserveXML = Server.CreateObject("MSXML2.DOMDocument")
	Set objserveLst = Server.CreateObject("MSXML2.DOMDocument")

	objserveXML.async=false
	objserveXML.load(Request)

	'Extract parameters and function from XML
	Dim returnArr(2)
	If objserveXML.parseError.errorCode <> 0 Then
	   Call writeFaultXML(objserveXML.parseError.errorCode, _
			"error parsing the xml passed to the server", _
			"rpcserver(1)" )

	Else

	   ' procedure to call
           returnArr(0) = objserveXML.childNodes(1).childNodes(0).text

	   ' is it valid and does it map to something
	   if serverMappings.exists(returnArr(0)) then
		returnArr(0)=serverMappings.item(returnArr(0))
		set serverMappings=nothing
	   else
		set serverMappings=nothing
		Call writeFaultXML("1.2", "No such function", _
	                   "This is not a valid function call for this server" )
	   end if

	   ' Placeholder for args (good when params are lacking
	   dim placeholder(1)
	   returnArr(1) = placeholder

    	   ' Argument list
	   ' This could be a zero length list
	   Set objserveLst = objserveXML.getElementsByTagName("param")

	   If (objserveLst.length > 0 ) Then
	      Dim argList()

	      ReDim argList(objserveLst.length)

	      For i = 0 to objserveLst.length - 1
	        ' Make sure I have the correct assignment
	        ' if I get an object!
		Dim tmp
		Set tmp = capture_eval(XMLToValue( _
				objserveLst.item(i).childNodes(0)))

		If tmp.Item("is_object") Then
		  Set argList(i) = tmp.Item("data")
		Else
                  argList(i) = tmp.Item("data")
		End If

	        Call catchError ("rpcserver(1.5): args to XML " _
				 & "[value was " _
				 & typename(argList(i))_
				 & "]"_
				)
	      Next

	      returnArr(1) = argList
	   End if

        End If

	' "free" objects
	set objserveXML = nothing
	set objserveLst = nothing
	Call catchError("rpcserver(2): freeing objects ")

	Dim returnVal, stringToEval
	'on error resume next

	if NOT returnArr(0) = "" then

		' A function has been specified, build the call

		' HOWEVER, not all functions will be called with
		' parameters. In this case, the eval string must
		' not have any parameters either (even empty ones)
		stringToEval = returnArr(0) & "("

		If not IsEmpty(returnArr(1)(0)) Then
			' recall that the params are in an array in the
			' second element of the array

			for j = 0 to UBound(returnArr(1), 1) - 1
		      		stringToEval = stringToEval      _
					       & "returnArr(1)(" _
			        	       & j               _
				     	       & "),"
       			next

			' Remove trailing comma
			If Right(stringToEval, 1)="," Then
			   stringToEval = Left(stringToEval, _
					  Len(stringToEval)-1)
			End If

		End If

		stringToEval = stringToEval & ")"

		' Function call is built up, let's try to call it
		' Ok. If the function returns an object
		' (like a dictionary)

		Dim eval_ret
		Set eval_ret = capture_eval( eval(stringToEval) )

		Call catchError("rpcserver(3)(return from eval) :[" _
				& " in function "      _
				& returnArr(0)         _
				& " {evaled string: "  _
				& server.htmlencode(stringToEval) & "}"   _
				& "{returnArr(1)(0) was " _
				& typename(returnArr(1)(0)) _
				& "}" _
				& " (TypeName was: "   _
				& TypeName(eval_ret)   _
				& ")" _
				& "]")

		returnVal    = returnValueToXML( eval_ret.Item("data") )

		Call catchError("rpcserver(4) :[" _
				& " in function " _
				& stringToEval    _
				& "]"             _
				& "{arg 1: "      _
				& TypeName(returnArr(1)(0)) _
				& "}"             _
			       )
		response.write(returnVal)

		' Not sure this is necessary?
		set eval_ret=nothing
		' Also wonder whether we should use the
		' capture_eval technique
		' with XMLTovalue since we test XMLToValue
		' in multiple places.
	Else

	End If
	Call catchError("rpcserver(5) :[" _
				& " in function " _
				& stringToEval    _
				& "]"             _
				& "{arg 1: "      _
				& TypeName(returnArr(1)(0)) _
				& "}"             _
			       )
end sub
sub catchError(from)
	if err.number=0 then
		exit sub
	end if
	Call writeFaultXML(err.number, err.description, _
	                   from )
end sub

sub catchClientError(from, desc)
	if err.number=0 then
		exit sub
	end if
	err.raise from, desc
end sub

function capture_eval( eval_in )
' This is a workaround to capture the arbitrary return value
' from an eval statement and use the *right* assignment operator.
' This function returns a dictionary object which has two fields
' - is_object: 1 if the returned data is an object, 0 otherwise
' - data:      whatever the actual return of the eval was

  Dim ret
  Set ret = Server.CreateObject("Scripting.Dictionary")

  ret.Add "data", eval_in

  If VarType( ret.Item("data") ) = 9 Then
	ret.Add "is_object", 1
  Else
	ret.Add "is_object", 0
  End If

  Set capture_eval = ret
end function
%>
