package com.facebook.controller;

public interface FacebookControllerInterface {
	public void ddProfile();   //by default method will be public and abstract
	public default void initialize() {
		System.out.println(" i am default method");
	}
	
	public default void initialize1() {
		System.out.println(" i am default method");
	}
	
	public default void initialize2() {
		System.out.println(" i am default method");
	}
	
	//public void calculateInterest(double pa,float r, int n);
	
	
}
