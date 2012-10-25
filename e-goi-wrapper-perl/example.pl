#!/usr/bin/perl -w

use Data::Dumper;
use feature 'say';

# To choose the protocol (XmlRpc or Soap) use the respective package
# use Egoi::Api::Soap;
use Egoi::Api::XmlRpc;
use Egoi::Api;

my $functionOptions = {
	apikey => "d7cdcc90c0547da5da90c3e14eeff180455c38a2"
};


$m = Egoi::Api::getLists($functionOptions);

say Dumper $m;