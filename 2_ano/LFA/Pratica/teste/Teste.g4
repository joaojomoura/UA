grammar Teste;

//parser
main: stat* EOF;

stat:
	SHOW expr;


expr:
	 INT		#ExprInt
	|STRING		#ExprString
	;
//lexer

SHOW: 'show';

ID: [a-zA-Z]+;
INT:[0-9]+;
STRING: '"'.*?'"';
WS:[ \t\r\n]+ -> skip;
ERROR:.;
