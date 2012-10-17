#!/opt/local/bin/perl -w

#You must install the RPC::XML perl module.
require RPC::XML;
require RPC::XML::Client;

# This is the connection to the XMLRPC service to communicate with the API
$client = RPC::XML::Client->new('http://api.e-goi.com/v2/xmlrpc.php');

$params = RPC::XML::struct->new({apikey => RPC::XML::string->new('your_api_key')});

# using XmlRpc:
$res = $client->send_request('getUserData', RPC::XML::struct->new($params));
print "   Response type = ".$res->type."\n";
print "   Response string = ".$res->as_string."\n";
print "   Response value = ".$res->value."\n";
foreach (@{$res->value}) {
  print "      ".join(', ',@$_)."\n";
}