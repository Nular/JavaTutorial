package day02;

public class LeapYear {
	/**
	 * 判断某年是否为闰年
	 * @param year
	 * @return
	 */
	public static boolean isLeapYear(int year) {
		// 逻辑与优先级比逻辑或要高，因此不加括号结果依然正确。
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
	public static void main(String[] args) {
		System.out.println(isLeapYear(2020));
	}
}
