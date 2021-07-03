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
	 INPUT'('expr')'		#exprRead
	|op1=expr '+' op2=expr		#exprAdd
	|op1=expr '-' op2=expr		#exprSub
	|TRIM expr			#exprTrim
	|expr'/'expr'/'expr		#exprSubst
	|'('expr')'			#exprParent
	|STRING				#exprString
	|ID				#exprID
	;


//Lexer

PRINT: 'print';
INPUT: 'input';
TRIM: 'trim';

ID: [a-zA-Z0-9]+;
STRING: '"' .*? '"'
{setText(getText().substring(1,getText().length()-1));}
;
WS: [ \t\n\r]+ -> skip;
COMMENT: '//' .*? '\n' -> skip;
ERROR: .;
