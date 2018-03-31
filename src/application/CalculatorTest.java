package application;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculatorTest {

	Calculator cal = new Calculator();
	
	/**
	 * 测试简单带括号四则运算
	 */
	
	@Test
	public void testCalculatesimpleArithmetic() {
		assertEquals("0.0",cal.calculate("-1.5+1.5"));
		assertEquals("-0.2",cal.calculate("5.3-(3+2.5)"));
		assertEquals("10",cal.calculate("10"));
		assertEquals("-2.0",cal.calculate("5.0/(-1.3-1.2)"));
		assertEquals("1.11",cal.calculate("1.11-8.5×(7.1-0.11)×0"));
		assertEquals("2.0",cal.calculate("5.4÷[2.6×(3.7-2.9)+0.62]"));
		assertEquals("0.08",cal.calculate("[(7.1-5.6)×0.9-1.15]÷2.5"));
		assertEquals("9.92",cal.calculate("32.52-(6+9.728÷3.2)×2.5"));
		assertEquals("0.08",cal.calculate("[(7.1-5.6)×0.9-1.15]÷2.5"));
		assertEquals("20.0",cal.calculate("(284+16)mod(512-8208/18)"));
	}
	
	/**
	 * 测试复杂带括号运算
	 */
	
	@Test
	public void testCalculatecomplicatedArithmetic() {
	assertEquals("10.0",cal.calculate("((3√8x√9)+5*sin(π/2)/2.5)*(2÷2!)+2*lne"));
	assertEquals("633.0",cal.calculate("√64+sinπ/cosπ+5^(2²)×lnln(e^e)+tan0"));
	assertEquals("2.0",cal.calculate("cossintan0*sindeg(90)mod21+100%"));
	assertEquals("2.0",cal.calculate("sindeg90+cosdeg90+tandeg45"));
	assertEquals("0.0",cal.calculate("sinπ+cos(π/2)+tan0"));
	}
	
	/**
	 * 测试逻辑运算
	 */
	
	@Test
	public void testCalculatelogicArithmetic() {
		assertEquals("39.0",cal.calculate("15&7|24Xor63&(95|40)"));
		assertEquals("1.0",cal.calculate("1&1|1Xor1&(0|1)"));
		assertEquals("1.0",cal.calculate("(1&1|1Xor1)&(0|1)"));
	}
	
	/**
	 * 测试除0异常
	 */
		
	@Test(expected = ArithmeticException.class)
	 public void testDevidebyZero() {
		 cal.calculate("1/0");
		 cal.calculate("sinπ/cos(-π/2)");
	}
	
	/**
	 * 测试溢出异常
	 */
	 
	@Test(expected = NumberFormatException.class)
		public void testOverFlow() {
		 	cal.calculate("5555!");
			cal.calculate("555^555");
	}
	
	/**
	 * 测试缺少括号或括号不匹配导致的表达式异常
	 */
	 
	@Test(expected = IllegalArgumentException.class)
		public void testparenthesesError(){
			 cal.calculate("√64+sinπcosπ+5^(2²)×lnln(e^e)+tan0");
			 cal.calculate("((3√8x√9)+5sin(π/2)/2.5)*(2÷2!)+2lne");
			 cal.calculate("[(7.1-5.5.6)×0.9-1.15]÷2.5");
			 cal.calculate("32.52-6+9.728÷3.2)×2.5");
	}
	
	/**
	 * 测试栈溢出导致的表达式异常
	 */
	 
	@Test(expected =  EmptyStackException.class)
		public void testEmptyStack(){
			 cal.calculate("5-+6");
			 cal.calculate("5-");
			 cal.calculate("Xor6");
	}
	 

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	/**
	 * 测试运算符错误导致的表达式异常
	 */
	
	@Test
	public void testOperatorError() {
	    expectedEx.expect(IllegalArgumentException.class);
	    expectedEx.expectMessage("Experssion Error!");
	    cal.calculate("!5");
		cal.calculate("5ln");
		cal.calculate("sosπ+cin(π/2)+tor0");
	}

	
	/**
	 * 测试tan(π/2)不存在
	 */
	
	@Test
	public void testTanError() {
	    expectedEx.expect(IllegalArgumentException.class);
	    expectedEx.expectMessage("Illegal Expression!");
	    cal.calculate("tan(5π/2)");
	    cal.calculate("tan(π/2)");
	}	
	
	/**
	 * 测试ln-1不存在
	 */
	
	@Test
	public void testlnError() {
		expectedEx.expect(NumberFormatException.class);
	    expectedEx.expectMessage("Illegal Expression!");
	    cal.calculate("ln(-1)");
	    cal.calculate("ln0");
	}
	
	/**
	 * 测试√(-2)不存在
	 */
	@Test
	public void testrootingError() {
		expectedEx.expect(IllegalArgumentException.class);
	    expectedEx.expectMessage("Illegal Expression!");
	    cal.calculate("√(-2)");
	    cal.calculate("6√(-4)");
	}
	
	/**
	 * 测试0的0次幂不存在
	 */
	
	@Test
	public void testpowError() {
		expectedEx.expect(IllegalArgumentException.class);
	    expectedEx.expectMessage("Illegal Expression!");
	    cal.calculate("0^0");
	    cal.calculate("0^0.0");
	    cal.calculate("0.0^0");
	    cal.calculate("tan0^sinπ");
	}
	
	/**
	 * 测试非整数及负数阶乘
	 */
	
	@Test
	public void testfactorialError() {
		expectedEx.expect(IllegalArgumentException.class);
	    expectedEx.expectMessage("Illegal Expression!");
	    cal.calculate("4.55!");
	    cal.calculate("e!");
	    cal.calculate("(-1)!");
	}

}
