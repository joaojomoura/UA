grammar StrLang;

//Parser
main: 
	stat* EOF
	;

stat:
	 print		#statPrint
	|assign		#statAssign
	;

print:
	PRINT expr
	;

assign:
	ID ':' expr
	;

expr:
	 STRING		#exprString
	|ID		#exprID
	;


//Lexer

PRINT: 'print';

ID: [a-zA-Z0-9]+;
INT: [0-9]+;
STRING: '"' .*? '"';
WS: [ \t\n\r]+ -> skip;
COMMENT: '//' .*? '\n' -> skip;
ERROR: .;
