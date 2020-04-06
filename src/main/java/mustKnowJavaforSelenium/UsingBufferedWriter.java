package mustKnowJavaforSelenium;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UsingBufferedWriter {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String location = "G:\\FileWriterExampleUsingBufferedWriter.txt";
		String content = "This is my second File Writing program";
		
		FileWriter filewriter = new FileWriter(location);
		BufferedWriter buffer = new BufferedWriter(filewriter);
		buffer.write(content);
		buffer.close();
	}

}
