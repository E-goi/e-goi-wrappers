<%@ Language=VBScript %>
<!DOCTYPE html>
<html>
	<head>
		<title>Asp Test</title>
	</head>
	<body>

<!--#include virtual="egoi.asp" -->
<%

' Create the paramater dictionary
set params = EgoiApi.Dictionary
with params
	.Add "apikey", "<api key>"    'replace the <api key> with the api key that you can get from e-goi backoffice
end with

' Call 'getUserData' using the API
set resp = EgoiApi.getUserData(params)

' Show the result
for each item in resp.Keys
	response.write(item & "=" & resp.Item(item) & "<br/>")
next

%>
	</body>
</html>
