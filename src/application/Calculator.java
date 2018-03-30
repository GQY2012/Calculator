package application;

import java.util.Collections;
import java.util.Stack;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Calculator {  
    private Stack<String> postfixStack  = new Stack<String>();//后缀式栈  
    private Stack<Character> opStack  = new Stack<Character>();//运算符栈    
    @FXML
	private TextField Display;
    /** 
     * 按照给定的表达式计算 
     * @param expression 要计算的表达式例如:5！+12*(-3+5)/7 
     * @return 
     */  
    public double calculate(String expression) {  
        Stack<String> resultStack  = new Stack<String>();
   //   prepare(prepareNeq(expression));
        prepare(expression);  
        Collections.reverse(postfixStack);//将后缀式栈反转  
        String firstValue  ,secondValue,currentValue;//参与计算的第一个值，第二个值和算术运算符  
        while(!postfixStack.isEmpty()) {  
            currentValue  = postfixStack.pop();  
            if(!isOperator(currentValue.charAt(0))) {//如果不是运算符则存入操作数栈中  
                resultStack.push(currentValue);  
            } 
            else if(isBinaryOperator(currentValue.charAt(0))){//如果是双目运算符则从操作数栈中取两个值和该运算符一起参与运算  
            	secondValue  = resultStack.pop();  
            	firstValue  = resultStack.pop();  
            	String tempResult  = calculate(firstValue, secondValue, currentValue.charAt(0));  
            	resultStack.push(tempResult);  
            } 
            else if(isUnaryOperator(currentValue.charAt(0))) {//如果是单目运算符则从操作数栈中取一个值和该运算符一起参与运算  
            	firstValue  = resultStack.pop();
            	String tempResult  = calculate(firstValue, currentValue.charAt(0)); 
            	resultStack.push(tempResult);
            }
          	else {
        		throw new IllegalArgumentException("Illegal Expression!");
          	}
        }
        if(resultStack.size() > 1)
        	throw new IllegalArgumentException("Experssion Error!");
        return Double.valueOf(resultStack.pop());  
    }  
      
    /** 
     * 数据准备阶段将表达式转换成为后缀式栈 
     * @param expression 
     */  
    
    private void prepare(String expression) {    
        char[] arr  = expression.toCharArray();     
        char currentOp;//当前操作符  
        for(int i = 0;i < arr.length;i++) { 
        	currentOp = shiftOperator(arr[i],i,arr); 
        	if(isOperator(currentOp) && (currentOp != '(') && (currentOp != ')')) {//如果当前字符是运算符  
            //	i = indexLongOperator(currentOp,i,arr);
            	if(i == 0 && arr[i] == '+'|| i > 0 && arr[i] == '+' && !Character.isDigit(arr[i-1]))//#
            		continue;
            	if(opStack.isEmpty()) {//符号栈为空则当前运算符入栈
            		if(isLUnaryOperator(currentOp)) {//如果是左单目运算符
            			if(i > 0 && (arr[i-1] == ')' || Character.isDigit(arr[i-1])))
            				throw new IllegalArgumentException("Experssion Error!");
            		}
            		else if(isRUnaryOperator(currentOp)){//如果是右单目运算符
            			if(i < arr.length - 1 && (arr[i+1] == '(' || Character.isDigit(arr[i+1])))
            				throw new IllegalArgumentException("Experssion Error!");
            		}
            		opStack.push(currentOp);
            	}
            	else {//符号栈不为空
            		if(isLUnaryOperator(currentOp)) {//如果是左单目运算符则直接入运算符栈
            			if(i > 0 && (arr[i-1] == ')' || Character.isDigit(arr[i-1])))
            				throw new IllegalArgumentException("Experssion Error!");
            			opStack.push(currentOp);
            		}
            		else if(isRUnaryOperator(currentOp)){//如果是右单目运算符则直接如后缀式栈
            			if(i < arr.length - 1 && (arr[i+1] == '(' || Character.isDigit(arr[i+1])))
            				throw new IllegalArgumentException("Experssion Error!");
            			postfixStack.push(String.valueOf(currentOp));
            		}
            		else {//如果是双目运算符
            			i = indexLongOperator(currentOp,i,arr);
	            		if(getoperatPriority(currentOp) > getoperatPriority(opStack.peek())) {//当前运算符优先级大于栈顶运算符优先级
	            		opStack.push(currentOp);
	            		}
	            		else {//当前运算符优先级大于栈顶运算符优先级
	            			while(!opStack.isEmpty() && getoperatPriority(currentOp) <= getoperatPriority(opStack.peek()))  {  
	                            postfixStack.push(String.valueOf(opStack.pop()));    
	                        }  
	            			opStack.push(currentOp);
	            		}
            		}
            	}
            }
        	else if(Character.isDigit(currentOp)){//如果是数字
        		int count = 1;
        //		int pointindex = 0;
        		while((arr.length - i > 1) && (Character.isDigit(arr[i+1]) ||arr[i+1] == '.')){
        //			if(arr[i+1] == '.')
        //				pointindex = i+1;
        			count++;
        			i++;
        			}
<<<<<<< HEAD
        		if((arr.length - i > 1) && arr[i+1] == 'E') {//如果是科学记数法
        //			StringBuffer stringnum =  new StringBuffer(new String(arr,i-count+1,count));
        //			int len = stringnum.length();//小数位长度
        //			if(pointindex > 0) {
        //				len = len - pointindex;
        //				stringnum.deleteCharAt(pointindex);
        //			}
        			java.math.BigDecimal num = new java.math.BigDecimal(new String(arr,i-count+1,count));
        			count = 0;
        			i++;
        			while((arr.length - i > 1) && (Character.isDigit(arr[i+1]) || arr[i+1] == '.')){
            			count++;
            			i++;
            			}
        			java.math.BigDecimal power = new java.math.BigDecimal(new String(arr,i-count+1,count));
        	//		for(int j = 0;j < power - len + 1;j++) {
        	//			stringnum.append("0");
        	//		}	
        			postfixStack.push(String.valueOf(num.
        					multiply(new java.math.BigDecimal(Math.pow(10, power.doubleValue())))));
        		}
        		else
        			postfixStack.push(new String(arr,i-count+1,count));
=======
        		postfixStack.push(new String(arr,i-count+1,count));
>>>>>>> parent of 0da4dea... 4.2 released!
        	}
        	else if(currentOp == 'π') {//如果是π
        		postfixStack.push(String.valueOf(Math.PI));
        	}
        	else if(currentOp == 'e') {//如果是e
        		postfixStack.push(String.valueOf(Math.E));
        	}
        	else if((arr.length - i > 2) && arr[i] == 'A' && arr[i+1] == 'n' && arr[i+2] == 's') {
        		postfixStack.push(String.valueOf(CalController.result));
        		i += 2;
        	}
        	else if(currentOp == '(') {
        		opStack.push(currentOp);
        	}
        	else if(currentOp == ')') {
        		while(opStack.peek() != '(') {  
                    postfixStack.push(String.valueOf(opStack.pop()));  
                }  
        		opStack.pop();
        	}
        	else {
        		throw new IllegalArgumentException("Experssion Error!");
        	}
        	i = indexLongOperator(currentOp,i,arr);//长运算符
        	
        }
      	while(!opStack.isEmpty()) {  //最后运算符栈剩余的符号全部入后缀式栈
                postfixStack.push(String.valueOf(opStack.pop()));  
            } 
     }
    
    /** 
     * 判断算术符号 
     * @param c 
     * @return 
     */
    
    private boolean isOperator(char c) {  //判断运算符
        return isBinaryOperator(c)|| isUnaryOperator(c);  
    } 
     
    private boolean isBinaryOperator(char c) {  //判断双目运算符
        return c == '+' || c == '-' || c == '*' || c == '/' 
        		|| c == '(' || c == ')' || c == 'm' || c == '^' || c == 'r'
        		|| c == '&' || c == '|' || c == 'X';  
    } 
    
    private boolean isUnaryOperator(char c) { //判断单目运算符 
        return isLUnaryOperator(c) || isRUnaryOperator(c);  
    }
    
    private boolean isLUnaryOperator(char c) {  //判断左单目运算符
        return c == '√' || c == 'l' || c == '~' || c == '#'
        		|| c == 's' || c == 'c' || c == 't' || c == 'd';  
    }
    
    private boolean isRUnaryOperator(char c) {  //判断右单目运算符
        return c == '!' || c == '²' || c == '%';  
    }
    
    private char shiftOperator(char c,int i,char[] arr) { //部分运算符转换
    	if(c == 'x' || c == '×')
    		c = '*';
    	else if(c == '÷')
    		c = '/';
    	else if(c == '（' || c == '[' || c == '{')
    		c = '(';
    	else if(c == '）' || c == ']' || c == '}')
    		c = ')';
    	else if(i == 0 && arr[i] == '-'|| i > 0 && arr[i] == '-' && !Character.isDigit(arr[i-1])){//~
    		c = '~';
    	}
    	else if( i > 0 && arr[i] == '√' && Character.isDigit(arr[i-1])) {
    		c = 'r';
    	}
    	return c;
    }
    
    private int indexLongOperator(char c,int i,char[] arr) {
    	if(arr.length - i > 1 && arr[i+1] == 'n')//ln
			i++;
    	else if((arr.length - i > 2) && arr[i+1] == 'o' && arr[i+2] == 'd')//mod
			i += 2;
    	else if((arr.length - i > 2) && arr[i+1] == 'i' && arr[i+2] == 'n')//sin
    		i += 2;
    	else if((arr.length - i > 2) && arr[i+1] == 'o' && arr[i+2] == 's')//cos
    		i += 2;
    	else if((arr.length - i > 2) && arr[i+1] == 'a' && arr[i+2] == 'n')//tan
    		i += 2;
    	else if((arr.length - i > 2) && arr[i+1] == 'e' && arr[i+2] == 'g')//deg
    		i += 2;
    	else if((arr.length - i > 2) && arr[i+1] == 'o' && arr[i+2] == 'r')//deg
    		i += 2;
    	return i;
    }
    
    /**
     * 优先级
     * @param c 运算符
     * @return 优先级
     */
    
    private int getoperatPriority(char c) {
    	switch(c) {
    	case '(':return 0;
    	
    	case '|':return 1;
    	
    	case 'x':return 2;
    	
    	case '&':return 3;
    	
    	case '+':
    	case '-':return 4;
    	
    	case '*':
    	case '/':
    	case 'm'://mod
    			return 5;
    	
    	case '~'://negative
    	case '#'://positive
    	case '²':
    	case '^':
    	case '√':
    	case 'r'://rooting
    			return 6;
    	
    	case 'l'://ln
    	case 's'://sin
    	case 'c'://cos
    	case 't'://tan
    	case '%':
    	case '!':
    			return 7;
    	
    	case 'd'://deg
    			return 8;
    	
    	case ')':
    			return 9;
    	}
    	return -1;
    	
    }
 
    /** 
     * 按照给定的双目算术运算符做计算 
     * @param firstValue 
     * @param secondValue 
     * @param currentOp 
     * @return 
     */  
    private String calculate(String firstValue,String secondValue,char currentOp) {  
        String result  = "";  
        switch(currentOp) {  
            case '+':  
                result = String.valueOf(Acalculator.add(firstValue, secondValue));  
                break;  
            case '-':  
                result = String.valueOf(Acalculator.sub(firstValue, secondValue));  
                break;  
            case '*':  
                result = String.valueOf(Acalculator.mul(firstValue, secondValue));  
                break;  
            case '/':  
                result = String.valueOf(Acalculator.div(firstValue, secondValue));  
                break; 
            case 'm':
            	result = String.valueOf(Acalculator.mod(firstValue, secondValue));  
                break; 
            case '^':
            	result = String.valueOf(Acalculator.pow(firstValue, secondValue));  
                break; 
            case 'r':
            	result = String.valueOf(Acalculator.rooting(firstValue, secondValue));  
                break;
            case '&':
            	result = String.valueOf(Acalculator.and(firstValue, secondValue));  
                break; 
            case '|':
            	result = String.valueOf(Acalculator.or(firstValue, secondValue));  
                break;
            case 'X':
            	result = String.valueOf(Acalculator.xor(firstValue, secondValue));  
                break;
        }  
        return result;  
    }  
    
    /** 
     * 按照给定的单目算术运算符做计算 
     * @param Value  
     * @param currentOp 
     * @return 
     */

	private String calculate(String Value,char currentOp) {  
		String result  = "";  
		switch(currentOp) { 
			case'!':
				result = String.valueOf(Acalculator.factorial(Value));  
				break;
			case '²':
				result = String.valueOf(Acalculator.square(Value));  
				break;
	    	case '√':
	    		result = String.valueOf(Acalculator.sqrt(Value));  
				break;
	    	case 'l':
	    		result = String.valueOf(Acalculator.ln(Value));  
				break;
	    	case '%':
	    		result = String.valueOf(Acalculator.percent(Value));  
				break;	
	    	case '~':
	    		result = String.valueOf(Acalculator.neq(Value));  
				break;
	    	case 's':
	    		result = String.valueOf(Acalculator.sin(Value));  
				break;
	    	case 'c':
	    		result = String.valueOf(Acalculator.cos(Value));  
				break;
	    	case 't':
	    		result = String.valueOf(Acalculator.tan(Value));  
				break;
	    	case 'd':
	    		result = String.valueOf(Acalculator.deg(Value));  
				break;
		}
		return result;
	}
	
}