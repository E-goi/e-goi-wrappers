package Egoi::Api::Soap;

use SOAP::Lite;

$client = SOAP::Lite                                             
    -> uri('http://api.e-goi.com/v2/soap_any.php')                                             
    -> proxy('http://api.e-goi.com/v2/soap_any.php');

# say Dumper $result->result;

sub invoke {
	$options = $_[0];
	
	my $fname = (caller(1))[3];
	$fname =~ s/(.*):://g;

	$result = $client->$fname($options);	

	# foi um erro
	if($result->fault) {
		die "An error occurred while calling $fname: " . join ', ', 
			$result->faultcode, 
			$result->faultstring, 
			$result->faultdetail;
	}

	return $result->result();
}

sub addExtraField {
	return invoke($_[1]);
}

sub addSubscriber {
	return invoke($_[1]);
}

sub addSubscriberBulk {
	return invoke($_[1]);
}

sub checklogin {
	return invoke($_[1]);
}

sub createCampaignEmail {
	return invoke($_[1]);
}

sub createCampaignFAX {
	return invoke($_[1]);
}

sub createCampaignSMS {
	return invoke($_[1]);
}

sub createCampaignVoice {
	return invoke($_[1]);
}

sub createList {
	return invoke($_[1]);
}

sub createSegment {
	return invoke($_[1]);
}

sub deleteCampaign {
	return invoke($_[1]);
}

sub deleteSegment {
	return invoke($_[1]);
}

sub editCampaignEmail {
	return invoke($_[1]);
}

sub editCampaignSMS {
	return invoke($_[1]);
}

sub editExtraField {
	return invoke($_[1]);
}

sub editSubscriber {
	return invoke($_[1]);
}

sub getCampaigns {
	return invoke($_[1]);
}

sub getClientData {
	return invoke($_[1]);
}

sub getCredits {
	return invoke($_[1]);
}

sub getLists {
	return invoke($_[1]);
}

sub getReport {
	return invoke($_[1]);
}

sub getSegments {
	return invoke($_[1]);
}

sub getSenders {
	return invoke($_[1]);
}

sub getUserData {
	return invoke($_[1]);
}

sub removeSubscriber {
	return invoke($_[1]);
}

sub sendCall {
	return invoke($_[1]);
}

sub sendEmail {
	return invoke($_[1]);
}

sub sendFAX {
	return invoke($_[1]);
}

sub sendSMS {
	return invoke($_[1]);
}

sub subscriberData {
	return invoke($_[1]);
}

sub updateList {
	return invoke($_[1]);
}

1;

