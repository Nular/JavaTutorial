package day16Collection2020_3_9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayToList {
	public static void main(String[] args) {
		// 数组 To 集合
		Integer[] a = {1,2,3,4,5,6};
		// 方法1， Arrays.asList(数组) ， 返回其对应的列表
//		List<Integer> l = new ArrayList<Integer>(Arrays.asList(a));
		List<Integer> l = new ArrayList<Integer>();
		// 方法2 Collection.addAll(列表，数组) 静态方法，将a中的东西全部添加到l中
		Collections.addAll(l, a);
		System.out.println(l);
		// 集合 To 数组
		Integer[] b = new Integer[l.size()];
		// 对象的方法toArray(数组) 将this中的数据存放至传入数组中。
		l.toArray(b);
		for(int temp : b)
			System.out.println(temp);
		l.remove(1);
		System.out.println("l移除下标1后: " + l);
		l.remove((Integer)1);
		System.out.println("l移除元素1后: " + l);
	}
}
