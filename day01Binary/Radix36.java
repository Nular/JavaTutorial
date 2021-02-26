package day01Binary;

import java.util.LinkedList;

public class Radix36 {
	/**
	 * 对于data中存放的36进制串进行增1操作
	 * @param data
	 */
	public static void increase(LinkedList<Character> data) {
		Character temp = data.pollLast();
		if(temp == null) { // data初始为空，则添加1进栈
			temp = '1';
			data.offer(temp);
			return;
		}else if(++temp == 'z' + 1) { // z进位，则前一位也需要进位，递归进位前一位
			increase(data);
			data.offer('0');
		}else if(temp == '9' + 1) { // 从9进位到a
			data.offer('a');
		}else if(temp >= '0' && temp <= '9' // 正常情况
				|| temp >='a' && temp <= 'z') {
			data.offer(temp);
		}
	}
	public static void main(String[] args) {
		LinkedList<Character> data = new LinkedList<Character>();
		
		for(int i = 0 ; i < 36*36 ; i++) {
			increase(data);
			System.out.println(data);
		}
	}
}
