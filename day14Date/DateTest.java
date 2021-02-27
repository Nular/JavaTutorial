package day14Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Date 类型更像是POJO，不处理逻辑，仅负责存储时间，大部分方法都已经不推荐使用。
 * 关于日期的处理 参考Calendar
 * @see Calendar
 * @author Nular
 *
 */
public class DateTest {
	public static void main(String[] args) {
		Date date = new Date();
		date.setTime(System.currentTimeMillis());
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		try {
			date = sdf.parse("2020-12-25 0:0:0");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(sdf.format(date));
		date.getTime();
	}
}
