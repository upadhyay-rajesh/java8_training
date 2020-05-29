import java.util.ArrayList;
import java.util.List;

public class Observer_Demo {

	public static void main(String[] args) {
		Feed f=new Feed();
		/*f.registerObserver(new NYTimes());
		f.registerObserver(new LEMondey());
		f.registerObserver(new Guardian());
		
		f.notifyObserver("Mr. Trumph has warn for India China Dispute ");
		*/
		
		//jdk8 approach
		f.registerObserver((String tweet)->{
			if(tweet !=null  && tweet.contains("Trumph")) {
				System.out.println("yet another new is related with Donald "+tweet);
			}
			
		});
		f.registerObserver((String tweet)->{
		
			if(tweet !=null  && tweet.contains("queen")) {
				System.out.println("yet another new is related with queen "+tweet);
			}
			
		});
		f.registerObserver((String tweet)->{
			
			if(tweet !=null  && tweet.contains("wine")) {
				System.out.println("yet another new is related with wine "+tweet);
			}
		});
		
		f.notifyObserver("Mr. Trumph has warn for India China Dispute ");

	}
	
	interface Observer{
		void inform(String tweet);
	}
	/*
	static private class NYTimes implements Observer{

		@Override
		public void inform(String tweet) {
			if(tweet !=null  && tweet.contains("Trumph")) {
				System.out.println("yet another new is related with Donald "+tweet);
			}
			
		}
		
	}
	
	static private class LEMondey implements Observer{

		@Override
		public void inform(String tweet) {
			if(tweet !=null  && tweet.contains("queen")) {
				System.out.println("yet another new is related with queen "+tweet);
			}
			
		}
		
	}
	
	static private class Guardian implements Observer{

		@Override
		public void inform(String tweet) {
			if(tweet !=null  && tweet.contains("wine")) {
				System.out.println("yet another new is related with wine "+tweet);
			}
			
		}
		
	}
	*/
	interface Subject{
		void registerObserver(Observer o);
		void notifyObserver(String tweet);
	}
	
	static private class Feed implements Subject{
		private List<Observer> ob=new ArrayList<>();
		
		public void registerObserver(Observer o) {
			this.ob.add(o);
		}

		@Override
		public void notifyObserver(String tweet) {
			/*for(Observer oo:ob) {
				oo.inform(tweet);
			}
			*/
			ob.forEach(o->o.inform(tweet));
			
		}
	}

}















