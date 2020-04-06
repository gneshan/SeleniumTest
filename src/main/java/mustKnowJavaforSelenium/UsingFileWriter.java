package mustKnowJavaforSelenium;

import java.io.FileWriter;
import java.io.IOException;

public class UsingFileWriter {

	public static void main(String[] args) throws IOException {
		
		
		String location = "G:\\FileWriterExample.txt";
		String content = "This is my first File Writing program";
		
		FileWriter filewriter = new FileWriter(location);
		filewriter.write(content);
		
		filewriter.close();

	}

}
