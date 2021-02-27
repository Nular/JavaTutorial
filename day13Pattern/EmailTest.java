package day13Pattern;

import java.util.Scanner;

/**
 * 用String自带的matches(String regex)方法判断输入是否为合法Email
 * @author Nular
 */
public class EmailTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String email = "";
		String regex = "^\\w+@(\\w+\\.)*\\w+$";
		while(sc.hasNext()) {
			email = sc.next();
			System.out.println(email.matches(regex) ? "合法Email" : "不合法Email");
		}
		sc.close();
	}
}
