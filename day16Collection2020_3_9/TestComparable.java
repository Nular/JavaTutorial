package day16Collection2020_3_9;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 测试Comparable接口。
 * @author Nular
 */
public class TestComparable {
	/**
	 * 测试实现Comparable接口后Collocations的sort方法流程。
	 * @author Nular
	 */
	static class Emp implements Comparable<Emp>{
		private int salary;
		private String name;
		
		public Emp(int salary, String name) {
			super();
			this.salary = salary;
			this.name = name;
		}
		
		@Override
		public String toString() {
			return this.name + "'s Salary is: " + this.salary;
		}
		// Getter & Setter
		public int getSalary() {
			return salary;
		}

		public void setSalary(int salary) {
			this.salary = salary;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}


		@Override
		/**
		 * 以姓名作为排序依据。
		 */
		public int compareTo(Emp anotherEmp) {
			return this.name.compareTo(anotherEmp.name);
		}
		
	}
	
	public static void main(String[] args) {
		List<Emp> list = new LinkedList<Emp>();
		list.toString();
		list.add(new Emp(1000, "emp1"));
		list.add(new Emp(1200, "emp2"));
		list.add(new Emp(1100, "emp3"));
		Collections.sort(list);
		System.out.println(list);
	}
}	
