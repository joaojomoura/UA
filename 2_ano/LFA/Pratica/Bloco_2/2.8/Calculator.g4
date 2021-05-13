grammar Calculator;

program:
	stat* EOF;

stat:
	 expr? NEWLINE				#Exp
	|assignment? NEWLINE			#Assign
	;


assignment:
	ID '=' expr				#ID
	;
expr:
	 signal = ('+' | '-') expr		#ExprSginal
 	|expr op = ('*' | '/' | '%') expr	#ExprMultDivMod
	|expr op = ('+' | '-') expr		#ExprAddSub
	| Integer				#ExprInteger
	|'('expr')'				#ExprParent
	|ID					#ExprID
	;

ID: [a-zA-Z]+;
Integer: [0-9]+;
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;
COMMENT: '#' .*? '\n' -> skip;
