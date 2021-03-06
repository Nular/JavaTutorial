package day11String;

/**
 * 测试字符串常量池(在什么情况下会创建新的对象) <br/>
 * 结论: 利用 "+" 运算符拼接字符串时 会生成新的对象，
 * 尽管equals()方法结果为真，但是在堆内存里存在两个不同的对象，因此引用变量的值并不相同。
 * 因此，大量拼接字符串时，应利用StringBuilder类 <br/>
 * @see StringBuilderTest 测试StringBuilder和String拼接的插入速度 <br/>
 * @author Nular
 */
public class StringConsist {
	// 静态常量
	public static final String STR = "123";
	// 主函数
	public static void main(String[] args){
		// 整体
		String s9 = "123abc";
		// 常量 + 常量
		String s10 = STR + "abc";
		System.out.println("常量 + 常量 与 整体常量的比较:"+ (s9==s10)); // 第一处 常量 + 常量  依然是 整体常量
		// 变量
		String  temp = "abc";
		String temp2 = new String("abc");
		// 常量 +  变量
		String s12 = "123" + temp;
		System.out.println("变量 + 常量 与 整体常量的比较:"+ (s12==s9)); //第二处 变量 + 常量 会创建新的对象, 即使变量和常量指向同一个对象
		
		System.out.println();
		System.out.println(temp == "abc");
		System.out.println(temp2 == "abc");
		System.out.println(STR == "123");
	}
}
