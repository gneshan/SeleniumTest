package mustKnowJavaforSelenium;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonWritingExample {

	public static void main(String[] args) throws IOException {

JSONObject jsonobject = new JSONObject();
jsonobject.put("age", 1);
jsonobject.put("Name", "Ganeshan");

JSONArray array = new JSONArray();
array.add("Magical Smile");
array.add("Magnetic Eyes");

jsonobject.put("Special Characters", array);

String location = "Test.json";

FileWriter filewriter = new FileWriter(location);

BufferedWriter buffer = new BufferedWriter(filewriter);
String content = jsonobject.toJSONString();
buffer.write(content);
buffer.close();

//filewriter.write(jsonobject.toJSONString());
//filewriter.close();





	}

}
