<?php
if (!defined("EgoiApiRestImpl")) {
	define("EgoiApiRestImpl",0);

	require_once "Zend/Rest/Client.php";
	require_once "Zend/Json.php";
	
	define('RestUrl', 'http://api.e-goi.com/');
	define('RestPath', '/v2/rest.php');
	
	class EgoiApiRestImpl extends EgoiApi {
		
		var $rpc;
		
		function __construct() {
			$this->rpc = $c = new Zend_Rest_Client(RestUrl);
		}
		
		function buildParams($method, $arguments) {
			return array(
				"method" => $method,
				"functionOptions" => $arguments,
				"type" => "json"
			);
		}
		
		function call($method, $map) {
			$params = $this->buildParams($method, $map);
			$resp = $this->rpc->restGet(RestPath, $params);
			$body = $resp->getBody();

			// if body is empty return empty array
			if(strlen($body) == 0)
				return array();

			$map = Zend_Json::decode($body, Zend_Json::TYPE_ARRAY);
			$map = $map["Egoi_Api"][$method];
			unset($map['status']);
			return $this->walkMap($map);
		}
		
		function walkMap($map) {
			if(array_key_exists("key_0", $map)) {
				$mrl = array();
				foreach($map as $k => $v) {
					if(strpos($k, "key_") != 0) continue;
					$mrl[] = $this->walkValues($v);
				}
				return $mrl;
			} else {
				return $this->walkValues($map);
			}
		}
		
		function walkValues($map) {
			if(is_array($map))
				foreach($map as $k => $v) {
					if(is_array($v))
						$map[$k] = $this->walkMap($v);
				}
			return $map;
		}
		
		function addExtraField($map) {
			return $this->call(__FUNCTION__, $map);
		}
		
		
		function addSubscriber($map) {
			return $this->call(__FUNCTION__, $map);
		}
		
		
		function addSubscriberBulk($map) {
			return $this->call(__FUNCTION__, $map);
		}
		
		
		function checklogin($map) {
			return $this->call(__FUNCTION__, $map);
		}
		
		
		function createCampaignEmail($map) {
			return $this->call(__FUNCTION__, $map);
		}
		
		
		function createCampaignFAX($map) {
			return $this->call(__FUNCTION__, $map);
		}
		
		
		function createCampaignSMS($map) {
			return $this->call(__FUNCTION__, $map);
		}
		
		
		function createCampaignVoice($map) {
			return $this->call(__FUNCTION__, $map);
		}
		
		
		function createList($map) {
			return $this->call(__FUNCTION__, $map);
		}
		
		
		function createSegment($map) {
			return $this->call(__FUNCTION__, $map);
		}
		
		
		function deleteCampaign($map) {
			return $this->call(__FUNCTION__, $map);
		}
		
		
		function deleteSegment($map) {
			return $this->call(__FUNCTION__, $map);
		}
		
		
		function editCampaignEmail($map) {
			return $this->call(__FUNCTION__, $map);
		}
		
		
		function editCampaignSMS($map) {
			return $this->call(__FUNCTION__, $map);
		}
		
		
		function editExtraField($map) {
			return $this->call(__FUNCTION__, $map);
		}
		
		
		function editSubscriber($map) {
			return $this->call(__FUNCTION__, $map);
		}
		
		
		function getCampaigns($map) {
			return $this->call(__FUNCTION__, $map);
		}
		
		
		function getClientData($map) {
			return $this->call(__FUNCTION__, $map);
		}
		
		
		function getCredits($map) {
			return $this->call(__FUNCTION__, $map);
		}
		
		
		function getLists($map) {
			return $this->call(__FUNCTION__, $map);
		}
		
		
		function getReport($map) {
			return $this->call(__FUNCTION__, $map);
		}
		
		
		function getSegments($map) {
			return $this->call(__FUNCTION__, $map);
		}
		
		
		function getSenders($map) {
			return $this->call(__FUNCTION__, $map);
		}
		
		
		function getUserData($map) {
			return $this->call(__FUNCTION__, $map);
		}
		
		
		function removeSubscriber($map) {
			return $this->call(__FUNCTION__, $map);
		}
		
		
		function sendCall($map) {
			return $this->call(__FUNCTION__, $map);
		}
		
		
		function sendEmail($map) {
			return $this->call(__FUNCTION__, $map);
		}
		
		
		function sendFAX($map) {
			return $this->call(__FUNCTION__, $map);
		}
		
		
		function sendSMS($map) {
			return $this->call(__FUNCTION__, $map);
		}
		
		
		function subscriberData($map) {
			return $this->call(__FUNCTION__, $map);
		}
		
		
		function updateList($map) {
			return $this->call(__FUNCTION__, $map);
		}
	}
	
}
?>