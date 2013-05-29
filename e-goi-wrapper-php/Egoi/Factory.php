<?php
if (!defined("EgoiApiFactory")) {
	define("EgoiApiFactory",0);
	
	require_once "Api.php";
	require_once "RestImpl.php";
	require_once "SoapImpl.php";
	require_once "XmlRpcImpl.php";
	
	abstract class EgoiApiFactory {
	
		static function getApi($protocol) {
			switch($protocol) {
				case Protocol::Rest:
					return new EgoiApiRestImpl();
				case Protocol::Soap;
					return new EgoiApiSoapImpl();
				case Protocol::XmlRpc:
					return new EgoiApiXmlRpcImpl();
			}
		}
	
	}
	
}
?>