grammar Calculator;

program:
	stat* EOF;

stat:
	 expr? NEWLINE
	|assignment? NEWLINE;

assignment:
	ID '=' expr;

expr:
 	 expr op = ('*' | '/' | '%') expr	#ExprMultDivMod
	|expr op = ('+' | '-') expr		#ExprAddSub
	|signal = ('+'|'-')? Integer		#ExprInteger
	|signal = ('+'|'-')?'('expr')'		#ExprParent
	|ID					#ExprID
	;

ID: [a-zA-Z]+;
Integer: [0-9]+;
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;
COMMENT: '#' .*? '\n' -> skip;
