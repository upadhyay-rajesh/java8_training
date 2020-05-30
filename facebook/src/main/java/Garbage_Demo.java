
public class Garbage_Demo {
	static int counter=0;
	static Garbage_Demo g3;
	
	public Garbage_Demo() {
		counter=counter+1;
		System.out.println(counter);
	}

	public static void main(String[] args) {
		Garbage_Demo g1=new Garbage_Demo();
		g1.add();
		
		Garbage_Demo g2=new Garbage_Demo();
		g2.add();
		
		g1=null;
		g2=null;
		
		Runtime r=Runtime.getRuntime();
		r.gc();
		
		g3.add();
		
		g3=null;

	}
	
	public void add() {
		System.out.println("dcasd");
	}
	
	@Override
	public void finalize() {
		g3=new Garbage_Demo();		
		
		System.out.println("object called "+counter);
		counter=counter-1;
	}

}
