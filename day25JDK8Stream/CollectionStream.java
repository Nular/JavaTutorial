package day25JDK8Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 测试集合流
 * @author Nular
 */
public class CollectionStream {
	public static void main(String[] args) {
		Collection<String> c1 = new ArrayList<>();
		Collection<String> c2 = new ArrayList<>();
		Stream<String> s = Stream.iterate(random(), str -> random()).limit(10);
		
		addAll(c2, s);
		addAll(c1, c2);
//		Stream.of(c1).collect(Collectors.toCollection(LinkedList::new));
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(s);
		
		flatMapTest();
	}
	
	/**
	 * 测试 流的 <tt>flatMap()</tt>函数 <br/>
	 * 遍历流内元素，将其转换为指定类型后进行一次合并。<br/>
	 * 与map不同的是，flatMap 多了次"合并"的操作，即，先进行和map一样的"映射"，
	 * 把每个元素改变为要求类型，最后再进行一次合并，再返回给流。<br/>
	 * 注: flatMap中传入方法必须为一个返回值是Stream的方法。<br/>
	 */
	public static void flatMapTest() {
		Integer[] ary1 = {1,2,3,4,5};
		Integer[] ary2 = {1,2,3,4,5};
		Integer[] ary3 = {1,2,3,4,5};
		Integer[] ary4 = {1,2,3,4,5};
		
		Integer[][] arys = {ary1, ary2, ary3, ary4};
		
		ArrayList<Integer> a = Stream.of(arys)
			.flatMap((ary) -> Stream.of(ary))
			.collect(Collectors.toCollection(ArrayList::new));
		
		Stream.of(arys)
			.flatMap((ary) -> new LinkedList<Integer>(Arrays.asList(ary)).stream());
		
		
		Integer[] ary = a.toArray(new Integer[a.size()]);
		
		System.out.println(Arrays.toString(ary));
	}
	
	/**
	 * 利用流的特性，将collection2中的内容全部加入至collection1中
	 * @param <T> 传入集合的类型
	 * @param c1 被添加者
	 * @param c2 添加者
	 */
	public static <T> void addAll(Collection<T> c1, Collection<T> c2) {
		c2.stream().forEach(ele -> c1.add(ele));
	}
	
	/**
	 * 利用流的特性，将Stream中的内容全部加入至Collection中
	 * @param <T> 传入集合的类型
	 * @param c 被添加者
	 * @param s 添加者
	 */
	public static <T> void addAll(Collection<T> c, Stream<T> s) {
		s.forEach(ele -> c.add(ele));
	}
	
	/**
	 * @return 返回String类型随机数
	 */
	public static String random() {
		return String.valueOf( (int)(Math.random()*100) );
	}
}
