
public class Strategy_Design_Demo {

	public static void main(String[] args) {
		Validator vv=new Validator(new IsNumeric());
		//System.out.println(vv.validate("123"));
		
		Validator vv1=new Validator(new IsAlllowercase());
		System.out.println(vv1.validate("abcd"));
		
		//jdk8 approach
		Validator vv2=new Validator((String s)->s.matches("\\d+"));
		System.out.println(vv2.validate("123"));
		Validator vv3=new Validator((String s)->s.matches("[a-z]+"));
		System.out.println(vv3.validate("abcd"));
	}
	
	interface ValidationStrategy{
		public boolean execute(String s);
	}
	
	static private class IsAlllowercase implements ValidationStrategy{

		@Override
		public boolean execute(String s) {
			// TODO Auto-generated method stub
			return s.matches("[a-z]+");
		}
		
	}
	static private class IsNumeric implements ValidationStrategy{

		@Override
		public boolean execute(String s) {
			// TODO Auto-generated method stub
			return s.matches("\\d+");
		}
		
	}
	
	static private class Validator{
		private ValidationStrategy vv;
		public Validator(ValidationStrategy vv) {
			this.vv=vv;
		}
		public boolean validate(String s) {
			return vv.execute(s);
		}
	}

}












