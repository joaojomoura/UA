grammar CalcFrac;

main: 
	stat* EOF
	;

stat:
	  expr? NEWLINE				#StatExpr
	| print? NEWLINE			#StatPrint
	| assign? NEWLINE			#StatAssign
	;

print:
	'print' expr ';'
	;

assign:
	expr '->' ID ';'
	;


expr:
	signal = ('+'|'-') expr			#ExprSignal
	|op1 = expr op = ('*'|':') op2 = expr	#ExprMultDiv
	|op1 = expr op = ('+'|'-') op2 = expr	#ExprAddSub
	|Number '/' Number			#ExprFraction
	|Number					#ExprNumber
	|'(' expr ')'				#ExprParent
	|ID					#ExprID
	;

ID: [a-zA-Z]+;
Number: [0-9]+;
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;
COMMENT: '#' .*? '\n' -> skip;
