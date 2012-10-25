-- http://sipb.mit.edu/doc/cpan/ -- Installing packages system-wide

o conf make_install_make_command '/usr/bin/sudo /usr/bin/make'
o conf mbuild_install_build_command '/usr/bin/sudo ./Build'
o conf commit

-- Dependencies --
cpan install RPC::XML
cpan install SOAP::Lite