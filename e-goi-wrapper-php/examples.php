<pre>
<?php
	
	require_once 'Egoi/Factory.php';

	$apikey = "d7cdcc90c0547da5da90c3e14eeff180455c38a2";
	
	$arguments = array(
		"apikey" => $apikey
	);
	
	$api = EgoiApiFactory::getApi(Protocol::Rest);
	$result = $api->getUserData($arguments);
	print_r($result);
	
?>
</pre>