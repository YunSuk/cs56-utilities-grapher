package edu.ucsb.cs56.projects.utilities.grapher.tokenizer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import java.util.ArrayList;
import org.junit.Before;
public class TokenTest {
    @Test
    public void testCosine() {
	ArrayList<Token>tokens=Tokenizer.tokenize("cos");
	assertEquals(tokens.size(),1);
	assertEquals(tokens.get(0),new CosineToken());	
    }

    @Test
    public void testNestedSineCosine(){
	ArrayList<Token> tokens=Tokenizer.tokenize("sincossin");
	Token[]answer={new SineToken(),new CosineToken(),new SineToken()};
	Token[]tA=new Token[tokens.size()];
	tA=tokens.toArray(tA);
	assertEquals(tA,answer);
    }

    @Test
    public void testIntegers(){
	ArrayList<Token>tokens=Tokenizer.tokenize("2sincosx+4x^2+5");
	Token[]answer={new NumberToken(2.0),new SineToken(),new CosineToken(),new XVarToken(),new PlusToken(),new NumberToken(4.0),
		new XVarToken(),new ExponentToken(),new NumberToken(2.0), new PlusToken(),new NumberToken(5.0)};
	Token[]tA=new Token[tokens.size()];
	tA=tokens.toArray(tA);
	assertEquals(tA,answer);
    }

    @Test
    public void testBigIntegers(){
	ArrayList<Token>tokens=Tokenizer.tokenize("cos32234x+12logx^54");
	Token[]answer={new CosineToken(),new NumberToken(32234.0),new XVarToken(), new PlusToken(), new NumberToken(12.0),
		new LogToken(),new XVarToken(), new ExponentToken(), new NumberToken(54)};
	Token[]tA=new Token[tokens.size()];
	tA=tokens.toArray(tA);
	assertEquals(tA,answer);   
    }

    @Test
    public void testNumbers(){
	ArrayList<Token>tokens=Tokenizer.tokenize("4235.324*533.31455/23443.12");
	Token[]answer={new NumberToken(4235.324),new TimesToken(),new NumberToken(533.31455),new DivideToken(),
	new NumberToken(23443.12)};
	Token[]tA=new Token[tokens.size()];
	tA=tokens.toArray(tA);
	assertEquals(tA,answer);   
    }

   @Test
   public void testLogAndNaturalLog(){
	ArrayList<Token> tokens = Tokenizer.tokenize("log(10)*ln(1)");
	Token[] answer = {new LogToken(),
			  new LParenToken(),
			  new NumberToken(10), new RParenToken(),
			  new TimesToken(),
			  new NaturalLogToken(),
			  new LParenToken(), new NumberToken(1),
			  new RParenToken()};
	Token[] tA = new Token[tokens.size()];
	tA = tokens.toArray(tA);
	assertEquals(tA,answer);
   }

   @Test
   public void testTangentAndConsecutiveVariables(){
	ArrayList<Token> tokens = Tokenizer.tokenize("tan(txy)");
	Token[] answer = {new TangentToken(), new LParenToken(),
			  new TVarToken(), new XVarToken(),
			  new YVarToken(), new RParenToken()};
	Token[] tA = new Token[tokens.size()];
	tA = tokens.toArray(tA);
	System.out.println(tokens);
	assertEquals(tA,answer);
   }

}
