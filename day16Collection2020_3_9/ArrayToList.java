package day16Collection2020_3_9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 测试列表和数组之间的互相转换。
 * @author Nular
 */
public class ArrayToList {
	public static void main(String[] args) {
		// 数组 To 集合
		Integer[] a = {1,2,3,4,5,6};
		// 方法1， Arrays.asList(数组) ， 返回其对应的列表
		List<Integer> l1 = new ArrayList<Integer>(Arrays.asList(a));
		// 方法2 Collection.addAll(列表，数组) 静态方法，将a中的内容全部添加到l中。
		List<Integer> l2 = new ArrayList<Integer>(a.length);
		Collections.addAll(l2, a);
		
		System.out.println(l1);
		System.out.println(l2);
		
		// 集合 To 数组
		Integer[] b = new Integer[l2.size()];
		// 对象的方法toArray(数组) 将this中的数据存放至传入数组中。
		l2.toArray(b);
		System.out.println(Arrays.toString(b));
	}
}
