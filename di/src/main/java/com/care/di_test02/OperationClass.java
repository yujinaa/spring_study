package com.care.di_test02;

public class OperationClass {
	public int operation(int n1, int n2, String op) {
		if(op.equals("+")) {
			return n1 + n2;
		}else if(op.equals("-")) {
			return n1 -n2;
		}
		return 0;
	}
}
