package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class CalController {
	
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
	private Button Button_ClearError;
	@FXML
	private Button Button_Clear;
	@FXML
	private Button Button_Delete;
	
	/*oprator*/
	@FXML
	private Button Button_LP;
	@FXML
	private Button Button_RP;
	@FXML
	private Button Button_Add;
	@FXML
	private Button Button_Minus;
	@FXML
	private Button Button_Times;
	@FXML
	private Button Button_Devide;
	@FXML
	private Button Button_Equal;
	@FXML
	private Button Button_Neq;
	@FXML
	private Button Button_Point;
	@FXML
	private Button Button_Percent;
	@FXML
	private Button Button_Rooting;
	@FXML
	private Button Button_Square;
	@FXML
	private Button Button_Ln;
	@FXML
	private Button Button_Pi;
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
	public void ClearError(ActionEvent event) {
		Display.setText("");
	}
	public void Delete(ActionEvent event) {
		if(Display.getLength() > 0){
			Display.deleteText(Display.getLength()-1, Display.getLength());
	//		input.expression.deleteCharAt(Display.getLength());
		}
	}
	
	
	
	public void inputAdd(ActionEvent event) {
		Display.appendText("+");
	//	input.expression.append("+");
	}
	public void inputMinus(ActionEvent event) {
		Display.appendText("-");
	//	input.expression.append("-");
	}
	public void inputTimes(ActionEvent event) {
		Display.appendText("x");
	//	input.expression.append("*");
	}
	public void inputDevide(ActionEvent event) {
		Display.appendText("÷");
	//	input.expression.append("/");
	}
	public void inputNeq(ActionEvent event) {
		Display.appendText("-");
	//	input.expression.append("-");
	}
	public void inputPoint(ActionEvent event) {
		Display.appendText(".");
	//	input.expression.append(".");
	}
	public void inputPercent(ActionEvent event) {
		Display.appendText("%");
	//	input.expression.append("%");
	}
	public void inputRooting(ActionEvent event) {
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
	public void inputFactorial(ActionEvent event) {
		Display.appendText("!");
	//	input.expression.append("!");
	}
	public void inputEqual(ActionEvent event) {
	//	Display.appendText(Calculator.conversion(input.expression.toString()));
		System.out.println(Display.getText());
		Calculator cal  = new Calculator();
		double result = cal.calculate(Display.getText().toString());
	//	System.out.println(result);
		Display.setText(String.valueOf(result));
	}
}
