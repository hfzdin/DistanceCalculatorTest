package com.example.distanceCalculator;

public class Calculator {

	private double firstVal;
	private String firstUnit;
    private double secondVal;
    private String secondUnit;
    private String answerUnit;
    private double answer;
	
    public double getFirstVal() {
		return firstVal;
	}
	public void setFirstVal(double firstVal) {
		this.firstVal = firstVal;
	}
	public String getFirstUnit() {
		return firstUnit;
	}
	public void setFirstUnit(String firstUnit) {
		this.firstUnit = firstUnit;
	}
	public double getSecondVal() {
		return secondVal;
	}
	public void setSecondVal(double secondVal) {
		this.secondVal = secondVal;
	}
	public String getSecondUnit() {
		return secondUnit;
	}
	public void setSecondUnit(String secondUnit) {
		this.secondUnit = secondUnit;
	}
	public String getAnswerUnit() {
		return answerUnit;
	}
	public void setAnswerUnit(String answerUnit) {
		this.answerUnit = answerUnit;
	}
	public double getAnswer() {
		return answer;
	}
	public void setAnswer(double answer) {
		this.answer = answer;
	}
	
}
