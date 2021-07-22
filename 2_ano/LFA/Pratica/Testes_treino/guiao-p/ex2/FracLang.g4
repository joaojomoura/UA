grammar FracLang;

//Parser
main: 
	stat* EOF
	;

stat:
	display ';'			#statDisplay
	|assign	';'			#statAssign
	;

display:
	DISPLAY expr
	;

assign:
	ID '<=' expr
	;


expr:
	 READ STRING				#exprRead
	|signal=('+'|'-') expr			#exprSignal
	|expr op = ('*'|':') expr		#exprMulDiv
	|expr op = ('+'|'-') expr		#exprAddSub
	|'('expr')'				#exprParent
	|INT'/'INT				#exprFrac
	|INT					#exprInt
	|ID					#exprID
	;



//Lexer

DISPLAY: 'display';
READ: 'read';

ID: [a-z]+;
INT:[0-9]+;
STRING:'"'.*?'"'
{setText(getText().substring(1,getText().length()-1));}
;
WS: [ \t\r\n]+ -> skip;
COMMENT: '--' .*? '\n' -> skip;
ERROR: .;
