#!/usr/bin/perl -w

use Data::Dumper;
use feature 'say';

use Egoi::Api::XmlRpc;
use Egoi::Api;

my $functionOptions = {
	apikey => "<your key>"
};

$m = Egoi::Api::getUserData($functionOptions);

say Dumper $m;