grammar C;

program
: statement*?;

statement
: bracketStatement
| nonBracketStatement ';'
| compilerFunction;

compilerFunction
: '#' ID compilerFunctionValue*?;

compilerFunctionValue
: INT | HEX | BIN | ID | STRING | LIBRARY;

bracketBlock
: '{' statement*? '}' | nonBracketStatement ';';

bracketStatement
: namespaceDefinition
| ifStatement
| whileStatement
| forStatement
| methodDefinition
| switchStatement;

ifStatement
: 'if' condition bracketBlock;

whileStatement
: 'while' condition bracketBlock;

forStatement
: 'for' L_PAREN ID 'from' expression 'to' expression (by='by' expression)? R_PAREN bracketBlock;

switchStatement
: 'switch' L_PAREN expression R_PAREN switchBody;

switchBody
: '{' caseBlock*? defaultBlock? '}';

caseBlock
: 'case' expression '->' bracketBlock;

defaultBlock
: 'defualt' '->' bracketBlock;

methodDefinition
: pub='public'? 'func' ID L_PAREN methodArgumentArray? R_PAREN bracketBlock;

nonBracketStatement
: variableArrayDefinition
| variableDefinition
| variableValueChange
| methodCall
| returnStatement;

namespaceDefinition
: 'namespace' ID bracketBlock;

returnStatement
: 'return' expression?;

variableArrayDefinition
: pub='public'? 'var' ID (offset | '=' '{' argumentArray '}');

variableDefinition
: pub='public'? 'var' ID '=' expression;

variableValueChange
: variable offset? ((VARIABLE_MODIFIER | '=') expression | VARIABLE_SINGLE_MODIFIER);

methodCall
: variable L_PAREN argumentArray? R_PAREN;


value
: STRING | (variable offset?) | INT | HEX | BIN | (methodCall offset?) | (sizeof='sizeof' '(' variable ')');

expression
: expression OPERATOR expression
| L_PAREN expression R_PAREN
| value;

condition
: L_PAREN expression R_PAREN;

argumentArray
: expression (',' argumentArray)?;

methodArgumentArray
: ID (',' methodArgumentArray)?;

variable
: ID ('::' variable)?;

offset
: '[' expression ']';




STRING: '"' (~'"'|'\\"')* '"';
LIBRARY: '<' ([a-z] | [A-Z] | '_')+ ([a-z] | [A-Z] | '_' | [0-9])* '>';
ID: ([a-z] | [A-Z] | '_')+ ([a-z] | [A-Z] | '_' | [0-9])*;
INT: ('-'? [0-9]+ ('.' [0-9]+)?) | '.' [0-9]+;
HEX: '0x' ([0-9] | [a-f] | [A-F])+;
BIN: '0b' ('0' | '1')+;
VARIABLE_MODIFIER: OPERATOR '=';
VARIABLE_SINGLE_MODIFIER: '++' | '--';
OPERATOR: '+' | '-' | '*' | '/' | '>>' | '<<' | '|' | '&' | '^' | '%' | '||' | '&&' | '>' | '<' | '==' | '!=' | '>=' | '<=';
NOT: '!';
WS:[ \t\r\n]+ -> skip;
SINGLE_COMMENT: '//' .*? '\n' -> skip;
BLOCK_COMMENT: '/*' .*? '*/' -> skip;
L_PAREN: '(';
R_PAREN: ')';
