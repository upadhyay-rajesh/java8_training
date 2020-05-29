package factory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Factory_Design_Demo {

	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("enter your choice ");
		String c=br.readLine();
		
		Product p=ProductFactory.createProductFactory1(c);
		System.out.println(p);
	}
	
	static private class ProductFactory{
		public static Product createProductFactory(String name) {
			switch(name) {
			case "loan" :    return new LoanAccount();
			case "saving" :  return new SavingAccount();
			case "current" : return new CurrentAccount();
			default : System.out.println("wrong choice");
			}
			return null;
		}
		//jdk8 approach
		
		public static Product createProductFactory1(String name) {
			Supplier<Product> p=map.get(name);
			if(p !=null) return p.get();
			return null;
		}
		
	}
	
	static private interface Product{}
	static private class LoanAccount implements Product{}
	static private class SavingAccount implements Product{}
	static private class CurrentAccount implements Product{}
	
	//jdk8 approach
	static private Map<String,Supplier<Product>> map=new HashMap<>();
	
	static {
		map.put("loan", LoanAccount::new);
		map.put("saving", SavingAccount::new);
		map.put("current", CurrentAccount::new);
	}

}











