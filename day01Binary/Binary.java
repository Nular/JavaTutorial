package day01Binary;

public class Binary {
	public static void main(String[] args) {
		int binary = 0xFFFF;
		System.out.println(binary);
		// 测试转换八进制和二进制的方法。
		System.out.println(Integer.toBinaryString(binary));
		System.out.println(Integer.toOctalString(binary));
		// Character中最小进制和最大进制数
		System.out.println(Character.MAX_RADIX + "\t" + Character.MIN_RADIX);
		// 36进制下，每个字母所代表的十进制数字 
		// 使用Character的digit(char ch, int radix)方法。 返回ch所对应radix进制下的真值
		for (char i = 'a'; i <= 'z' ; i++) {
			System.out.println(i + "\t" + Character.digit(i, 36));
		}
	}
}
