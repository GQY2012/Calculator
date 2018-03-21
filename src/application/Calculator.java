package application;

import java.util.Collections;  
import java.util.Stack;  
  
public class Calculator {  
    private Stack<String> postfixStack  = new Stack<String>();//后缀式栈  
    private Stack<Character> opStack  = new Stack<Character>();//运算符栈    

    /** 
     * 按照给定的表达式计算 
     * @param expression 要计算的表达式例如:5！+12*(-3+5)/7 
     * @return 
     */  
    public double calculate(String expression) {  
        Stack<String> resultStack  = new Stack<String>();  
        prepare(expression);  
        Collections.reverse(postfixStack);//将后缀式栈反转  
        String firstValue  ,secondValue,currentValue;//参与计算的第一个值，第二个值和算术运算符  
        while(!postfixStack.isEmpty()) {  
            currentValue  = postfixStack.pop();  
            if(!isOperator(currentValue.charAt(0))) {//如果不是运算符则存入操作数栈中  
                resultStack.push(currentValue);  
            } 
            else if(isBinaryOperator(currentValue.charAt(0))){//如果是运算符则从操作数栈中取两个值和该数值一起参与运算  
            	secondValue  = resultStack.pop();  
            	firstValue  = resultStack.pop();  
            	String tempResult  = calculate(firstValue, secondValue, currentValue.charAt(0));  
            	resultStack.push(tempResult);  
            } 
            else if(isUnaryOperator(currentValue.charAt(0))) {
            	firstValue  = resultStack.pop();
            	String tempResult  = calculate(firstValue, currentValue.charAt(0)); 
            	resultStack.push(tempResult);
            }
        }  
        return Double.valueOf(resultStack.pop());  
    }  
      
    /** 
     * 数据准备阶段将表达式转换成为后缀式栈 
     * @param expression 
     */  
 /*   private void prepare(String expression) {  
        opStack.push(',');//运算符放入栈底元素逗号，此符号优先级最低  
        char[] arr  = expression.toCharArray();  
        int currentIndex  = 0;//当前字符的位置  
        int count = 0;//上次算术运算符到本次算术运算符的字符的长度便于或者之间的数值  
        char currentOp,peekOp;//当前操作符和栈顶操作符  
        for(int i=0;i<arr.length;i++) {  
            currentOp = shiftOperator(arr[i]);  
            if(isOperator(currentOp)) {//如果当前字符是运算符  
            	if((arr.length - i > 1) && arr[i+1] == 'n')//ln
					i++;
            	if(count > 0) {  
                    postfixStack.push(new String(arr,currentIndex,count));//取两个运算符之间的数字  
                }  
                peekOp = opStack.peek();  
                if(currentOp == ')') {//遇到反括号则将运算符栈中的元素移除到后缀式栈中直到遇到左括号  
                    while(opStack.peek() != '(') {  
                        postfixStack.push(String.valueOf(opStack.pop()));  
                    }  
                    opStack.pop();  
                } else {  
                    while(currentOp != '(' && peekOp != ',' && compare(currentOp,peekOp) ) {  
                        postfixStack.push(String.valueOf(opStack.pop()));  
                        peekOp = opStack.peek();  
                    }  
                    opStack.push(currentOp);  
                }  
                count = 0;  
                currentIndex = i+1;  
            } else {  
                count++;  
            }  
        }  
        if(count > 1 || (count == 1 && !isOperator(arr[currentIndex]))) {//最后一个字符不是括号或者其他运算符的则加入后缀式栈中  
            postfixStack.push(new String(arr,currentIndex,count));  
        }   
          
        while(opStack.peek() != ',') {  
            postfixStack.push(String.valueOf( opStack.pop()));//将操作符栈中的剩余的元素添加到后缀式栈中  
        }  
    }  */
    
    
    private void prepare(String expression) {    
        char[] arr  = expression.toCharArray();     
        char currentOp;//当前操作符  
        for(int i = 0;i < arr.length;i++) { 
        	currentOp = shiftOperator(arr[i]); 
        	if(isOperator(currentOp) && (currentOp != '(') && (currentOp != ')')) {//如果当前字符是运算符  
            	if((arr.length - i > 1) && arr[i+1] == 'n')//ln
					i++;
            	if(opStack.isEmpty()) {
            		opStack.push(currentOp);
            	}
            	else {
            		if(getoperatPriority(currentOp) > getoperatPriority(opStack.peek())) {
            		opStack.push(currentOp);
            		}
            		else {
            			while(!opStack.isEmpty() && getoperatPriority(currentOp) < getoperatPriority(opStack.peek()))  {  
                            postfixStack.push(String.valueOf(opStack.pop()));    
                        }  
            			opStack.push(currentOp);
            		}
            	}
            }
        	else if(Character.isDigit(currentOp)){
        		int count = 1;
        		while((arr.length - i > 1) && Character.isDigit(arr[i+1])){
        			count++;
        			i++;
        			}
        		postfixStack.push(new String(arr,i-count+1,count));
        	}
        	else if(currentOp == 'π') {
        		postfixStack.push(String.valueOf(Math.PI));
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
        }
      	while(!opStack.isEmpty()) {  
                postfixStack.push(String.valueOf(opStack.pop()));  
            } 
     }
    /** 
     * 判断是否为算术符号 
     * @param c 
     * @return 
     */  
    private boolean isOperator(char c) {  
        return isBinaryOperator(c)|| isUnaryOperator(c);  
    } 
     
    private boolean isBinaryOperator(char c) {  
        return c == '+' || c == '-' || c == '*' || c == '/' 
        		|| c == '(' ||c == ')' || c == '%';  
    } 
    
    private boolean isUnaryOperator(char c) {  
        return c == '!' || c == '²' || c == '√' |c == 'l';  
    }
    
    public char shiftOperator(char c) {
    	if(c == 'x')
    		c = '*';
    	else if(c == '÷')
    		c = '/';
    	return c;
    }
    
    /**
     * 优先级
     * @param c 运算符
     * @return 优先级
     */
    
    private int getoperatPriority(char c) {
    	switch(c) {
    	case ',':return -1;
    	case '(':
    	case '.':return 0;
    	case '+':
    	case '-':return 1;
    	case '*':
    	case '/':
    	case '%':return 2;
    	case '²':
    	case '√':
    	case 'l':
    	case '!':return 3;
    	case ')':return 4;
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
            case '%':
            	result = String.valueOf(Acalculator.mod(firstValue, secondValue));  
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
				result = String.valueOf(Acalculator.pow(Value));  
				break;
	    	case '√':
	    		result = String.valueOf(Acalculator.sqrt(Value));  
				break;
	    	case 'l':
	    		result = String.valueOf(Acalculator.ln(Value));  
				break;
		}
		return result;
	}
	
}