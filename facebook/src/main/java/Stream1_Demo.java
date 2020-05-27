import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream1_Demo {

	public static void main(String[] args) {
		/*
		List<Integer> numbers=Arrays.asList(1,4,6,8,9);
		int sum=0;
		for(int n :numbers) {
			if(n%2==1) { //filter
				int sq=n*n; //map
				sum =sum+sq;
			}
		}
		System.out.println(sum);
		
		
		
		numbers.stream()       //converting collection into stream
				.filter(n->n%2==1)  //return 1,9
				.map(n->n+n)		// return [2, 18] array
				.map(n->n*n*n)
				.sorted()
				//.reduce(0,Integer::sum); //return 1+81=82
				.forEach(System.out::println);
		
		//System.out.println(s);
		
		
		//numbers.parallelStream();
		*/
		Stream<String> st=Stream.of("i love java!");
		st.forEach(System.out::println);
		Stream<String> st1=Stream.of("Abinash","Jagdish","chamay","vipul");
		st1.forEach(System.out::println);
		
		Stream<String> st2=Stream.<String>builder()
				.add("abhi")
				.add("abc")
				.build();
		
		st2.forEach(System.out::println);
		
		IntStream ii=IntStream.range(1, 9);
		ii.forEach(System.out::println);
		
		OptionalInt i1=IntStream.of(4,8,12).filter(n->n%2==1).max();
		if(i1.isPresent()) {
			int i2=i1.getAsInt();
			System.out.println("maximum nu is "+i2);
		}
		else {
			System.out.println("record not found ");
		}

	}

}






















