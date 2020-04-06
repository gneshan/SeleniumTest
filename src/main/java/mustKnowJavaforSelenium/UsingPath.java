package mustKnowJavaforSelenium;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingPath {

	public static void main(String[] args) throws IOException {
		String location = "G:\\FileWriterExampleUsingPath.txt";
		String content = "This is my Fourth File Writing program";

		Path path = Paths.get(location);
		Files.write(path, content.getBytes());


	}

}
