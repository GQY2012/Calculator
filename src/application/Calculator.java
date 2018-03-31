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
    public String calculate(String expression) {  
        Stack<String> resultStack  = new Stack<String>();
   //   prepare(prepareNeq(expression));
        prepare(expression);  
        Collections.reverse(postfixStack);//将后缀式栈反转  
        String firstValue  ,secondValue,currentValue;//参与计算的第一个值，第二个值和算术运算符  
        while(!postfixStack.isEmpty()) {  
            currentValue  = postfixStack.pop();  
            if(!OperatorPrepare.isOperator(currentValue.charAt(0))) {//如果不是运算符则存入操作数栈中  
                resultStack.push(currentValue);  
            } 
            else if(OperatorPrepare.isBinaryOperator(currentValue.charAt(0))){//如果是双目运算符则从操作数栈中取两个值和该运算符一起参与运算  
            	secondValue  = resultStack.pop();  
            	firstValue  = resultStack.pop();  
            	String tempResult  = calculate(firstValue, secondValue, currentValue.charAt(0));  
            	resultStack.push(tempResult);  
            } 
            else if(OperatorPrepare.isUnaryOperator(currentValue.charAt(0))) {//如果是单目运算符则从操作数栈中取一个值和该运算符一起参与运算  
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
        return resultStack.pop();  
    }  
      
    /** 
     * 数据准备阶段将表达式转换成为后缀式栈 
     * @param expression 
     */  
    
    private void prepare(String expression) {    
        char[] arr  = expression.toCharArray();     
        char currentOp;//当前操作符  
        for(int i = 0;i < arr.length;i++) { 
        	currentOp = OperatorPrepare.shiftOperator(arr[i],i,arr); 
        	if(OperatorPrepare.isOperator(currentOp) && (currentOp != '(') && (currentOp != ')')) {//如果当前字符是运算符  
            //	i = OperatorPrepare.indexLongOperator(currentOp,i,arr);
            //	if(i == 0 && arr[i] == '+'|| i > 0 && arr[i] == '+' && (!Character.isDigit(arr[i-1]) && arr[i-1] != ')'))//#
            //		continue;
            	if(opStack.isEmpty()) {//符号栈为空则当前运算符入栈
            		if(OperatorPrepare.isLUnaryOperator(currentOp)) {//如果是左单目运算符
            			if(i > 0 && (arr[i-1] == ')' || Character.isDigit(arr[i-1])))
            				throw new IllegalArgumentException("Experssion Error!");
            		}
            		else if(OperatorPrepare.isRUnaryOperator(currentOp)){//如果是右单目运算符
            			if(i < arr.length - 1 && (arr[i+1] == '(' || Character.isDigit(arr[i+1])))
            				throw new IllegalArgumentException("Experssion Error!");
            		}
            		opStack.push(currentOp);
            	}
            	else {//符号栈不为空
            		if(OperatorPrepare.isLUnaryOperator(currentOp)) {//如果是左单目运算符则直接入运算符栈
            			if(i > 0 && (arr[i-1] == ')' || Character.isDigit(arr[i-1])))
            				throw new IllegalArgumentException("Experssion Error!");
            			opStack.push(currentOp);
            		}
            		else if(OperatorPrepare.isRUnaryOperator(currentOp)){//如果是右单目运算符则直接如后缀式栈
            			if(i < arr.length - 1 && (arr[i+1] == '(' || Character.isDigit(arr[i+1])))
            				throw new IllegalArgumentException("Experssion Error!");
            			postfixStack.push(String.valueOf(currentOp));
            		}
            		else {//如果是双目运算符
            	//		i = OperatorPrepare.indexLongOperator(currentOp,i,arr);
	            		if(OperatorPrepare.getoperatPriority(currentOp) > OperatorPrepare.getoperatPriority(opStack.peek())) {//当前运算符优先级大于栈顶运算符优先级
	            		opStack.push(currentOp);
	            		}
	            		else {//当前运算符优先级大于栈顶运算符优先级
	            			while(!opStack.isEmpty() && OperatorPrepare.getoperatPriority(currentOp) <= OperatorPrepare.getoperatPriority(opStack.peek()))  {  
	                            postfixStack.push(String.valueOf(opStack.pop()));    
	                        }  
	            			opStack.push(currentOp);
	            		}
            		}
            	}
            }
        	else if(Character.isDigit(currentOp)){//如果是数字
        		int count = 1;
        		while((arr.length - i > 1) && (Character.isDigit(arr[i+1]) ||arr[i+1] == '.')){
        			count++;
        			i++;
        			}
        		if((arr.length - i > 1) && arr[i+1] == 'E') {//如果是科学记数法
        			StringBuffer stringnum =  new StringBuffer(new String(arr,i-count+1,count)).deleteCharAt(1);
        			count = 0;
        			i++;
        			while((arr.length - i > 1) && (Character.isDigit(arr[i+1]))){
            			count++;
            			i++;
            			}
        			int power = Integer.valueOf(new String(arr,i-count+1,count));
        			int len = stringnum.length();
        			for(int j = 0;j < power - len + 1;j++) {
        				stringnum.append("0");
        			}
        			postfixStack.push(stringnum.toString());
        		}
        		else
        			postfixStack.push(new String(arr,i-count+1,count));
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
        	
        	
        	if(OperatorPrepare.isLongOperator(currentOp)) {
        		if(arr.length - i > 1 && currentOp == 'l'){
        			if(arr[i+1] == 'n')
        				i += 1;	
        			else
        				throw new IllegalArgumentException("Experssion Error!"); 
        		}
        		else if(arr.length - i > 2) {
        			StringBuffer LongOp =new StringBuffer();
        			LongOp.append(arr[i]).append(arr[i+1]).append(arr[i+2]);
        			if(OperatorPrepare.isLongStringOperator(LongOp.toString())) {
        				i += 2;	
        			}
        			else
        				throw new IllegalArgumentException("Experssion Error!"); 
        		}
        	}
        }//长运算符i的处理
        
        
      	while(!opStack.isEmpty()) {  //最后运算符栈剩余的符号全部入后缀式栈
                postfixStack.push(String.valueOf(opStack.pop()));  
            } 
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
                result = String.valueOf(CalculatorHelper.add(firstValue, secondValue));  
                break;  
            case '-':  
                result = String.valueOf(CalculatorHelper.sub(firstValue, secondValue));  
                break;  
            case '*':  
                result = String.valueOf(CalculatorHelper.mul(firstValue, secondValue));  
                break;  
            case '/':  
                result = String.valueOf(CalculatorHelper.div(firstValue, secondValue));  
                break; 
            case 'm':
            	result = String.valueOf(CalculatorHelper.mod(firstValue, secondValue));  
                break; 
            case '^':
            	result = String.valueOf(CalculatorHelper.pow(firstValue, secondValue));  
                break; 
            case 'r':
            	result = String.valueOf(CalculatorHelper.rooting(firstValue, secondValue));  
                break;
            case '&':
            	result = String.valueOf(CalculatorHelper.and(firstValue, secondValue));  
                break; 
            case '|':
            	result = String.valueOf(CalculatorHelper.or(firstValue, secondValue));  
                break;
            case 'X':
            	result = String.valueOf(CalculatorHelper.xor(firstValue, secondValue));  
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
				result = String.valueOf(CalculatorHelper.factorial(Value));  
				break;
			case '²':
				result = String.valueOf(CalculatorHelper.square(Value));  
				break;
	    	case '√':
	    		result = String.valueOf(CalculatorHelper.sqrt(Value));  
				break;
	    	case 'l':
	    		result = String.valueOf(CalculatorHelper.ln(Value));  
				break;
	    	case '%':
	    		result = String.valueOf(CalculatorHelper.percent(Value));  
				break;	
	    	case '~':
	    		result = String.valueOf(CalculatorHelper.neq(Value));  
				break;
	    	case 's':
	    		result = String.valueOf(CalculatorHelper.sin(Value));  
				break;
	    	case 'c':
	    		result = String.valueOf(CalculatorHelper.cos(Value));  
				break;
	    	case 't':
	    		result = String.valueOf(CalculatorHelper.tan(Value));  
				break;
	    	case 'd':
	    		result = String.valueOf(CalculatorHelper.deg(Value));  
				break;
		}
		return result;
	}
	
}