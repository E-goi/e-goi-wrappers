#!/opt/local/bin/perl -w

use SOAP::Lite;

@arr = ('a', 'b', 'c');
foreach $a (@arr) {
	print "$a\n";	
}§

print @arr;