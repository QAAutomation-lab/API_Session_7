package day2.serializationPojo;

import org.testng.annotations.Test;

public class MyClass2 {
	String name;
	public int empId;
	private double salary;
	public String getName() {
		return name;
	}
	public int getEmpId() {
		return empId;
	}
	public double getSalary() {
		return salary;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
class Example3{
	@Test
	public void testPojo() {
		MyClass2 ref=new MyClass2();
		ref.setEmpId(505);
		ref.setName("Mumbai");
		ref.setSalary(95000.85);
		System.out.println(ref.getEmpId());
		System.out.println(ref.getName());
		System.out.println(ref.getSalary());
	}
}
