package mustKnowJavaforSelenium;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadingUsingBufferedReader {

	public static void main(String[] args) throws IOException {
		
		String location = "G:\\FileWriterExample.txt";
		
		FileReader filereader = new FileReader(location);
		
		
		BufferedReader content = new BufferedReader(filereader);
		
		String value;
		
		
		while ((value = content.readLine())!=null){
			
			System.out.println(value);
		}
		
		content.close();
		

	}

}
