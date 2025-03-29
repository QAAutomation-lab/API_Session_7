package day1.jsonpractice;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class JSONFileops {
  @Test
  public void writeContentIntoJSONFile() {
		Map ref=new HashMap();
		//add required entries
		ref.put("Name", "Advik");
		ref.put("Email", "Abc@gmail.com");
		ref.put("Company", "Google");		
		System.out.println("Map entries: "+ref);
		System.out.println("Get value of 'Name' "+ref.get("Name"));
		System.out.println("Only Keys: "+ref.keySet());
		System.out.println("Only values: "+ref.values());		
		String jsonString=JSONValue.toJSONString(ref);
		System.out.println("JSON String: "+jsonString);
		
		//write JSON content into file
		try {
			FileWriter file = new FileWriter(".\\src\\test\\resources\\testdata\\UserDetails.json");
			file.write(jsonString);
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("JSON Content added into file....");
  }
  
  @Test
  public void readJSONContentFromFile() throws IOException, ParseException {
	  //provide JSON file location to FileReader class in constructor
	  FileReader read=new FileReader(".\\src\\test\\resources\\testdata\\UserDetails.json");
	  //create instance of JSONParser to parser file content into Object
	  JSONParser jsonParse=new JSONParser();
	  //using JSONPaser reference call parse method to convert JSON file content into Object
	  Object obj=jsonParse.parse(read);
	  //convert Object into JSONObject
	  JSONObject jObj=(JSONObject)obj;
	  System.out.println(jObj.get("Name"));
	  System.out.println(jObj.get("Email"));
	  System.out.println(jObj.get("Company"));
  }
}
