package application;

public abstract class OperatorPrepare {

	/** 
     * 判断算术符号 
     * @param c 
     * @return 
     */
    
    public static boolean isOperator(char c) {  //判断运算符
        return isBinaryOperator(c)|| isUnaryOperator(c);  
    } 
     
    public static boolean isBinaryOperator(char c) {  //判断双目运算符
        return c == '+' || c == '-' || c == '*' || c == '/' 
        		|| c == '(' || c == ')' || c == 'm' || c == '^' || c == 'r'
        		|| c == '&' || c == '|' || c == 'X';  
    } 
    
    public static boolean isUnaryOperator(char c) { //判断单目运算符 
        return isLUnaryOperator(c) || isRUnaryOperator(c);  
    }
    
    public static boolean isLUnaryOperator(char c) {  //判断左单目运算符
        return c == '√' || c == 'l' || c == '~' || c == '#'
        		|| c == 's' || c == 'c' || c == 't' || c == 'd';  
    }
    
    public static boolean isRUnaryOperator(char c) {  //判断右单目运算符
        return c == '!' || c == '²' || c == '%';  
    }
    
    public static boolean isLongOperator(char c) {  //判断长运算符
        return c == 's' || c == 'c' || c == 't' || c == 'X' || c == 'd' || c == 'm' || c == 'l';  
    }
    
    public static boolean isLongStringOperator(String str) {
    	String[] Operator = {"sin","cos","tan","Xor","deg","ln","mod"};
    	for(String c:Operator) {
    		if(str.equals(c))
    			return true;
    	}
    	return false;
    }
    
    public static char shiftOperator(char c,int i,char[] arr) { //部分运算符转换
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
    	else if( i > 0 && arr[i] == '√' && (Character.isDigit(arr[i-1]) || arr[i-1] == ')')) {
    		c = 'r';
    	}
    	return c;
    }
    
/*    public static int indexLongOperator(char c,int i,char[] arr) {
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
    	else if((arr.length - i > 2) && arr[i+1] == 'o' && arr[i+2] == 'r')//Xor
    		i += 2;
    	else
    		throw new NumberFormatException("Illegal Expression!"); 
    	return i;
    }*/
    
    /**
     * 优先级
     * @param c 运算符
     * @return 优先级
     */
    
    public static int getoperatPriority(char c) {
    	switch(c) {
    	case '(':return 0;
    	
    	case '|':return 1;
    	
    	case 'X':return 2;
    	
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
}
