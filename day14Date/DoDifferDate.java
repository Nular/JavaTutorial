package day14Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 本写法利用毫秒值相减的方式计算日期差值(天数)。
 * @see DoDifferDate#doDifferDate(Date, Date)
 * @author Nular
 */
public class DoDifferDate {
	public static void main(String[] args) throws ParseException {
		Date date1, date2;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Scanner sc = new Scanner(System.in);
		// 利用SimpleDateFormat解析输入日期
		date1 = sdf.parse(sc.next());
		date2 = sdf.parse(sc.next());
		
		System.out.println(doDifferDate(date1, date2));
		sc.close();
	}
	/**
	 * 利用毫秒值相减的方式，计算出差值
	 * 返回date1 和date2 相差的日期
	 * @param date1 传入日期1
	 * @param date2 传入日期2
	 * @return date2 - date1
	 */
	public static int doDifferDate(Date date1, Date date2) {
		long differMilli = date2.getTime() - date1.getTime();
		return (int)(differMilli / 1000 / 3600 / 24);
	}
}
