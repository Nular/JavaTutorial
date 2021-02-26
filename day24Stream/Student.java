package day24Stream;

import java.io.Serializable;

public class Student implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private int age;
	transient private int temp;
	
	public Student(String name, int age, int temp) {
		super();
		this.name = name;
		this.age = age;
		this.temp = temp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	} 
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("\t姓名:");
		s.append(name);
		s.append("\t年龄:");
		s.append(age);
		s.append("\t临时信息:");
		s.append(temp);
		s.append('\n');
		return s.toString();
	}
	
}
