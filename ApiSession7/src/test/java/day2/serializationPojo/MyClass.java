package day2.serializationPojo;

import org.testng.annotations.Test;

public class MyClass {
	String name;
	public int empId;
	private double salary;
	public MyClass(String name, int empId,double salary) {
		this.name=name;
		this.empId=empId;
		this.salary=salary;
	}
	public String getName() {
		return name;
	}
	public int getEmpId() {
		return empId;
	}
	public double getSalary() {
		return salary;
	}
}
class Example2{
	@Test
	public void testPojo() {
		MyClass ref=new MyClass("Pune",110,45000.36);
		System.out.println(ref.getEmpId());
		System.out.println(ref.getName());
		System.out.println(ref.getSalary());
	}
}
