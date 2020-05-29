package com.java8;



import java.io.FileReader;
import java.util.ArrayList;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class javafromjavascript {
	public static void main(String arg[])throws Exception{
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.eval(new FileReader("c:/javafromjavascript.js"));

		Invocable invocable = (Invocable) engine;

		Employee l[]={new Employee(),new Employee(),new Employee()};
		Object result = invocable.invokeFunction("fun1", l);
		System.out.println(result);
		

	}
}
