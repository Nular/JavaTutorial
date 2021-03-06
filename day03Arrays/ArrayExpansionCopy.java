package day03Arrays;

import java.util.Arrays;

/**
 * 数组的扩容和复制 <br/>
 * 数组内存空间是定死的，因此没法真正的扩容，因此使用复制的方式进行"扩容"，也就是，创建一个新的数组。
 * @author Nular
 */
public class ArrayExpansionCopy {
	
	public static void main(String[] args) {
		int[] ary = {1,2,3,4,5};
		
		ary = arrayExpansion1(ary, 10);	
		System.out.println(ary.length);
		System.out.println(Arrays.toString(ary));
		
		ary = arrayExpansion2(ary, 5);
		System.out.println(ary.length);
		System.out.println(Arrays.toString(ary));
		
		ary = arrayAdd(ary, new int[] {6,7,8,9,10});
		System.out.println(ary.length);
		System.out.println(Arrays.toString(ary));
	}
	
	/**
	 * 使用Arrays工具类中的copyOf方法进行扩容。
	 * @param ary 传入数组
	 * @param length 扩容后长度。
	 * @return
	 */
	public static int[] arrayExpansion1(int[] ary, int length) {
		return Arrays.copyOf(ary, length);
	}
	
	/**
	 * 使用常规方式扩容数组
	 * @param ary 传入数组
	 * @param length 扩容后长度。
	 * @return
	 */
	public static int[] arrayExpansion2(int[] ary, int length) {
		int[] a = new int[length];
		for(int i = 0 ; i < length ; i++) 
			a[i] = ary[i];
		return a;
	}
	
	/**
	 * 将ary2添加至ary1的尾部
	 * @param ary1
	 * @param ary2
	 * @return
	 */
	public static int[] arrayAdd(int[] ary1, int[] ary2) {
		ary1 = Arrays.copyOf(ary1, ary1.length + ary2.length);
		System.arraycopy(ary2, 0, ary1, ary1.length - ary2.length, ary2.length);
		return ary1;
	}
	
	/**
	 * 无关紧要的测试下泛型: 泛型不能直接声明数组，因为有个泛型擦除的特性.
	 * @param <T>
	 * @param a
	 * @return
	 */
	public static <T> T test(T a) {
		return a;
	}
}
