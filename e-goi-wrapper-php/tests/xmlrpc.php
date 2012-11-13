<?php

	openlog("myScriptLog", LOG_PID | LOG_PERROR, LOG_LOCAL0);
	// syslog(LOG_WARNING, "request:\n" . print_r($_GET, true));

	require_once 'Zend/XmlRpc/Server.php';
	require_once 'Zend/XmlRpc/Request.php';
	
	header('Content-Type: text/xml; charset=UTF-8');
	
	class EgoiApi {
		
		/**
		 * Obter as listas a que o utilizador tem acesso
		 * @param struct $functionOptions
		 * @return mixed
		 */
		function getLists($functionOptions = array()) {
			return array(
				array(
					"ID" => "1",
					"Name" => "Foo List"
				),
				array(
					"ID" => "2",
					"Name" => "Bar List"
				)
			);
		}

	}
	
	
	$server = new Zend_XmlRpc_Server();
	$server->setClass('EgoiApi');
	
	/**
	* @tutorial check and change encoding to utf8 if needed
	*/
	$xml = @file_get_contents('php://input');
	
	/*
	if(!mb_check_encoding($xml, 'UTF-8') || !($xml === mb_convert_encoding(mb_convert_encoding($xml, 'UTF-32', 'UTF-8' ), 'UTF-8', 'UTF-32'))) {
		$xml = mb_convert_encoding($xml, 'UTF-8');
	}
	*/
	
	$request = new Zend_XmlRpc_Request();
	@$request->loadXml($xml);
	
	syslog(LOG_INFO, "request=$xml");
	try {
		$response = $server->handle($request);
		syslog(LOG_INFO, "resp=$response");
	} catch (Exception $e) {
		syslog(LOG_ERR, $e->getMessage());
		
	}
	
	echo $response;
?>