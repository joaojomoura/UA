grammar Hello;

stat: greetings | farewell;

greetings : 'hello' name;
farewell : 'bye' name;
name: ID+;

ID: [a-zA-Z]+;
WS: [ \t\r\n]+ -> skip;
