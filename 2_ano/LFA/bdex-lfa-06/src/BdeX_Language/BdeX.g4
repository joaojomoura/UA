grammar BdeX;

@header {
package BdeX_Language;
import SemanticCheck.*;
import SemanticCheck.Types.*;
}

//Parser
main: stat* EOF;

stat:
	 declarations
	|assignment
   	|instruction
	;

declarations:
    	type IDENTIFIER ';'
    	|type assignment
	;

assignment returns[Type eType, String varName]:
	IDENTIFIER '->' expression';'
	;

expression returns[Type eType,String varName, Boolean isVar = false]:
     	 sign=('+'|'-') e=expression                            #signExpr
    	| <assoc=right> e1=expression '^' e2=expression         #powExpr
    	| e1=expression op=('*'| '/' | '%') e2=expression       #multDivRemExpr
    	| e1=expression op=('+' | '-') e2=expression            #addSubExpr
    	| '(' e=expression ')'					#parenExpr                                                              
    	|createtable 						#createTable	
    	|join 							#joinTable
    	|extract 						#extractTable
    	|read 							#readExpr
    	|createColumn 						#createcolumn
    	|DOUBLE                                                 #doubleExpr
    	|INT                                                    #intExpr
    	|STRING                                                 #stringExpr
    	|IDENTIFIER                                             #varExpr
	;


instruction:
    insert
    |remove
    |save
    |modify
    |print
    ;

createtable returns[Type eType]:
	CREATE'{'
		(expression'>>' type';')+
	'}'
	;

createColumn returns[Type eType]:
    	CREATE COLUMN '>>' type
	;

extract returns[Type eType]:
   	 EXTRACT FROM table=expression '>>' (expression('|' expression)*) (WHERE (selection('|' selection)*))?
	;

join returns[Type eType]:
    JOIN table=expression TO table=expression;

insert:
	(INSERT INTO table=expression)*?(

    	//First mode (one value)
	 IN column=expression '>>' value=expression ';'      		        

	//Second mode (all by order) can skip?
	|'>>' (expression('|' (expression)?)*)';' 		       
	
	//Third mode (specify col:value)
	|'>>' (insertStat('|' insertStat)*)';' 				 
	)									#inserttoTable
	
	//insert a column in a table
	|INSERT column=expression '>>' colName=expression INTO table=expression ';' 	 #insertColumn
	//insert an item in a column
	|INSERT value=expression INTO column=expression';'				 #insertIntoCol
	;

modify: 
	//modify selected columns with specified values if conditions are met
	MODIFY (insertStat('|' insertStat)*) IN table=expression WHERE (selection('|' selection)*)';'	      #modifyTableColSel
	//modify by position in table 
	|MODIFY col=expression'|'position=expression IN table=expression '>>' value=expression';'	#modifyTablePos
	//modify value in column by index
	|MODIFY position=expression IN column=expression '>>' value=expression';'				      #modifyColPos
	;

remove:
    	//remove column
	REMOVE column=expression FROM table=expression ';'
	//remove lines that match selection
    	|REMOVE FROM table=expression WHERE (selection('|' selection)*)';' 
	;

read returns[Type eType]:
	 READ FROM expression //same idea as save, .table auto put
    	|READ type
	;

save:
	SAVE table=expression TO expression ';' // .table auto put
	;


print:
	SHOW expression ';'
	;

insertStat returns[String varName, Boolean isVar = false]:
     expression  ':' expression;

selection returns[String varName, Boolean isVar = false]:
    expression SELECOP expression;

//IDENTIFIER types
type:
	 INTEGER_T
	|DOUBLE_T
	|TEXT
	|TABLE
	|COLUMN
	;

//------------------Lexer----------------

//Reserved words
CREATE: 'create';
INTO: 'into';
IN: 'in';
TO: 'to';
FROM: 'from';
WHERE: 'where';
TABLE: 'Table';
INTEGER_T:'int';
DOUBLE_T: 'double';
COLUMN: 'column';
TEXT: 'text';			//list of type String for columns
REMOVE: 'remove';
EXTRACT: 'extract';
JOIN: 'join'; 
INSERT: 'insert';
MODIFY: 'modify';
SAVE: 'save';
READ: 'read';
SHOW: 'show';

//selection operators
SELECOP: '>'|'<'|'>='|'<='|'==';

//random tokens
IDENTIFIER: [a-zA-Z][a-zA-Z0-9_]*;
DOUBLE: [0-9]+ '.' [0-9]+;
INT: [0-9]+;
STRING: '"' .*? '"';
WS: [ \t\r\n]+ -> skip;
COMMENT: '##' .*? '\n' -> skip;
ERROR:.;
