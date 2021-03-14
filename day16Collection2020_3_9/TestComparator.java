package day16Collection2020_3_9;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 测试Comparator接口，通过匿名内部类的形式重写compare方法，达成比较目的。</br>
 * 这种方法更灵活，适用于一次性排序以及需要修改排序方式时使用。</br>
 * 但是每次运行都会创建实例，性能堪忧，有两种解决方式:</br>
 * 	1. 声明一个单例内容，如<tt>privarte static Comparator cmp = new Comparator(){...}</tt> 这样每次调用就不会创建新的实例。
 * 	2. 使用lambda表达式(1.8及以后)，lambda表达式并不会创建实例，而是直接由jvm处理成内部代码的运行，没有了实例的创建和销毁。代码简洁的同时，运行效率也会更高。
 * @author Nular
 */
public class TestComparator {
	/**
	 * Emp静态内部类，用于测试排序
	 * 为了测试Comparator，此处未实现Comparable接口
	 * @author Nular
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
		// 重写Collocation 的 toString方法方便输出 实际项目中并不推荐这么写
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
