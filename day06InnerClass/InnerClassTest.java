package day06InnerClass;


public class InnerClassTest {
	public static void main(String[] args) {
		Outer.Inner inner = new Outer.Inner(10);
		Outer.Inner.print();
		System.out.println(inner.getNumber());
	}
}

class Outer{
	// 静态内部类，不需要实例化即可直接调用
	public static class Inner{
		// 私有属性
		private int number = 0;
		// 构造器
		public Inner(int number) {
			super();
			this.number = number;
		}
		// 静态方法
		public static void print() {
			System.out.println("Inner.Print()");
		}
		// getter 和 setter
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
	}
}