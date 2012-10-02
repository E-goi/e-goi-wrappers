<?php
if (!defined("EgoiApi")) {
	define("EgoiApi",0);

	abstract class Protocol {
		const Soap = 1;
		const Rest = 2;
		const XmlRpc = 3;
	}
	
	abstract class EgoiApi {

		abstract public function addExtraField($map);


		abstract public function addSubscriber($map);


		abstract public function addSubscriberBulk($map);


		abstract public function checklogin($map);


		abstract public function createCampaignEmail($map);


		abstract public function createCampaignFAX($map);


		abstract public function createCampaignSMS($map);


		abstract public function createCampaignVoice($map);


		abstract public function createList($map);


		abstract public function createSegment($map);


		abstract public function deleteCampaign($map);


		abstract public function deleteSegment($map);


		abstract public function editCampaignEmail($map);


		abstract public function editCampaignSMS($map);


		abstract public function editExtraField($map);


		abstract public function editSubscriber($map);


		abstract public function getCampaigns($map);


		abstract public function getClientData($map);


		abstract public function getCredits($map);


		abstract public function getLists($map);


		abstract public function getReport($map);


		abstract public function getSegments($map);


		abstract public function getSenders($map);


		abstract public function getUserData($map);


		abstract public function removeSubscriber($map);


		abstract public function sendCall($map);


		abstract public function sendEmail($map);


		abstract public function sendFAX($map);


		abstract public function sendSMS($map);


		abstract public function subscriberData($map);


		abstract public function updateList($map);

	}

}
?>