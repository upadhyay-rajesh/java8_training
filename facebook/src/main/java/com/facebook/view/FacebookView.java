package com.facebook.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.facebook.controller.FacebookController;
import com.facebook.controller.FacebookControllerInterface;
import com.facebook.utility.ControllerFactory;

public class FacebookView {

	public static void main(String[] args) throws IOException{
		System.out.println("***************MAIN MENU*************");
		System.out.println("press 1 for create record");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter your input");
		
		int c=Integer.parseInt(br.readLine());
		
		FacebookController fc1=ControllerFactory.createObject();
		
		FacebookControllerInterface fc=fc1::createProfile;
		FacebookControllerInterface fc11=fc1::deleteProfile;
		FacebookControllerInterface fc2=fc1::viewProfile;
		FacebookControllerInterface fc3=fc1::editProfile;
		
		
		switch(c) {
		case 1 :  fc.initialize();
			break; 
			default: System.out.println("wrong input");
		}

	}

}
