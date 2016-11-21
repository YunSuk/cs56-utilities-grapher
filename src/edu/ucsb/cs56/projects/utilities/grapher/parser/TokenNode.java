package edu.ucsb.cs56.projects.utilities.grapher.parser;

import edu.ucsb.cs56.projects.utilities.grapher.tokenizer.Token;

public class TokenNode extends Token{

    public static final int IS_LITERAL = 0;
    public static final int IS_UN_OP = 1;
    public static final int IS_BIN_OP = 2;

    private Token data;
    private TokenNode leftChild;
    private TokenNode rightChild;
    private int type;

    public TokenNode(Token data, TokenNode leftChild, TokenNode rightChild){
	this.data = data;
	this.leftChild = leftChild;
	this.rightChild = rightChild;
	this.type = TokenNode.IS_BIN_OP;
    }

    public TokenNode(Token data, TokenNode leftChild){
	this(data, leftChild, null);
	this.type = TokenNode.IS_UN_OP;
    }

    public TokenNode(Token data){
	this(data, null, null);
	this.type = TokenNode.IS_LITERAL;
    }

    @Override
    public String repr(){
	return null;
    }
    @Override
    public String toString(){
	return "TokenNode";
    }
    @Override
    public int getPrecedence(){
	return 0;
    }
    public boolean isLiteral(){
	if (type == TokenNode.IS_LITERAL))
		return true;
	return false;
   }

    public boolean isUnaryOperator(){
	if (type == TokenNode.IS_UN_OP))
		return true;
	return false;
   }

    public boolean isBinaryOperator(){
	if (type == TokenNode.IS_BIN_OP))
		return true;
	return false;
   }

}
