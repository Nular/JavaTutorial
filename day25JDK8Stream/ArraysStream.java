package day25JDK8Stream;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 测试数组流
 * @author Nular
 */
public class ArraysStream {
	public static void main(String[] args) {
		
		// 在使用Stream时候，请使用包装类型，否则自动装箱拆箱时候会出现问题，
		// 如下述定义在直接使用Stream.of()时，forEach则会直接输出一个堆内存地址
		int[] ary1 = {5,4,3,2,1,};
		Arrays.stream(ary1).forEach(System.out::println);
		Stream.of(ary1).forEach(System.out::println);
		// 正确方式:使用包装类，如Integer来声明数组类型
		Integer[] ary = {5,4,3,2,1,};
		Stream.of(ary).forEach(System.out::println);
		
		final int a = 0;
		// 封闭范围内的a必须为final，亦或者不改变其值。
		Stream<Integer> ss = Stream.generate(() -> a).limit(10);
		ss.forEach(System.out::println);
	}
	
	/**
	 *  Stream 中的 forEach方法， 和JS中的forEach方法类似，对于集合内的每一个元素调用一次 【传入方法】
	 *	传入方法为了方便，已定义成 Consumer<? super T> 类型， 即有一个参数传入的消费者类型
	 *	@see Stream#forEach(java.util.function.Consumer)
	 */
	public static void forEachTest() {
		
		Stream<Integer> s = Stream.of(1,2,3,4,5);
		// forEach 中传递一个全写的lambda表达式
		s.forEach((a) -> System.out.println(a));
		// forEach 中传递一个简写的lambda表达式
		s.forEach(System.out::println);
		
	}
}
