################################################################################
# rediriger les resultats des mesures pour le cas 0 dans le fichier cas0.txt
################################################################################
set term png;
set output 'lin_aleaT.png';
plot 'cas0.txt' using 1:2 title 'aleaT' with lines, \
'cas0.txt' using 1:3 title '200 n' with lines, \
'cas0.txt' using 1:4 title '300 n' with lines, \
'cas0.txt' using 1:5 title '400 n' with lines, \
'cas0.txt' using 1:6 title '500 n' with lines, \
'cas0.txt' using 1:7 title '600 n' with lines ;

################################################################################
# rediriger les resultats des mesures pour le cas 1 dans le fichier cas1.txt
################################################################################
set output 'cas1.png';
plot 'cas1.txt' using 1:2 title 'Tab 10' with lines, \
'cas1.txt' using 1:3 title 'List 10' with lines, \
'cas1.txt' using 1:4 title 'Tab 1000' with lines, \
'cas1.txt' using 1:5 title 'List 1000' with lines ;

################################################################################
# rediriger les resultats des mesures pour le cas 2 dans le fichier cas2.txt
################################################################################
set output 'cas2.png';
plot 'cas2.txt' using 1:2 title 'Tab 10' with lines, \
'cas2.txt' using 1:3 title 'List 10' with lines, \
'cas2.txt' using 1:4 title 'Tab 1000' with lines, \
'cas2.txt' using 1:5 title 'List 1000' with lines ;

################################################################################
# rediriger les resultats des mesures pour le cas 3 dans le fichier cas3.txt
################################################################################
set output 'cas3.png';
plot 'cas3.txt' using 1:2 title 'MinimumSimpleL 10' with lines, \
'cas3.txt' using 1:3 title 'MinimumSimpleT 10' with lines, \
'cas3.txt' using 1:4 title 'MinimumTriL 10' with lines, \
'cas3.txt' using 1:5 title 'MinimumTriT 10' with lines, \
'cas3.txt' using 1:6 title 'MinimumSimpleL 1000' with lines, \
'cas3.txt' using 1:7 title 'MinimumSimpleT 1000' with lines, \
'cas3.txt' using 1:8 title 'MinimumTriL 1000' with lines, \
'cas3.txt' using 1:9 title 'MinimumTriT 1000' with lines ;

################################################################################
# rediriger les resultats des mesures pour le cas 4 dans le fichier cas4.txt
################################################################################
set output 'cas4.png';
plot 'cas4.txt' using 1:2 title 'Exp' with lines, \
'cas4.txt' using 1:3 title 'Nlogn' with lines, \
'cas4.txt' using 1:4 title 'Log' with lines, \
'cas4.txt' using 1:5 title 'NpK' with lines, \
'cas4.txt' using 1:6 title 'KpN' with lines ;

################################################################################
# rediriger les resultats des mesures pour le cas 5 dans le fichier cas5.txt
################################################################################
set output 'cas5.png';
plot 'cas5.txt' using 1:2 title 'log(n)/(n^epsi) 2' with lines, \
'cas5.txt' using 1:3 title 'log(n)/(n^epsi) 1' with lines, \
'cas5.txt' using 1:4 title 'log(n)/(n^epsi) 0.5' with lines, \
'cas5.txt' using 1:5 title 'log(n)/(n^epsi) 0.2' with lines, \
'cas5.txt' using 1:6 title 'log(n)/(n^epsi) 0.1' with lines ;

################################################################################
# rediriger les resultats des mesures pour le cas 6 dans le fichier cas6.txt
################################################################################
set output 'cas6.png';
plot 'cas6.txt' using 1:2 title '(k^n)/(2^n) 1' with lines, \
'cas6.txt' using 1:3 title '(k^n)/(2^n) 2' with lines, \
'cas6.txt' using 1:4 title '(k^n)/(2^n) 3' with lines, \
'cas6.txt' using 1:5 title '(k^n)/(2^n) 4' with lines;
