package com.care.di_test02;

public class SaveClass {
	private int num1, num2,result;
	private String op;
	private PrintClass pc;
	private OperationClass oc;
	
	public void operationClass() {result = oc.operation(num1,num2,op);} //사용자가 operationClass를 호출하면 operation이 호출되고
	public void printClass() {pc.printFunc(num1,op,num2,result);}
	
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public PrintClass getPc() {
		return pc;
	}
	public void setPc(PrintClass pc) {
		this.pc = pc;
	}
	public OperationClass getOc() {
		return oc;
	}
	public void setOc(OperationClass oc) {
		this.oc = oc;
	}

}
