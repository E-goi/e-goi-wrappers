-- http://twiki.org/cgi-bin/view/TWiki/HowToInstallCpanModules#Setting_up_a_private_CPAN_librar

mkdir -p ~/lib/perl
perl -MCPAN -e shell

o conf make_arg -I~/lib/perl/CPAN
o conf make_install_arg -I~/lib/perl/CPAN
o conf makepl_arg "install_base=~/lib/perl/CPAN LIB=~/lib/perl/CPAN/lib INSTALLPRIVLIB=~/lib/perl/CPAN/lib INSTALLARCHLIB=~/lib/perl/CPAN/lib/arch INSTALLSITEARCH=~/lib/perl/CPAN/lib/arch INSTALLSITELIB=~/lib/perl/CPAN/lib INSTALLSCRIPT=~/lib/perl/CPAN/bin INSTALLBIN=~/lib/perl/CPAN/bin INSTALLSITEBIN=~/lib/perl/CPAN/bin INSTALLMAN1DIR=~/lib/perl/CPAN/man/man1 INSTALLSITEMAN1DIR=~/lib/perl/CPAN/man/man1 INSTALLMAN3DIR=~/lib/perl/CPAN/man/man3 INSTALLSITEMAN3DIR=~/lib/perl/CPAN/man/man3"
o conf commit
q