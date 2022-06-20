package antlr;// Generated from C.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CParser}.
 */
public interface CListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(CParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(CParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#compilerFunction}.
	 * @param ctx the parse tree
	 */
	void enterCompilerFunction(CParser.CompilerFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#compilerFunction}.
	 * @param ctx the parse tree
	 */
	void exitCompilerFunction(CParser.CompilerFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#compilerFunctionValue}.
	 * @param ctx the parse tree
	 */
	void enterCompilerFunctionValue(CParser.CompilerFunctionValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#compilerFunctionValue}.
	 * @param ctx the parse tree
	 */
	void exitCompilerFunctionValue(CParser.CompilerFunctionValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#bracketBlock}.
	 * @param ctx the parse tree
	 */
	void enterBracketBlock(CParser.BracketBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#bracketBlock}.
	 * @param ctx the parse tree
	 */
	void exitBracketBlock(CParser.BracketBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#bracketStatement}.
	 * @param ctx the parse tree
	 */
	void enterBracketStatement(CParser.BracketStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#bracketStatement}.
	 * @param ctx the parse tree
	 */
	void exitBracketStatement(CParser.BracketStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(CParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(CParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(CParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(CParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(CParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(CParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(CParser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(CParser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#switchBody}.
	 * @param ctx the parse tree
	 */
	void enterSwitchBody(CParser.SwitchBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#switchBody}.
	 * @param ctx the parse tree
	 */
	void exitSwitchBody(CParser.SwitchBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#caseBlock}.
	 * @param ctx the parse tree
	 */
	void enterCaseBlock(CParser.CaseBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#caseBlock}.
	 * @param ctx the parse tree
	 */
	void exitCaseBlock(CParser.CaseBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#defaultBlock}.
	 * @param ctx the parse tree
	 */
	void enterDefaultBlock(CParser.DefaultBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#defaultBlock}.
	 * @param ctx the parse tree
	 */
	void exitDefaultBlock(CParser.DefaultBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#methodDefinition}.
	 * @param ctx the parse tree
	 */
	void enterMethodDefinition(CParser.MethodDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#methodDefinition}.
	 * @param ctx the parse tree
	 */
	void exitMethodDefinition(CParser.MethodDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#nonBracketStatement}.
	 * @param ctx the parse tree
	 */
	void enterNonBracketStatement(CParser.NonBracketStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#nonBracketStatement}.
	 * @param ctx the parse tree
	 */
	void exitNonBracketStatement(CParser.NonBracketStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#namespaceDefinition}.
	 * @param ctx the parse tree
	 */
	void enterNamespaceDefinition(CParser.NamespaceDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#namespaceDefinition}.
	 * @param ctx the parse tree
	 */
	void exitNamespaceDefinition(CParser.NamespaceDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(CParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(CParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#variableArrayDefinition}.
	 * @param ctx the parse tree
	 */
	void enterVariableArrayDefinition(CParser.VariableArrayDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#variableArrayDefinition}.
	 * @param ctx the parse tree
	 */
	void exitVariableArrayDefinition(CParser.VariableArrayDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void enterVariableDefinition(CParser.VariableDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void exitVariableDefinition(CParser.VariableDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#variableValueChange}.
	 * @param ctx the parse tree
	 */
	void enterVariableValueChange(CParser.VariableValueChangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#variableValueChange}.
	 * @param ctx the parse tree
	 */
	void exitVariableValueChange(CParser.VariableValueChangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(CParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(CParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(CParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(CParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(CParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(CParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(CParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(CParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#argumentArray}.
	 * @param ctx the parse tree
	 */
	void enterArgumentArray(CParser.ArgumentArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#argumentArray}.
	 * @param ctx the parse tree
	 */
	void exitArgumentArray(CParser.ArgumentArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#methodArgumentArray}.
	 * @param ctx the parse tree
	 */
	void enterMethodArgumentArray(CParser.MethodArgumentArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#methodArgumentArray}.
	 * @param ctx the parse tree
	 */
	void exitMethodArgumentArray(CParser.MethodArgumentArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(CParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(CParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#offset}.
	 * @param ctx the parse tree
	 */
	void enterOffset(CParser.OffsetContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#offset}.
	 * @param ctx the parse tree
	 */
	void exitOffset(CParser.OffsetContext ctx);
}