package day14Date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 将日期移动至下个周五
 * @author Nular
 */
public class MoveToNextFri {

	public static void main(String[] args) {
		// 创建 Calendar 对象
		Calendar cal = Calendar.getInstance();
		// Calendar 默认以周日为第一天，即，周日对应1 周六对应7 周五对应6，以此类推
		int now=cal.get(Calendar.DAY_OF_WEEK);
		System.out.println("今天是周" + (now - 1));
		// 由于日期自动处理溢出部分(lenient模式)，所以可以直接将日期加上到周五时候的日期数
		cal.add(Calendar.DATE, 7+(6-now));
		// 设置时间为14:00:00
		cal.set(Calendar.HOUR_OF_DAY, 14);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date date = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("调整后时间: "+sdf.format(date));
	}

}