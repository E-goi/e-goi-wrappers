<?php
if (!defined("EgoiApiXmlRpcImpl")) {
	define("EgoiApiXmlRpcImpl",0);

	require_once 'Zend/XmlRpc/Client.php';
	
	define('XmlRpcUrl', 'http://api.e-goi.com/v2/xmlrpc.php');
	
	class EgoiApiXmlRpcImpl extends EgoiApi {

		var $rpc;
		
		function __construct() {
			$this->rpc = new Zend_XmlRpc_Client(XmlRpcUrl);
		}
		
		function addExtraField($map) {
			return $this->rpc->call(__FUNCTION__, array($map));
		}
		
		function addSubscriber($map) {
			return $this->rpc->call(__FUNCTION__, array($map));
		}
		
		
		function addSubscriberBulk($map) {
			return $this->rpc->call(__FUNCTION__, array($map));
		}
		
		
		function checklogin($map) {
			return $this->rpc->call(__FUNCTION__, array($map));
		}
		
		
		function createCampaignEmail($map) {
			return $this->rpc->call(__FUNCTION__, array($map));
		}
		
		
		function createCampaignFAX($map) {
			return $this->rpc->call(__FUNCTION__, array($map));
		}
		
		
		function createCampaignSMS($map) {
			return $this->rpc->call(__FUNCTION__, array($map));
		}
		
		
		function createCampaignVoice($map) {
			return $this->rpc->call(__FUNCTION__, array($map));
		}
		
		
		function createList($map) {
			return $this->rpc->call(__FUNCTION__, array($map));
		}
		
		
		function createSegment($map) {
			return $this->rpc->call(__FUNCTION__, array($map));
		}
		
		
		function deleteCampaign($map) {
			return $this->rpc->call(__FUNCTION__, array($map));
		}
		
		
		function deleteSegment($map) {
			return $this->rpc->call(__FUNCTION__, array($map));
		}
		
		
		function editCampaignEmail($map) {
			return $this->rpc->call(__FUNCTION__, array($map));
		}
		
		
		function editCampaignSMS($map) {
			return $this->rpc->call(__FUNCTION__, array($map));
		}
		
		
		function editExtraField($map) {
			return $this->rpc->call(__FUNCTION__, array($map));
		}
		
		
		function editSubscriber($map) {
			return $this->rpc->call(__FUNCTION__, array($map));
		}
		
		
		function getCampaigns($map) {
			return $this->rpc->call(__FUNCTION__, array($map));
		}
		
		
		function getClientData($map) {
			return $this->rpc->call(__FUNCTION__, array($map));
		}
		
		
		function getCredits($map) {
			return $this->rpc->call(__FUNCTION__, array($map));
		}
		
		
		function getLists($map) {
			return $this->rpc->call(__FUNCTION__, array($map));
		}
		
		
		function getReport($map) {
			return $this->rpc->call(__FUNCTION__, array($map));
		}
		
		
		function getSegments($map) {
			return $this->rpc->call(__FUNCTION__, array($map));
		}
		
		
		function getSenders($map) {
			return $this->rpc->call(__FUNCTION__, array($map));
		}
		
		
		function getUserData($map) {
			return $this->rpc->call(__FUNCTION__, array($map));
		}
		
		
		function removeSubscriber($map) {
			return $this->rpc->call(__FUNCTION__, array($map));
		}
		
		
		function sendCall($map) {
			return $this->rpc->call(__FUNCTION__, array($map));
		}
		
		
		function sendEmail($map) {
			return $this->rpc->call(__FUNCTION__, array($map));
		}
		
		
		function sendFAX($map) {
			return $this->rpc->call(__FUNCTION__, array($map));
		}
		
		
		function sendSMS($map) {
			return $this->rpc->call(__FUNCTION__, array($map));
		}
		
		
		function subscriberData($map) {
			return $this->rpc->call(__FUNCTION__, array($map));
		}
		
		
		function updateList($map) {
			return $this->rpc->call(__FUNCTION__, array($map));
		}
	}
	
}
?>