import java.util.Arrays;
import java.util.List;

public class Dish {
	public enum Type {MEAT, FISH, OTHER}
	private String name;
	private boolean vegetarian;
	private int calories;
	private Type type;
	
	public Dish(String name,boolean vegetarian,int calories, Type type) {
		this.name=name;
		this.vegetarian=vegetarian;
		this.calories=calories;
		this.type=type;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isVegetarian() {
		return vegetarian;
	}
	public void setVegetarian(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	public String toString() {
		return name;
	}
	
	public static List<Dish> menu=Arrays.asList(
				new Dish("paneer", true, 1200, Dish.Type.OTHER),
				new Dish("chicken", false, 1500, Dish.Type.MEAT),
				new Dish("pizza", true, 1600, Dish.Type.OTHER),
				new Dish("rice", true, 500, Dish.Type.OTHER),
				new Dish("chicken2", false, 15002, Dish.Type.MEAT),
				new Dish("chicken3", false, 15003, Dish.Type.MEAT),
				new Dish("chicken4", false, 15004, Dish.Type.MEAT),
				new Dish("chicken5", false, 15005, Dish.Type.MEAT),
				new Dish("chicken6", false, 15006, Dish.Type.MEAT)
			
			);
	
	
}















