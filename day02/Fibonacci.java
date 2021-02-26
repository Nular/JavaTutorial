package day02;

public class Fibonacci {
	public static int getFibonacciRecursive(int n) {
		if(n <= 0) {
			return 0;
		}else if(n <= 2) {
			return 1;
		}else {
			return getFibonacciRecursive(n - 1) + getFibonacciRecursive(n - 2);
		}
	}
	
	public static int getFibonacciIterate(int n) {
		int now = 1, privious = 0;
		for (int i = 0; i < n; i++) {
			int temp = now;
			now += privious;
			privious = temp;
		}
		return now;
	}
	public static void main(String[] args) {
		long now = System.currentTimeMillis();
		int runTimes = 50;
		getFibonacciIterate(runTimes);
		System.out.println(System.currentTimeMillis() - now);
		
		now = System.currentTimeMillis();
		getFibonacciRecursive(runTimes);
		System.out.println(System.currentTimeMillis() - now);
	}
}
