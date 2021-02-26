package day06InnerClass.testAnonymity;

/**
 * 用来测试匿名内部类的标识等。
 * @author Nular
 */
@SuppressWarnings("unused")
public class TestAnonymity {
	static class temp1 extends Emp{
		public temp1(String name, int salary) {
			super(name, salary);
		}
	}
	private void print() {
		;
	}
	public static void main(String[] args) {
		class temp2 extends Emp{
			public temp2(String name, int salary) {
				super(name, salary);
			}
		}
		
		String name = "";
		int salary = 0;
		Emp emp0 = new Emp(name, salary);
		Emp emp1 = new Emp(name, salary) {
			@Override
			public String toString() {
				return super.toString();
			}
		};
		Emp emp2 = new temp1(name, salary);
		Emp emp3 = new temp2(name, salary);
		
		System.out.println(emp0.getClass());
		System.out.println(emp1.getClass());
		System.out.println(emp2.getClass());
		System.out.println(emp3.getClass());
	}
}
