import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class Employee {
	private long id;
	private String name;
	private LocalDate dob;
	private double income;
	
	public static enum Gender{
		MALE,FEMALE
	}
	
	private Gender gender;
	
	public Employee(long id,String name,LocalDate dob,double income,Gender gender) {
		this.dob=dob;
		this.id=id;
		this.gender=gender;
		this.name=name;
		this.income=income;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public boolean isMale() {
		return this.gender==Gender.MALE;
	}
	public boolean isFemale() {
		return this.gender==Gender.FEMALE;
	}
	
	public static List<Employee> persons(){
		Employee p1=new Employee(1,"Abhisek",LocalDate.of(1983, Month.JANUARY, 1),2343.0,Gender.MALE);
		Employee p2=new Employee(2,"Rajesh",LocalDate.of(1984, Month.FEBRUARY, 1),5000.0,Gender.MALE);
		Employee p3=new Employee(3,"Mahesh",LocalDate.of(1985, Month.JANUARY, 1),2343.0,Gender.MALE);
		Employee p4=new Employee(4,"Rohan",LocalDate.of(1986, Month.JANUARY, 1),7000.0,Gender.MALE);
		Employee p5=new Employee(5,"Jyothi",LocalDate.of(1987, Month.MARCH, 1),2343.0,Gender.FEMALE);
		Employee p6=new Employee(6,"Shalini",LocalDate.of(1988, Month.JANUARY, 1),9000.0,Gender.FEMALE);
		Employee p7=new Employee(7,"Reema",LocalDate.of(1989, Month.APRIL, 1),12000.0,Gender.FEMALE);
		
		List<Employee> per=Arrays.asList(p1,p2,p3,p4,p5,p6,p7);
		return per;
	}
	
	public void print() {
		System.out.println("Id : "+id+" Name : "+name+" Date of Birth :"+dob+" Salary : "+income+" Gender : "+gender);
	}
	
}












