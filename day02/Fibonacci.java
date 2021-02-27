package day02;

public class Fibonacci {
	/**
	 * 递归求斐波那契数列
	 * @param n 传入以求第n个斐波那契数
	 * @return 第n个斐波那契数
	 */
	public static int getFibonacciRecursive(int n) {
		if(n <= 0) {
			return 0;
		}else if(n <= 2) {
			return 1;
		}else {
			return getFibonacciRecursive(n - 1) + getFibonacciRecursive(n - 2);
		}
	}
	
	/**
	 * 迭代法求斐波那契数
	 * @param n 传入以求第n个斐波那契数
	 * @return 第n个斐波那契数
	 */
	public static int getFibonacciIterate(int n) {
		int now = 1, privious = 0;
		for (int i = 0; i < n; i++) {
			int temp = now;
			now += privious;
			privious = temp;
		}
		return now;
	}
	/**
	 * 测试递归和迭代两种方式的运行效率
	 * @param args 命令行调用参数
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int runTimes = 40;
		getFibonacciIterate(runTimes);
		System.out.println("迭代法运行时间:" + (System.currentTimeMillis() - start) + "ms");
		
		start = System.currentTimeMillis();
		getFibonacciRecursive(runTimes);
		System.out.println("递归法运行时间:" + (System.currentTimeMillis() - start)+ "ms");
	}
}
