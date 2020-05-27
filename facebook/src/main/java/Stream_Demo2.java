import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Stream_Demo2 {

	public static void main(String[] args) {
		Path p=Paths.get("e:/appu/MANISH_GSVM_SOFTWARE.pdf");
		try(Stream<String> lines=Files.lines(p)){
			lines.forEach(System.out::println);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		Path p1=Paths.get("e:/appu");
		try(Stream<Path> lines1=Files.walk(p1)){
			//lines1.forEach(System.out::println);
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}

}
