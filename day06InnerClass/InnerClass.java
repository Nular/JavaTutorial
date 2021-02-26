package day06InnerClass;


public class InnerClass {
	public static void main(String[] args) {
		OuterClass.Inner inner = new OuterClass.Inner(10);
		OuterClass.Inner.print();
		System.out.println(inner.getNumber());
	}
}

class OuterClass{
	// 静态内部类，可以直接调用
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
			System.out.println("Inner.Print");
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