package application;



class CalculatorHelper {  
	  
    // 默认除法运算精度  
    private static final int DEF_DIV_SCALE = 16;  
  
    // 这个类不能实例化  
    private CalculatorHelper() {  
    }  
  
    /** 
     * 提供精确的加法运算。 
     *  
     * @param v1 被加数 
     * @param v2 加数 
     * @return 两个参数的和 
     */  
  
    public static double add(double v1, double v2) {  
        java.math.BigDecimal b1 = new java.math.BigDecimal(Double.toString(v1));  
        java.math.BigDecimal b2 = new java.math.BigDecimal(Double.toString(v2));  
        return b1.add(b2).doubleValue();  
    }  
      
    public static double add(String v1, String v2) {  
        java.math.BigDecimal b1 = new java.math.BigDecimal(v1);  
        java.math.BigDecimal b2 = new java.math.BigDecimal(v2);  
        return b1.add(b2).doubleValue();  
    }  
  
    /** 
     * 提供精确的减法运算。 
     *  
     * @param v1 被减数 
     * @param v2 减数 
     * @return 两个参数的差 
     */  
  
    public static double sub(double v1, double v2) {  
        java.math.BigDecimal b1 = new java.math.BigDecimal(Double.toString(v1));  
        java.math.BigDecimal b2 = new java.math.BigDecimal(Double.toString(v2));  
        return b1.subtract(b2).doubleValue();  
    }  
      
    public static double sub(String v1, String v2) {  
        java.math.BigDecimal b1 = new java.math.BigDecimal(v1);  
        java.math.BigDecimal b2 = new java.math.BigDecimal(v2);  
        return b1.subtract(b2).doubleValue();  
    }  
  
    /** 
     * 提供精确的乘法运算。 
     *  
     * @param v1 
     *            被乘数 
     * @param v2 
     *            乘数 
     * @return 两个参数的积 
     */  
  
    public static double mul(double v1, double v2) {  
        java.math.BigDecimal b1 = new java.math.BigDecimal(Double.toString(v1));  
        java.math.BigDecimal b2 = new java.math.BigDecimal(Double.toString(v2));  
        return b1.multiply(b2).doubleValue();  
    }  
      
    public static double mul(String v1, String v2) {  
        java.math.BigDecimal b1 = new java.math.BigDecimal(v1);  
        java.math.BigDecimal b2 = new java.math.BigDecimal(v2);  
        return b1.multiply(b2).doubleValue();   
    }  
  
    /** 
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。 
     *  
     * @param v1 
     *            被除数 
     * @param v2 
     *            除数 
     * @return 两个参数的商 
     */  
  
    public static double div(double v1, double v2) {  
        return div(v1, v2, DEF_DIV_SCALE);  
    }  
      
    public static double div(String v1, String v2) {  
        java.math.BigDecimal b1 = new java.math.BigDecimal(v1);  
        java.math.BigDecimal b2 = new java.math.BigDecimal(v2);  
        return b1.divide(b2, DEF_DIV_SCALE, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();  
    }  
  
    /** 
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。 
     *  
     * @param v1 被除数 
     * @param v2 除数 
     * @param scale 表示表示需要精确到小数点以后几位。 
     * @return 两个参数的商 
     */  
  
    public static double div(double v1, double v2, int scale) {  
        if (scale < 0) {  
            throw new IllegalArgumentException("The   scale   must   be   a   positive   integer   or   zero");  
        }  
        java.math.BigDecimal b1 = new java.math.BigDecimal(Double.toString(v1));  
        java.math.BigDecimal b2 = new java.math.BigDecimal(Double.toString(v2));  
        return b1.divide(b2, scale, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();  
    }  
  
    /** 
     * 提供精确的小数位四舍五入处理。 
     *  
     * @param v 需要四舍五入的数字 
     * @param scale 小数点后保留几位 
     * @return 四舍五入后的结果 
     */  
  
    public static double round(double v, int scale) {  
        if (scale < 0) {  
            throw new IllegalArgumentException("The   scale   must   be   a   positive   integer   or   zero");  
        }  
        java.math.BigDecimal b = new java.math.BigDecimal(Double.toString(v));  
        java.math.BigDecimal one = new java.math.BigDecimal("1");  
        return b.divide(one, scale, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();  
    }  
      
    public static double round(String v, int scale) {  
        if (scale < 0) {  
            throw new IllegalArgumentException("The   scale   must   be   a   positive   integer   or   zero");  
        }  
        java.math.BigDecimal b = new java.math.BigDecimal(v);  
        java.math.BigDecimal one = new java.math.BigDecimal("1");  
        return b.divide(one, scale, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();  
    } 
    
    /**
     * 求模
     * @param v1 被除数
     * @param v2 除数
     * @return 余数
     */
    
    public static double mod(String v1, String v2) {  
        java.math.BigDecimal b1 = new java.math.BigDecimal(v1);  
        java.math.BigDecimal b2 = new java.math.BigDecimal(v2);  
        return b1.divideAndRemainder(b2)[1].doubleValue();  
    }
    
    /**
     * 阶乘
     * @param v
     * @return
     */
    
    public static double factorial(String v) {  
        java.math.BigDecimal b = new java.math.BigDecimal(v); 
        if(b.doubleValue()%1 != 0)
        	throw new NumberFormatException("∞");
        if(b.doubleValue() > 170.0)
        	throw new NumberFormatException("∞");
        java.math.BigDecimal result = new java.math.BigDecimal(1);
        for(int i = 1;i <= b.intValue();i++)
        	result = result.multiply(new java.math.BigDecimal(i));
        return result.doubleValue();  
    }
    
    /**
     * 平方
     * @param v
     * @return
     */
    
    public static double square(String v) {
    	java.math.BigDecimal b = new java.math.BigDecimal(v);       
        return Math.pow(b.doubleValue(), 2.0);
    }
    
    /**
     * 次方
     * @param v1 
     * @param v2 
     * @return
     */
    
    public static double pow(String v1,String v2) {
    	java.math.BigDecimal b1 = new java.math.BigDecimal(v1);  
        java.math.BigDecimal b2 = new java.math.BigDecimal(v2);       
        return Math.pow(b1.doubleValue(), b2.doubleValue()); 
    }
    
    /**
     * 平方根
     * @param v
     * @return
     */
    
    public static double sqrt(String v) {  
        java.math.BigDecimal b = new java.math.BigDecimal(v);       
        return Math.sqrt(b.doubleValue());  
    }
    
    /**
     * 次方根
     * @param v1 
     * @param v2 
     * @return
     */
    
    public static double rooting(String v1,String v2) { 
    	java.math.BigDecimal b1 = new java.math.BigDecimal(v1);
        java.math.BigDecimal b2 = new java.math.BigDecimal(v2);    
        return Math.pow(b2.doubleValue(),1.0/b1.doubleValue());
    }
    
    /**
     * and
     * @param v1 
     * @param v2 
     * @return
     */
    
    public static double and(String v1,String v2) { 
    	java.math.BigDecimal b1 = new java.math.BigDecimal(v1);
        java.math.BigDecimal b2 = new java.math.BigDecimal(v2);  
        return b1.intValue() & b2.intValue();    
    }
    
    /**
     * or
     * @param v1 
     * @param v2 
     * @return
     */
    
    public static double or(String v1,String v2) { 
    	java.math.BigDecimal b1 = new java.math.BigDecimal(v1);
        java.math.BigDecimal b2 = new java.math.BigDecimal(v2);  
        return b1.intValue() | b2.intValue();    
    }
    
    /**
     * xor
     * @param v1 
     * @param v2 
     * @return
     */
    
    public static double xor(String v1,String v2) { 
    	java.math.BigDecimal b1 = new java.math.BigDecimal(v1);
        java.math.BigDecimal b2 = new java.math.BigDecimal(v2);  
        return b1.intValue() ^ b2.intValue();    
    }
    
    /**
     * 自然对数
     * @param v
     * @return
     */
    
    public static double ln(String v) {  
        java.math.BigDecimal b = new java.math.BigDecimal(v);       
        if(b.doubleValue() < 0.0)
        	throw new NumberFormatException("Illegal Expression!"); 
        return Math.log(b.doubleValue());  
    }
    
    /**
     * 百分数
     * @param v
     * @return
     */
    
    public static double percent(String v) {  
    	return div(v,String.valueOf(100.0));
    }
    
    
    /**
     * 负数
     * @param v
     * @return
     */
    
    public static double neq(String v) {  
    	java.math.BigDecimal b = new java.math.BigDecimal(v);
    	return b.negate().doubleValue();
    }
    
    /**
     * sin
     * @param v
     * @return
     */
    
    public static double sin(String v) {  
    	java.math.BigDecimal b = new java.math.BigDecimal(v);
    	if(b.doubleValue()%Math.PI == 0){
    		return 0;
    	}
    	return Math.sin(b.doubleValue());
    }
    
    /**
     * cos
     * @param v
     * @return
     */
    
    public static double cos(String v) {  
    	java.math.BigDecimal b = new java.math.BigDecimal(v);
    	if(b.doubleValue()/(Math.PI/2)%2 == 1){
    		return 0;
    	}
    	return Math.cos(b.doubleValue());
    }
    
    /**
     * tan
     * @param v
     * @return
     */
    
    public static double tan(String v) {  
    	java.math.BigDecimal b = new java.math.BigDecimal(v);
    	if(b.doubleValue()/(Math.PI/2)%2 == 1){
    		throw new IllegalArgumentException("Illegal Expression!");
    	}
    	return Math.tan(b.doubleValue());
    }
    
    /**
     * deg
     * @param v
     * @return
     */
    
    public static double deg(String v) {  
    	java.math.BigDecimal b = new java.math.BigDecimal(v);
    	return Math.toRadians(b.doubleValue());
    }
    
    
}  
