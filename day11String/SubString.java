package day11String;

public class SubString {
	public static void main(String[] args) {
		String temp;
		// 此处\t前的空格为/u000A0的全角空格
		temp = "12345" + (char)0xA0  + (char)32 + '\t';
		
		System.out.println("初始长度:" + temp.length());
		System.out.println("substring(3)长度: " + temp.substring(3).length());
		System.out.println("substring(1,3)长度:" + temp.substring(1,3).length());
		System.out.println("tirm后长度" + temp.trim().length());
		
		// Java的trim只能去除半角英文空格，/u00A0是无法去除的。
		System.out.println(("" + (char)0xA0).length());
		System.out.println(("" + (char)0xA0).trim().length());
	}
}
