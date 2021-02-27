package day01Binary;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 测试多进制的写法。
 * @author Nular
 */
public class Radix36 {
	/**
	 * 对于data中存放的36进制串进行增1操作。
	 * data作为Deque类型，本方法内使用了队尾拉取和队尾进队两种，因此是一个倒置的栈。
	 * @param data 传入的36进制串 双端队列
	 */
	public static void increase(Deque<Character> data) {
		// 队中空时，pollLast()返回null而不是抛出异常。
		Character temp = data.pollLast();
		if(temp == null) { // data初始为空，则添加1进栈
			temp = '1';
			data.offer(temp);
			return;
		}else if(++temp == 'z' + 1) { // 递归进位前一位
			increase(data);
			data.offer('0');
		}else if(temp == '9' + 1) { // 从9进位到a
			data.offer('a');
		}else if(temp >= '0' && temp <= '9' // 正常情况
				|| temp >='a' && temp <= 'z') {
			data.offer(temp);
		}
	}
	
	/**
	 * 将十进制的 {@code num} 转换为 {@code radix} 进制的表示
	 * @param num 一个十进制int类型数
	 * @param radix ∈[2,36]
	 * @return {@code radix} 进制数串
	 * @see Character#forDigit(int, int)
	 */
	public static String forDigit(int num, int radix) {
		StringBuilder s = new StringBuilder();
		for(; num > 0; num /= radix) {
			s.insert(0, Character.forDigit(num % radix, radix));
		}
		return s.toString();
	}
	
	public static void main(String[] args) {
		Deque<Character> data = new LinkedList<Character>();
		// 测试从 0 增长到 36*36，即36进制下的100
		for(int i = 0 ; i < 36*36 ; i++) {
			increase(data);
			System.out.println(data);
		}
		
		System.out.println(forDigit(36, 36));
		System.out.println(forDigit(36*36, 36));
		System.out.println(forDigit(65535, 2));
	}
}
