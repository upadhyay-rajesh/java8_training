package com.facebook.utility;

public class Method_Referencing_Demo {
	
	public void add() {
		System.out.println("i am add method of class Method_Referencing_Demo");
	}

	public void sub() {
		System.out.println("i am add method of class Method_Referencing_Demo");
	}

	public void mult() {
		System.out.println("i am add method of class Method_Referencing_Demo");
	}
	
	public static void main(String arg[]) {
		Method_Ref_Interface mm=new Method_Referencing_Demo()::add;
		mm.getData();
		
		Method_Ref_Interface mm1=new Method_Referencing_Demo()::sub;
		mm1.getData();
		
		Method_Ref_Interface mm2=new Method_Referencing_Demo()::mult;
		mm2.getData();
	}
}
