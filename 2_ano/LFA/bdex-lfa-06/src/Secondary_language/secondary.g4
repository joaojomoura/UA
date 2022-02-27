grammar secondary;

@header {
package Secondary_language;
}

//Parser
program:
    table EOF;

table:
    TABLE columnDeclr '{' (line ';')+? '}';

columnDeclr:
    '(' (column( ',' column)*) ')';

line:
    (type ( ',' type)*)?;

type:
    DOUBLE #TypeDouble
    | INTEGER #TypeInt
    | STRING #TypeString;

column:
    TEXT '>>' varT=('int'|'double'|'text');


//Lexer
TABLE: 'table';

DOUBLE: [0-9]+ '.' [0-9]+;
INTEGER: [0-9]+;

STRING: '"' .*? '"';
WS: [ \t\n\r]+ -> skip;
TEXT: [a-zA-Z] [a-zA-Z_1-9]*;