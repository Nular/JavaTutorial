package day16Collection2020_3_9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Collection相关测试。
 * @author Nular
 */
public class TestCollection {
	/**
	 * 供测试使用的静态内部类。
	 * @author Nular
	 */
	static class Temp{
		private int value;
		public Temp() {
			value = 0;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		testVar();
		testRemove();
	}
	
	/**
	 * Integer和int敏感的remove方法。
	 * int类型指代下标
	 * Integer类型指代内容物(倘若集合是Integer类型)
	 */
	public static void testRemove() {
		Collection<Integer> l = new LinkedList<Integer>();
		for(int i = 0; i < 10; i++) {
			l.add(i);
		}
		// 对列表元素的删除
		l.remove(1);	// 删除下标1位置的元素
		System.out.println("l移除下标1后: " + l);
		l.remove((Integer)1);	// 删除内容为1的
		System.out.println("l移除元素1后: " + l);
		
	}

	/**
	 * list存放内容的测试。
	 * 结论: 存放的是 "指针" 也就是Java中的 "引用变量" 在堆内并不会复制一份额外的内容。 
	 */
	public static void testVar() {
		ArrayList<Temp> ss = new ArrayList<Temp>();
		Temp s1 = new Temp();
		ss.add(s1);
		System.out.println("是否为同一个对象的引用变量: " + (ss.get(0) == s1));
	}
	
}
