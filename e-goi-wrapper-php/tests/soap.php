<?php
	require_once "Zend/Soap/AutoDiscover.php";
	require_once "Zend/Soap/Server.php";
	require_once "Zend/Soap/Wsdl/Strategy/AnyType.php";
	require_once "Zend/Soap/Wsdl/Strategy/ArrayOfTypeComplex.php";
	
	openlog("myScriptLog", LOG_PID | LOG_PERROR, LOG_LOCAL0);
	
	syslog(LOG_WARNING, "request:\n" . print_r($_REQUEST, true));
	
	class Foo {
		var $test;
	}
	
	class EgoiApi {
		
		/**
		 * Verificar o status
		 * @return Foo
		 */
		function status() {
			$f = new Foo();
			$f->test = "bla";
			return $f;
		}
		
		/**
		 * Obter as listas do utilizador
		 * @return
		 */
		function getLists(array $functionOptions) {
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

	if(isset($_GET['wsdl'])) {
		$server = new Zend_Soap_AutoDiscover();
		$server->setComplexTypeStrategy("Zend_Soap_Wsdl_Strategy_AnyType");
		// $server->setComplexTypeStrategy("Zend_Soap_Wsdl_Strategy_ArrayOfTypeComplex");
	} else {
		$server = new Zend_Soap_Server("http://" . $_SERVER[HTTP_HOST] . $_SERVER[SCRIPT_NAME] . "?wsdl");
	}
	$output = $server->setClass("EgoiApi");
	try {
		$server->handle();
	} catch (Exception $e) {
		syslog(LOG_ERR, $e->getMessage());
	}
?>