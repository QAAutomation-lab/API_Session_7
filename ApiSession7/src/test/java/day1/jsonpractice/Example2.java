package day1.jsonpractice;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Example2 {
  @Test
  public void sampleJsonArray() {
	  JSONArray obj=new JSONArray();
	  //add required entries
	  obj.add("Apple");
	  obj.add("Orange");
	  obj.add("Grapes");
	  obj.add("Mango");
	  System.out.println("JSONArray elements are: "+obj);
  }
  
  @Test
  public void sampleJsonArray2() {
	  	JSONObject ref1=new JSONObject();
		//add required entries
		ref1.put("Name", "Advik");
		ref1.put("Email", "Abc@gmail.com");
		ref1.put("Company", "Google");		
		System.out.println("JSONObject entries: "+ref1);
		
		JSONObject ref2=new JSONObject();
		//add required entries
		ref2.put("Name", "Aman");
		ref2.put("Email", "xyz@gmail.com");
		ref2.put("Company", "IBM");		
		System.out.println("JSONObject entries: "+ref2);
		
		JSONObject ref3=new JSONObject();
		ref3.put("emp", ref1);
		System.out.println("JSONObject ref3: "+ref3);
		
		JSONObject ref4=new JSONObject();
		ref4.put("emp", ref2);
		System.out.println("JSONObject ref4: "+ref4);
		
		JSONArray obj=new JSONArray();
		obj.add(ref3);
		obj.add(ref4);
		System.out.println("JSONArray value: "+obj);
  }
}
