package mustKnowJavaforSelenium;

import java.io.FileOutputStream;
import java.io.IOException;

public class UsingFileOutputStream {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String location = "G:\\FileWriterExampleUsingOutputStream.txt";
		String content = "This is my Third File Writing program";
		
		FileOutputStream fileoutput = new FileOutputStream(location);
		
		byte[] ByteContent = content.getBytes();
		fileoutput.write(ByteContent);
		fileoutput.close();
		
		

	}

}
