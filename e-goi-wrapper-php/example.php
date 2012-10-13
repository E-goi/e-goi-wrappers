<pre>
<?php
	
	require_once 'Egoi/Factory.php';

	$apikey = "<api key>";
	
	$arguments = array(
		"apikey" => $apikey
	);
	
	// $api = EgoiApiFactory::getApi(Protocol::Soap);
	// $api = EgoiApiFactory::getApi(Protocol::Rest);
	$api = EgoiApiFactory::getApi(Protocol::XmlRpc);
	$result = $api->getUserData($arguments);
	print_r($result);
	
?>
</pre>
