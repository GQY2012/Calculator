package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class CalController {
	
	public static ArrayList<String> saveExpression = new ArrayList<String>();//保存的所有历史表达式
    public static StringBuffer currentExpression = new StringBuffer("");//当前表达式
	public static int index = 0;
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
	@FXML
	private Button Button_Neq;
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

	
	
	
	public void inputZero(ActionEvent event) {
		Display.appendText("0");
	//	input.expression.append("0");
	}
	public void inputOne(ActionEvent event) {
		Display.appendText("1");
	//	input.expression.append("1");
	}
	public void inputTwo(ActionEvent event) {
		Display.appendText("2");
	//	input.expression.append("2");
	}
	public void inputThree(ActionEvent event) {
		Display.appendText("3");
	//	input.expression.append("3");
	}
	public void inputFour(ActionEvent event) {
		Display.appendText("4");
	//	input.expression.append("4");
	}
	public void inputFive(ActionEvent event) {
		Display.appendText("5");
	//	input.expression.append("5");
	}
	public void inputSix(ActionEvent event) {
		Display.appendText("6");
	//	input.expression.append("6");
	}
	public void inputSeven(ActionEvent event) {
		Display.appendText("7");
	//	input.expression.append("7");
	}
	public void inputEight(ActionEvent event) {
		Display.appendText("8");
	//	input.expression.append("8");
	}
	public void inputNine(ActionEvent event) {
		Display.appendText("9");
	//	input.expression.append("9");
	}
	
	
	
	public void Clear(ActionEvent event) {
		Display.setText("");
	//	input.expression = new StringBuffer("0");
	}
	public void Delete(ActionEvent event) {
		if(Display.getLength() > 0){
			Display.deleteText(Display.getLength()-1, Display.getLength());
		}
	}
	public void Esc(ActionEvent event) {
		Display.setText("");
		saveExpression.clear();
		index = 0;
		result = 0;
	}
	/*
	public void MC(ActionEvent event) {
		saveExpression.remove(index);
	}
	public void MS(ActionEvent event) {
		saveExpression.add(currentExpression.toString());	
		index = saveExpression.size();
	}
	public void MR(ActionEvent event) {
		if(index >= 0)
		{
			Display.setText(saveExpression.get(index));
			index--;
		}
	}*/
	public void inputAns(ActionEvent event) {
		Display.appendText("Ans");
	}
	
	
	
	
	public void inputAdd(ActionEvent event) {
		Display.appendText("+");
	//	input.expression.append("+");
	}
	public void inputSub(ActionEvent event) {
		Display.appendText("-");
	//	input.expression.append("-");
	}
	public void inputMul(ActionEvent event) {
		Display.appendText("x");
	//	input.expression.append("*");
	}
	public void inputDiv(ActionEvent event) {
		Display.appendText("÷");
	//	input.expression.append("÷");
	}
	public void inputFraction(ActionEvent event) {
		Display.appendText("/");
	//	input.expression.append("/");
	}
	public void inputMod(ActionEvent event) {
		Display.appendText("mod");
	}
	public void inputNeq(ActionEvent event) {
		Display.appendText("-");
	//	input.expression.append("-");
	}
	public void inputAnd(ActionEvent event) {
		Display.appendText("&");
	}
	public void inputOr(ActionEvent event) {
		Display.appendText("|");
	}
	public void inputXor(ActionEvent event) {
		Display.appendText("Xor");
	}
	public void inputPoint(ActionEvent event) {
		Display.appendText(".");
	//	input.expression.append(".");
	}
	public void inputPercent(ActionEvent event) {
		Display.appendText("%");
	//	input.expression.append("%");
	}
	public void inputSqrt(ActionEvent event) {
		Display.appendText("√");
	//	input.expression.append("√");
	}
	public void inputSquare(ActionEvent event) {
		Display.appendText("²");
	//	input.expression.append("²");
	}
	public void inputLP(ActionEvent event) {
		Display.appendText("(");
	//	input.expression.append("(");
	}
	public void inputRP(ActionEvent event) {
		Display.appendText(")");
	//	input.expression.append(")");
	}
	public void inputLn(ActionEvent event) {
		Display.appendText("ln");
	//	input.expression.append("ln");
	}
	public void inputPi(ActionEvent event) {
		Display.appendText("π");
	//	input.expression.append("π");
	}
	public void inputE(ActionEvent event) {
		Display.appendText("e");
	//	input.expression.append("e");
	}
	public void inputFactorial(ActionEvent event) {
		Display.appendText("!");
	//	input.expression.append("!");
	}
	public void inputDeg(ActionEvent event) {
		Display.appendText("deg");
	//	input.expression.append("deg");
	}
	public void inputPow(ActionEvent event) {
		Display.appendText("^");
	//	input.expression.append("^");
	}
	public void inputRooting(ActionEvent event) {
		Display.appendText("√");
	//	input.expression.append("√");
	}
	public void inputSin(ActionEvent event) {
		Display.appendText("sin");
	//	input.expression.append("sin");
	}
	public void inputCos(ActionEvent event) {
		Display.appendText("cos");
	//	input.expression.append("cos");
	}
	public void inputTan(ActionEvent event) {
		Display.appendText("tan");
	//	input.expression.append("tan");
	}
	
	
	public void inputEqual(ActionEvent event) {
	//	Display.appendText(Calculator.conversion(input.expression.toString()));
	//	System.out.println(Display.getText());
		Calculator cal  = new Calculator();
		saveExpression.add(Display.getText());
		result = cal.calculate(Display.getText());
	//	System.out.println(result);
		Display.setText(Double.toString(result));
	}
}
