package day14Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Day15asg03_DoDiffer {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入两个日期，格式为(yy-MM-dd):");
		while(sc.hasNext()) {
			String date1 = sc.next();
			String date2 = sc.next();
			int days = getDays(date1, date2);
			System.out.println("两日期天数之差为:"+days);
			System.out.println("输入两个日期，格式为(yy-MM-dd):");
		}
		sc.close();
	}
	
	/**
	 *	传入date1, date2两个字符串表示两个日期，返回它们相差的天数
	 * 	传入字符串满足(yy-MM-dd)的格式，否则则会解析失败抛出异常。
	 * @param date1
	 * 		比date2早的一个日期字符串
	 * @param date2
	 * 		比date1晚的一个日期字符串
	 * @return days
	 * 		返回一个int类型的天数，是date1和date2日期天数的差
	 * @throws ParseException
	 */
	private static int getDays(String date1, String date2) throws ParseException {
		String patten = "yy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(patten);
		Calendar cDate1 = Calendar.getInstance();
		Calendar cDate2 = Calendar.getInstance();
		cDate1.setTime(sdf.parse(date1));
		cDate2.setTime(sdf.parse(date2));
		// 从日期1到年底的天数
		int days = 365 - cDate1.get(Calendar.DAY_OF_YEAR);
		// 两日期之间，间隔的年份数years
		int years = cDate2.get(Calendar.YEAR) - cDate1.get(Calendar.YEAR) - 1;
		days += years * 365 
			  + leapYearCount(cDate1.get(Calendar.YEAR), cDate2.get(Calendar.YEAR))
			  + cDate2.get(Calendar.DAY_OF_YEAR);
		return days;
	}

	/**
	 * 返回两个年份之间存在的闰年数
	 * 不包括传入的两个年份
	 * @param startYear
	 * 		起始年份，比endYear 要早
	 * @param endYear
	 * 		结束年份，比startYear 要晚
	 * @return 
	 * 		int类型
	 * 
	 */
	private static int leapYearCount(int startYear, int endYear) {
		int count = 0;
		for (int i = startYear + 1; i < endYear; i++) 
			if(leapYearJudge(i))
				count++;
		return count;
	}
	/**
	 * 判断某一年是否是闰年
	 * @param year
	 * 		传入的年份，判断year是否为闰年
	 * @return 
	 * 		boolean类型
	 */
	private static boolean leapYearJudge(int year) {
		if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
			return true;
		return false;
	}
	
}
