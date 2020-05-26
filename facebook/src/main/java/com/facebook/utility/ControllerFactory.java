package com.facebook.utility;

import com.facebook.controller.FacebookController;
import com.facebook.controller.FacebookControllerInterface;

public class ControllerFactory {
	
	private ControllerFactory() {}
	
	public static FacebookController createObject() {
		return new FacebookController();
	}
}
