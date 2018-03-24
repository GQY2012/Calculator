package application;

import java.util.EmptyStackException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class CalController {
	
//	public static ArrayList<String> saveExpression = new ArrayList<String>();//保存的所有历史表达式
    public static StringBuffer currentExpression = new StringBuffer("");//当前表达式
//	public static int index = 0;
    public static double result = 0;
	
	
	
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

	
	
	
	public void inputZero() {
		Display.appendText("0");
	//	input.expression.append("0");
	}
	public void inputOne() {
		Display.appendText("1");
	//	input.expression.append("1");
	}
	public void inputTwo() {
		Display.appendText("2");
	//	input.expression.append("2");
	}
	public void inputThree() {
		Display.appendText("3");
	//	input.expression.append("3");
	}
	public void inputFour() {
		Display.appendText("4");
	//	input.expression.append("4");
	}
	public void inputFive() {
		Display.appendText("5");
	//	input.expression.append("5");
	}
	public void inputSix() {
		Display.appendText("6");
	//	input.expression.append("6");
	}
	public void inputSeven() {
		Display.appendText("7");
	//	input.expression.append("7");
	}
	public void inputEight() {
		Display.appendText("8");
	//	input.expression.append("8");
	}
	public void inputNine() {
		Display.appendText("9");
	//	input.expression.append("9");
	}
	
	
	
	public void Clear() {
		Display.setText("");
		Display.requestFocus();
	//	input.expression = new StringBuffer("0");
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
		result = 0;
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
	}
	
	
	
	
	public void inputAdd() {
		Display.appendText("+");
	//	input.expression.append("+");
	}
	public void inputSub() {
		Display.appendText("-");
	//	input.expression.append("-");
	}
	public void inputMul() {
		Display.appendText("×");
	//	input.expression.append("*");
	}
	public void inputDiv() {
		Display.appendText("÷");
	//	input.expression.append("÷");
	}
	public void inputFraction() {
		Display.appendText("/");
	//	input.expression.append("/");
	}
	public void inputMod() {
		Display.appendText("mod");
	}
/*	public void inputNeq() {
		Display.appendText("-");
	//	input.expression.append("-");
	}*/
	public void inputAnd() {
		Display.appendText("&");
	}
	public void inputOr() {
		Display.appendText("|");
	}
	public void inputXor() {
		Display.appendText("Xor");
	}
	public void inputPoint() {
		Display.appendText(".");
	//	input.expression.append(".");
	}
	public void inputPercent() {
		Display.appendText("%");
	//	input.expression.append("%");
	}
	public void inputSqrt() {
		Display.appendText("√");
	//	input.expression.append("√");
	}
	public void inputSquare() {
		Display.appendText("²");
	//	input.expression.append("²");
	}
	public void inputLP() {
		Display.appendText("(");
	//	input.expression.append("(");
	}
	public void inputRP() {
		Display.appendText(")");
	//	input.expression.append(")");
	}
	public void inputLn() {
		Display.appendText("ln");
	//	input.expression.append("ln");
	}
	public void inputPi() {
		Display.appendText("π");
	//	input.expression.append("π");
	}
	public void inputE() {
		Display.appendText("e");
	//	input.expression.append("e");
	}
	public void inputFactorial() {
		Display.appendText("!");
	//	input.expression.append("!");
	}
	public void inputDeg() {
		Display.appendText("deg");
	//	input.expression.append("deg");
	}
	public void inputPow() {
		Display.appendText("^");
	//	input.expression.append("^");
	}
	public void inputRooting() {
		Display.appendText("√");
	//	input.expression.append("√");
	}
	public void inputSin() {
		Display.appendText("sin");
	//	input.expression.append("sin");
	}
	public void inputCos() {
		Display.appendText("cos");
	//	input.expression.append("cos");
	}
	public void inputTan() {
		Display.appendText("tan");
	//	input.expression.append("tan");
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
		else
		{
			try {
			result = cal.calculate(Display.getText());
			}catch(EmptyStackException e) {
				Display.setText("Experssion Error!");
				return;
			}catch(ArithmeticException e) {
				Display.setText("Divide by Zero Error!");
				return;
			}catch(NumberFormatException e) {
				Display.setText(e.getMessage());
				return;
			}catch(IllegalArgumentException e) {
				Display.setText(e.getMessage());
				return;
			}
			finally {
				Display.requestFocus();//显示光标
				Display.positionCaret((Display.getLength()));//设置光标位置
			}
		}
	//	System.out.println(result);
		Display.setText(Double.toString(result));
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
	}
	
	public void keyReleased(KeyEvent event) {
		
	}
	
	public  void display(String st) {
		Display.setText(st);
	}
}
