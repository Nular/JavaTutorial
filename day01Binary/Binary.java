package day01Binary;

public class Binary {
	public static void main(String[] args) {
		int binary = 0xFFFF;
		System.out.println(binary);
		System.out.println(Integer.toBinaryString(binary));
		System.out.println(Long.toOctalString(binary));
		System.out.println(Character.MAX_RADIX + "\t" + Character.MIN_RADIX);
		for (char i = 'a'; i <= 'z' ; i++) {
			// 36进制下，每个字母所代表的十进制数字
			System.out.println(i + "\t" + Character.digit(i, 36));
		}
	}
}
