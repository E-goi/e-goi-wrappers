package Egoi::Api;

my $mod;

if($INC{"Egoi/Api/XmlRpc.pm"}) {
	$mod = Egoi::Api::XmlRpc;
} elsif($INC{"Egoi/Api/Soap.pm"}) {
	$mod = Egoi::Api::Soap;
} else {
	print "Please use one of 'Egoi::Api::XmlRpc' or 'Egoi::Api::Soap' before 'Egoi::Api'\n";
}

sub addExtraField {
	return $mod->addExtraField($_[0]);
}

sub addSubscriber {
	return $mod->addSubscriber($_[0]);
}

sub addSubscriberBulk {
	return $mod->addSubscriberBulk($_[0]);
}

sub checklogin {
	return $mod->checklogin($_[0]);
}

sub createCampaignEmail {
	return $mod->createCampaignEmail($_[0]);
}

sub createCampaignFAX {
	return $mod->createCampaignFAX($_[0]);
}

sub createCampaignSMS {
	return $mod->createCampaignSMS($_[0]);
}

sub createCampaignVoice {
	return $mod->createCampaignVoice($_[0]);
}

sub createList {
	return $mod->createList($_[0]);
}

sub createSegment {
	return $mod->createSegment($_[0]);
}

sub deleteCampaign {
	return $mod->deleteCampaign($_[0]);
}

sub deleteSegment {
	return $mod->deleteSegment($_[0]);
}

sub editCampaignEmail {
	return $mod->editCampaignEmail($_[0]);
}

sub editCampaignSMS {
	return $mod->editCampaignSMS($_[0]);
}

sub editExtraField {
	return $mod->editExtraField($_[0]);
}

sub editSubscriber {
	return $mod->editSubscriber($_[0]);
}

sub getCampaigns {
	return $mod->getCampaigns($_[0]);
}

sub getClientData {
	return $mod->getClientData($_[0]);
}

sub getCredits {
	return $mod->getCredits($_[0]);
}

sub getLists {
	return $mod->getLists($_[0]);
}

sub getReport {
	return $mod->getReport($_[0]);
}

sub getSegments {
	return $mod->getSegments($_[0]);
}

sub getSenders {
	return $mod->getSenders($_[0]);
}

sub getUserData {
	return $mod->getUserData($_[0]);
}

sub removeSubscriber {
	return $mod->removeSubscriber($_[0]);
}

sub sendCall {
	return $mod->sendCall($_[0]);
}

sub sendEmail {
	return $mod->sendEmail($_[0]);
}

sub sendFAX {
	return $mod->sendFAX($_[0]);
}

sub sendSMS {
	return $mod->sendSMS($_[0]);
}

sub subscriberData {
	return $mod->subscriberData($_[0]);
}

sub updateList {
	return $mod->updateList($_[0]);
}

1;
__END__

Uma coisa do outro mundo!!!