package day2.serializationPojo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.testng.annotations.Test;

class Demo implements Serializable{
	public int num1;
	public String name;
	public Demo(int num1,String name) {
		this.num1=num1;
		this.name=name;
	}
}
public class Example1 {
	@Test
	public void testSerialization() {
		Demo obj=new Demo(101,"Tester");
		String filename="SerializedFile.ser";		
		try {
			FileOutputStream fos=new FileOutputStream(filename);
			ObjectOutputStream out=new ObjectOutputStream(fos);
			//write java object into file
			out.writeObject(obj);
			out.flush();
			out.close();
			System.out.println("Demo class Object is serialized...");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Demo class num1: "+obj.num1);
		System.out.println("Demo class name: "+obj.name);
		obj.name="AutomationTester";
		obj.num1=505;
	}
	@Test
	public void testDeSerialization() {
		Demo ref=null;
		
		try {
			FileInputStream fis=new FileInputStream("SerializedFile.ser");
			ObjectInputStream in=new ObjectInputStream(fis);
			//read Java Object from serialized file
			ref=(Demo)in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Demo class num1: "+ref.num1);
		System.out.println("Demo class name: "+ref.name);
	}

}
