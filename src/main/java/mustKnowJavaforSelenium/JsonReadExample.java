package mustKnowJavaforSelenium;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReadExample {

	public static void main(String[] args) throws IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		//Getting the location of file with file name
		FileReader filereader = new FileReader("Test.json");
		//Parsing this file and storing it Object data type
		Object parsedObject = parser.parse(filereader);
		//Since get methods to read json file are in Jsonobject class, we have to store it in Jsonobject data Type and we have to Type cast
		JSONObject jsonobject = (JSONObject) parsedObject;
		
		String name = (String) jsonobject.get("Name");
		long age = (long) jsonobject.get("age");
		JSONArray array = (JSONArray) jsonobject.get("Special Characters");
		
		Iterator iterator = array.iterator();
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		while(iterator.hasNext()) {
			
			System.out.println("Special Characters: " + iterator.next());
		}
		
		
		
		
		
		
		
		
		
		

	}

}
