package day14Date;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * 效仿Linux的格式打印万年历
 * @author Nular
 */
public class PrintCalendar {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入月份和年份");
		int month = sc.nextInt();
		int year = sc.nextInt();
//		int month = 4;
//		int year = 2020;
		showCal(year, month);
		sc.close();
	}

	/**
	 * 显示某年某月的日历
	 * @param year 显示内容对应年份
	 * @param month 显示内容对应月份
	 */
	private static void showCal(int year, int month) {
		// Calendar 是抽象类，GregorianCalendar是它的一个实现类
		Calendar cal = new GregorianCalendar();
		// 设置到月份的1号，谨防date溢出
		cal.set(year, month-1, 1);
		// dayOfWeek初始值为1号所在的位置
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		int days = cal.getActualMaximum(Calendar.DATE);
		System.out.println("    " + parseMonth(cal.get(Calendar.MONTH))+" "+cal.get(Calendar.YEAR));
		System.out.println("Su Mo Tu We Th Fr Sa");
		// 负责控制换行和输出的变量j
		int j = 1;
		for (int i = 1; i <= days; i++,j++) {
			if(j <= dayOfWeek - 1) {
				i--;
				// 输出两个空格占位
				System.out.print("  ");
			}
			else if(i >= 10){
				// 两格以上则直接输出
				System.out.print(i);
			}
			else if(i < 10) {
				// 1格则补充一个空格
				System.out.print(" " + i);
			}
			// 无论是补齐还是输出，都在其后面补充一个空格
			System.out.print(" ");
			// 7天换行一次
			if(j % 7 == 0 && j != 0) {
				System.out.println();
			}
		}
	}
	
	// 日期表 0对应一月，11对应十二月。
	private static final String[] MONTHE_STRINGS = {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE",
			"JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"}; 
	/**
	 * 将传入的month解析为英文的日期单词
	 * @param month
	 * 		月份数
	 * @return
	 * 		字符串类型的月份对应单词
	 */
	private static String parseMonth(int month) {
		if(month < 12)
			return MONTHE_STRINGS[month];
		return null;
	}
	
}
