package day06InnerClass.testAnonymity;

/**
 * 用来测试匿名内部类的标识等。
 * @author Nular
 */
public class TestAnonymity {
	// 静态内部类 Temp1 
	// class day06InnerClass.testAnonymity.TestAnonymity$Temp1
	static class Temp1 extends Emp{
		public Temp1(String name, int salary) {
			super(name, salary);
		}
	}
	
	public static void main(String[] args) {
		// 局部内部类 Temp2
		// class day06InnerClass.testAnonymity.TestAnonymity$1Temp2
		class Temp2 extends Emp{
			public Temp2(String name, int salary) {
				super(name, salary);
			}
		}
		
		String name = "";
		int salary = 0;
		Emp emp0 = new Emp(name, salary);
		// 匿名内部类，重写Emp的toString()方法。 
		// class day06InnerClass.testAnonymity.TestAnonymity$1
		Emp emp1 = new Emp(name, salary) {
			@Override
			public String toString() {
				return super.toString();
			}
		};
		
		Emp emp2 = new Temp1(name, salary);
		Emp emp3 = new Temp2(name, salary);
		Emp emp4 = getTemp3();
		
		System.out.println(emp0.getClass());
		System.out.println(emp1.getClass());
		System.out.println(emp2.getClass());
		System.out.println(emp3.getClass());
		System.out.println(emp4.getClass());
		
	}
	
	/**
	 * @return 返回一个 Temp3 实例
	 */
	public static Emp getTemp3() {
		// class day06InnerClass.testAnonymity.TestAnonymity$1Temp3
		class Temp3 extends Emp{
			public Temp3(String name, int salary) {
				super(name, salary);
			}
		}
		return new Temp3("", 0);
	}
}
