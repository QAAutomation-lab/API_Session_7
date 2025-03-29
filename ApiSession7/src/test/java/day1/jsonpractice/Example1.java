package day1.jsonpractice;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.testng.annotations.Test;

public class Example1 {

	@Test
	public void workingWithJSONObject() {
		JSONObject ref=new JSONObject();
		//add required entries
		ref.put("Name", "Advik");
		ref.put("Email", "Abc@gmail.com");
		ref.put("Company", "Google");		
		System.out.println("JSONObject entries: "+ref);
		System.out.println("Get value of 'Name' "+ref.get("Name"));
		System.out.println("Only Keys: "+ref.keySet());
		System.out.println("Only values: "+ref.values());
	}
	
	@Test
	public void convertingMapintoJSONString() {
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
	}
	
	@Test
	public void convertingJSONStringIntoJSONObject() {
		String str="{\"Company\":\"Google\",\"Email\":\"Abc@gmail.com\",\"Name\":\"Advik\"}";
		
		//Convert JSONString into Object
		Object obj=JSONValue.parse(str);
		//Convert Object into JSONObject
		JSONObject jsonObj=(JSONObject)obj;
		System.out.println("JSON Object values: "+jsonObj);
		
		System.out.println("Company name is "+jsonObj.get("Company"));
	}
}
