package application;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.EmptyStackException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


public class CalController {
	
//	public static ArrayList<String> saveExpression = new ArrayList<String>();//保存的所有历史表达式
    public static StringBuffer currentExpression = new StringBuffer("");//当前表达式
//	public static int index = 0;
    public static String result = "";
	
	
	
	/*digits*/
	@FXML
	private Button Button_Zero;
	@FXML
	private Button Button_One;
	@FXML
	private Button Button_Two;
	@FXML
	private Button Button_Three;
	@FXML
	private Button Button_Four;
	@FXML
	private Button Button_Five;
	@FXML
	private Button Button_Six;
	@FXML
	private Button Button_Seven;
	@FXML
	private Button Button_Eight;
	@FXML
	private Button Button_Nine;
	/*function*/
	@FXML
	private Button Button_Clear;
	@FXML
	private Button Button_Delete;
	@FXML
	private Button Button_Ans;
	/*
	@FXML
	private Button Button_MC;
	@FXML
	private Button Button_MS;
	@FXML
	private Button Button_MR;
	*/
	@FXML
	private Button Button_Esc;
	
	/*Operator*/
	@FXML
	private Button Button_LP;
	@FXML
	private Button Button_RP;
	@FXML
	private Button Button_Add;
	@FXML
	private Button Button_Sub;
	@FXML
	private Button Button_Mul;
	@FXML
	private Button Button_Div;
	@FXML
	private Button Button_Fraction;
	@FXML
	private Button Button_Mod;
	@FXML
	private Button Button_Xor;
	@FXML
	private Button Button_And;
	@FXML
	private Button Button_Or;
	@FXML
	private Button Button_Equal;
//	@FXML
//	private Button Button_Neq;
	@FXML
	private Button Button_Point;
	@FXML
	private Button Button_Percent;
	@FXML
	private Button Button_Sqrt;
	@FXML
	private Button Button_Square;
	@FXML
	private Button Button_Factorial;
	@FXML
	private Button Button_ln;
	@FXML
	private Button Button_Pi;
	@FXML
	private Button Button_E;
	@FXML
	private Button Button_Pow;
	@FXML
	private Button Button_Rooting;
	@FXML
	private Button Button_Sin;
	@FXML
	private Button Button_Cos;
	@FXML
	private Button Button_Tan;
	@FXML
	private Button Button_Deg;
	
	/*display*/
	@FXML
	private TextField Display;
	
	/*link*/
	@FXML
	private Hyperlink Help;
	
	
	
	public void inputZero() {
		Display.appendText("0");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}
	public void inputOne() {
		Display.appendText("1");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置；
	}
	public void inputTwo() {
		Display.appendText("2");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置;
	}
	public void inputThree() {
		Display.appendText("3");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}
	public void inputFour() {
		Display.appendText("4");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}
	public void inputFive() {
		Display.appendText("5");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}
	public void inputSix() {
		Display.appendText("6");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}
	public void inputSeven() {
		Display.appendText("7");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}
	public void inputEight() {
		Display.appendText("8");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}
	public void inputNine() {
		Display.appendText("9");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}
	
	
	
	public void Clear() {
		Display.setText("");
		Display.requestFocus();
	}
	public void Delete() {
		if(Display.getLength() > 0){
			Display.deleteText(Display.getLength()-1, Display.getLength());
		}
		if(Display.getLength() == 0){
			Display.requestFocus();
		}
	}
	public void Esc() {
		Display.setText("");
		Display.requestFocus();
	//	saveExpression.clear();
	//	index = 0;
		result = "";
	}
	/*
	public void MC() {
		saveExpression.remove(index);
	}
	public void MS() {
		saveExpression.add(currentExpression.toString());	
		index = saveExpression.size();
	}
	public void MR() {
		if(index >= 0)
		{
			Display.setText(saveExpression.get(index));
			index--;
		}
	}*/
	public void inputAns() {
		Display.appendText("Ans");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}
	
	
	
	
	public void inputAdd() {
		Display.appendText("+");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}
	public void inputSub() {
		Display.appendText("-");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}
	public void inputMul() {
		Display.appendText("×");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}
	public void inputDiv() {
		Display.appendText("÷");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}
	public void inputFraction() {
		Display.appendText("/");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}
	public void inputMod() {
		Display.appendText("mod");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}
/*	public void inputNeq() {
		Display.appendText("-");
		input.expression.append("-");
	  	Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}*/
	public void inputAnd() {
		Display.appendText("&");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}
	public void inputOr() {
		Display.appendText("|");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}
	public void inputXor() {
		Display.appendText("Xor");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}
	public void inputPoint() {
		Display.appendText(".");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}
	public void inputPercent() {
		Display.appendText("%");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}
	public void inputSqrt() {
		Display.appendText("√");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}
	public void inputSquare() {
		Display.appendText("²");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}
	public void inputLP() {
		Display.appendText("(");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}
	public void inputRP() {
		Display.appendText(")");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}
	public void inputLn() {
		Display.appendText("ln");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}
	public void inputPi() {
		Display.appendText("π");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}
	public void inputE() {
		Display.appendText("e");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}
	public void inputFactorial() {
		Display.appendText("!");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}
	public void inputDeg() {
		Display.appendText("deg");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}
	public void inputPow() {
		Display.appendText("^");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}
	public void inputRooting() {
		Display.appendText("√");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}
	public void inputSin() {
		Display.appendText("sin");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}
	public void inputCos() {
		Display.appendText("cos");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}
	public void inputTan() {
		Display.appendText("tan");
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
	}
	
	
	public void inputEqual() {//计算
	//	Display.appendText(Calculator.conversion(input.expression.toString()));
	//	System.out.println(Display.getText());
		Calculator cal  = new Calculator();
	//	saveExpression.add(Display.getText());
		if(Display.getText().equals("")) {
			Display.requestFocus();//显示光标
			return;
		}
		else if(Display.getText().equals(result)) {
			Display.requestFocus();//显示光标
			Display.positionCaret((Display.getLength()));//设置光标位置
			return;
		}
		else
		{
			try {
			result = cal.calculate(Display.getText());
			}catch(EmptyStackException e) {//表达式格式错误
				Display.setText("Experssion Error!");
				return;
			}catch(ArithmeticException e) {//除0错误
				Display.setText("Divide by Zero Error!");
				return;
			}catch(NumberFormatException e) {//溢出错误
				Display.setText(e.getMessage());
				return;
			}catch(IllegalArgumentException e) {//非法表达式
				Display.setText(e.getMessage());
				return;
			}
			finally {
				Display.requestFocus();//显示光标
				Display.positionCaret((Display.getLength()));//设置光标位置
			}
		}
		DecimalFormat ft = new DecimalFormat("0.#################");//最多17位小数
		ft.setRoundingMode(RoundingMode.HALF_UP);//四舍五入
		if(result.length() <= 17) {
			Display.setText(ft.format(Double.valueOf(result)));
		}
		else
			Display.setText(result);//科学记数法
		Display.requestFocus();//显示光标
		Display.positionCaret((Display.getLength()));//设置光标位置
		
	}
	
	public void keyPressed(KeyEvent event) {//键盘响应
		if(event.getCode() == KeyCode.ENTER) {
			inputEqual();
		}
		else if(event.getCode() == KeyCode.ESCAPE) {
			Esc();
		}
		else if(event.getCode() == KeyCode.DELETE) {
			Delete();
		}
		else if(event.getCode() == KeyCode.F5) {
			Clear();
		}
	}
	
	@SuppressWarnings("unused")
	public void clickHelp(MouseEvent event) {
		final Runtime runtime = Runtime.getRuntime();    
	    Process process = null;   
	    
	    String cmd = "rundll32 url.dll FileProtocolHandler " + System.getProperty("user.dir") + "/readme/help.txt"; 
	    try {    
	        process = runtime.exec(cmd);    
	    } catch (final Exception e) {    
	        System.out.println("Error exec!");    
	    }    
	}    
}


