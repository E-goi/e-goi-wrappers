#!/usr/bin/perl -w

use Data::Dumper;
use feature 'say';

# To choose the protocol (XmlRpc or Soap) use the respective package
# use Egoi::Api::Soap;
use Egoi::Api::XmlRpc;
use Egoi::Api;

my $functionOptions = {
	apikey => "<api key>"
};

$m = Egoi::Api::getLists($functionOptions);

say Dumper $m;

