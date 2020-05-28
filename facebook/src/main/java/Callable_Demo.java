import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Callable_Demo {

	public static void main(String[] args) {
		List<Integer> integer=Arrays.asList(1,2,3,4,5,6);
		
		/*Callable<Integer> cc=()->{
			int result=integer.stream().mapToInt(i->i.intValue()).sum();
			return result;
		};
		ExecutorService service=Executors.newSingleThreadExecutor();
		Future<Integer> ff=service.submit(cc);
		try {
			int r=ff.get();
			System.out.println("result is "+r);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		integer.stream().map(data->CompletableFuture.supplyAsync(()->getData(data))).//((1,4,9,16,25,36))
			map(cf->cf.thenApply(n->n*n)).map(t->t.join()).forEach(s->System.out.println(s));
		
		long ll=integer.stream().map(data->CompletableFuture.supplyAsync(()->data+data)). //(2,4,6,8,10,12)
		map(f->f.whenComplete((result,error)->System.out.println(result +" Error "+error))).count();
		System.out.println(ll);
				
	}
	
	private static int getData(int a) {
		return a*a;
	}

}









