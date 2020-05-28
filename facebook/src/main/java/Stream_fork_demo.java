import java.util.stream.Stream;
import static java.util.stream.Collectors.*;
public class Stream_fork_demo {

	public static void main(String[] args) {
		processMenu();

	}

	private static void processMenu() {
		
		//System.out.println(Dish.menu);
		Stream<Dish> menuStream=Dish.menu.stream();  //return all the dishesh
		
		MyForker.Result result=new MyForker<Dish>(menuStream)
				.fork("shortMenu", s->s.map(Dish::getName).collect(joining(", ")))
				.fork("totalCalories", s->s.mapToInt(Dish::getCalories).sum())
						.fork("disheshByType",s->s.collect(groupingBy(Dish::getType)))
						.getResult();
		
		System.out.println("Menu Of Dishesh "+result.get("shortMenu"));
		System.out.println("Total Calories "+result.get("totalCalories"));
		
		System.out.println("disheshByType "+result.get("disheshByType"));
		
	}

}
