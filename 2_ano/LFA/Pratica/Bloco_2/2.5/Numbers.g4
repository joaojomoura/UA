grammar Numbers;

program: line* EOF;

line returns [String res = null] :
	INT '-' ID '\n';

INT: [0-9]+;
ID: [a-zA-Z]+;
WS: [ \t\r] -> skip;
