<?php
if (!defined("EgoiApiSoapImpl")) {
	define("EgoiApiSoapImpl",0);

	require_once 'Zend/Soap/Client.php';
	
	define('SoapUrl', 'http://api.e-goi.com/v2/soap_any.php?wsdl');
	
	class EgoiApiSoapImpl extends EgoiApi {
		
		var $rpc;

		function __construct() {
			$this->rpc = new Zend_Soap_Client(SoapUrl);
		}
		
		function addExtraField($map) {
			$fn = __FUNCTION__;
			return $this->rpc->$fn($map);
		}
		
		
		function addSubscriber($map) {
			$fn = __FUNCTION__;
			return $this->rpc->$fn($map);
		}
		
		
		function addSubscriberBulk($map) {
			$fn = __FUNCTION__;
			return $this->rpc->$fn($map);
		}
		
		
		function checklogin($map) {
			$fn = __FUNCTION__;
			return $this->rpc->$fn($map);
		}
		
		
		function createCampaignEmail($map) {
			$fn = __FUNCTION__;
			return $this->rpc->$fn($map);
		}
		
		
		function createCampaignFAX($map) {
			$fn = __FUNCTION__;
			return $this->rpc->$fn($map);
		}
		
		
		function createCampaignSMS($map) {
			$fn = __FUNCTION__;
			return $this->rpc->$fn($map);
		}
		
		
		function createCampaignVoice($map) {
			$fn = __FUNCTION__;
			return $this->rpc->$fn($map);
		}
		
		
		function createList($map) {
			$fn = __FUNCTION__;
			return $this->rpc->$fn($map);
		}
		
		
		function createSegment($map) {
			$fn = __FUNCTION__;
			return $this->rpc->$fn($map);
		}
		
		
		function deleteCampaign($map) {
			$fn = __FUNCTION__;
			return $this->rpc->$fn($map);
		}
		
		
		function deleteSegment($map) {
			$fn = __FUNCTION__;
			return $this->rpc->$fn($map);
		}
		
		
		function editCampaignEmail($map) {
			$fn = __FUNCTION__;
			return $this->rpc->$fn($map);
		}
		
		
		function editCampaignSMS($map) {
			$fn = __FUNCTION__;
			return $this->rpc->$fn($map);
		}
		
		
		function editExtraField($map) {
			$fn = __FUNCTION__;
			return $this->rpc->$fn($map);
		}
		
		
		function editSubscriber($map) {
			$fn = __FUNCTION__;
			return $this->rpc->$fn($map);
		}
		
		
		function getCampaigns($map) {
			$fn = __FUNCTION__;
			return $this->rpc->$fn($map);
		}
		
		
		function getClientData($map) {
			$fn = __FUNCTION__;
			return $this->rpc->$fn($map);
		}
		
		
		function getCredits($map) {
			$fn = __FUNCTION__;
			return $this->rpc->$fn($map);
		}
		
		
		function getLists($map) {
			$fn = __FUNCTION__;
			return $this->rpc->$fn($map);
		}
		
		
		function getReport($map) {
			$fn = __FUNCTION__;
			return $this->rpc->$fn($map);
		}
		
		
		function getSegments($map) {
			$fn = __FUNCTION__;
			return $this->rpc->$fn($map);
		}
		
		
		function getSenders($map) {
			$fn = __FUNCTION__;
			return $this->rpc->$fn($map);
		}
		
		
		function getUserData($map) {
			$fn = __FUNCTION__;
			return $this->rpc->$fn($map);
		}
		
		
		function removeSubscriber($map) {
			$fn = __FUNCTION__;
			return $this->rpc->$fn($map);
		}
		
		
		function sendCall($map) {
			$fn = __FUNCTION__;
			return $this->rpc->$fn($map);
		}
		
		
		function sendEmail($map) {
			$fn = __FUNCTION__;
			return $this->rpc->$fn($map);
		}
		
		
		function sendFAX($map) {
			$fn = __FUNCTION__;
			return $this->rpc->$fn($map);
		}
		
		
		function sendSMS($map) {
			$fn = __FUNCTION__;
			return $this->rpc->$fn($map);
		}
		
		
		function subscriberData($map) {
			$fn = __FUNCTION__;
			return $this->rpc->$fn($map);
		}
		
		
		function updateList($map) {
			$fn = __FUNCTION__;
			return $this->rpc->$fn($map);
		}
	}
	
}
?>