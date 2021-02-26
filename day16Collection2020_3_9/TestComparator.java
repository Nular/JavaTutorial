package day16Collection2020_3_9;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class TestComparator {
	/**
	 * Emp静态内部类，用于测试排序
	 * 为了测试Comparator，此处未实现Comparable接口
	 * @author Null
	 */
	static class Emp {
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
		
	}
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		// 重写Collocation 的 toString方法方便输出
		List<Emp> list = new LinkedList<TestComparator.Emp>() {
			@Override
			public String toString() {
				StringBuilder result = new StringBuilder();
				for(Object o : this) {
					result.append(o.toString());
					result.append("\n");
				}
				return result.toString();
			}
		};
		list.add(new Emp(1000, "emp1"));
		list.add(new Emp(1200, "emp2"));
		list.add(new Emp(1100, "emp3"));
		// 匿名内部类的Comparator，重写比较方法，传入sort中进行比较
		// 这种方式排序更灵活，可随意更改排序关键字
		Collections.sort(list, new Comparator<Emp>(){
			@Override
			public int compare(Emp e1, Emp e2) {
				return e1.salary - e2.salary;
			}
		});
		System.out.println(list);
	}
}
