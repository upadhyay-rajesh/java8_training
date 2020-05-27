
public class Stream3_demo {

	public static void main(String[] args) {
		Employee.persons().stream()
		.filter(Employee::isFemale)
				.map(Employee::getName)
				.forEach(System.out::println);
		
		Employee.persons().stream()
		.filter(Employee::isMale)
		.filter(p->p.getIncome()>4000.0)
				.map(Employee::getName)
				.forEach(System.out::println);
		
		
		double dd=Employee.persons().stream()
			.map(Employee::getIncome)
				.reduce(0.0,Double::sum);
		
		System.out.println(dd);
		
		long ll=Employee.persons().stream().count();
		System.out.println(ll);

	}

}
