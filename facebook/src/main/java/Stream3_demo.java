import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Stream3_demo {

	public static void main(String[] args) {
		/*
		 * Employee.persons().stream() .filter(Employee::isFemale) //return all female
		 * employee
		 * 
		 * .map(Employee::getName) .forEach(System.out::println);
		 * 
		 * Employee.persons().stream() .filter(Employee::isMale)
		 * .filter(p->p.getIncome()>4000.0) .map(Employee::getName)
		 * .forEach(System.out::println);
		 * 
		 * 
		 * double dd=Employee.persons().stream() .map(Employee::getIncome)
		 * .reduce(0.0,Double::sum);
		 * 
		 * System.out.println(dd);
		 * 
		 * long ll=Employee.persons().stream().count(); System.out.println(ll);
		 */

		/*List<String> name = Employee.persons().stream().map(Employee::getName).collect(ArrayList::new, ArrayList::add,
				ArrayList::addAll);

		List<String> name1 = Employee.persons().stream().map(Employee::getName).collect(Collectors.toList());
		System.out.println(name1);

		SortedSet<String> name2 = Employee.persons().stream().map(Employee::getName)
				.collect(Collectors.toCollection(TreeSet::new));
		System.out.println(name2);

		DoubleSummaryStatistics ds = Employee.persons().stream()
				.collect(Collectors.summarizingDouble(Employee::getIncome));

		System.out.println("income summary " + ds);

		Map<Long, String> mm = Employee.persons().stream()
				.collect(Collectors.toMap(Employee::getId, Employee::getName));

		System.out.println(mm);

		// {male= {a,c,d,f}, female= {s,d,c}}

		Map<Employee.Gender, String> mm1 = Employee.persons().stream() // return 7 record
				.collect(Collectors.toMap(Employee::getGender, Employee::getName,
						(oldValue, newValue) -> String.join(", ", oldValue, newValue)));

		System.out.println(mm1);

		Map<Employee.Gender, Integer> mm2 = Employee.persons().stream() // return 7 record
				.collect(Collectors.toMap(Employee::getGender, p -> 1, (oldValue, newValue) -> oldValue + newValue));

		System.out.println(mm2);

		String mm3 = Employee.persons().stream().map(Employee::getName)
				.collect(Collectors.joining(", ","All User List Are ----->  ","  Thank You"));

		System.out.println(mm3);*/
		
		/*Map<Employee.Gender, Long> mm5 = Employee.persons().stream() // return 7 record
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

		System.out.println(mm5);
		
		Map<Boolean, String> mm6 = Employee.persons().stream() // return 7 record
				.collect(Collectors.partitioningBy(Employee::isMale, Collectors.mapping(Employee::getName,
																						Collectors.joining(", "))));

		System.out.println(mm6);*/
		
		ExecutorService service=Executors.newFixedThreadPool(2);
		
		Runnable r1= () ->Employee.persons().forEach(Employee::print);
	//	Thread t=new Thread(r1);
	//	t.start();
		service.execute(r1);
		
		Runnable r2=()->{
			Consumer<Employee> st=(Employee e)->System.out.println("id "+e.getId());
			Employee.persons().forEach(st);
		};
		//Thread t1=new Thread(r2);
		//t1.start();
		service.execute(r2);
		
		service.shutdown();

	}

}






















