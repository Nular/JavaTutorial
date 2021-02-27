package day11String;

/**
 * 测试String和StringBuilder 添加新字符速度    <br/>
 * 结论:    <br/>
 * append()方法(即在尾部插入)最快 ;   <br/>
 * append()方法(即在尾部插入)之后逆置其次;   <br/>
 * inster()方法在中间插入次之;   <br/>
 * inster()方法在头部插入再次;   <br/>
 * String +号拼接的方式最慢。   <br/>
 * @author Nular
 */
public class StringBuilderTest {
	public static void main(String[] args) {
		testAppendTime();
	}

	/**
	 * 测试String和StringBuilder 添加新字符速度
	 */
	private static void testAppendTime() {
		StringBuilder sb = new StringBuilder();
		@SuppressWarnings("unused")
		String s = "";
		// 利用 System.currentTimeMillis() 方法测速 毫秒级精确度。
		long sbStart = System.currentTimeMillis();
		for(int i = 0; i < 20000; i++)
			sb.append("ha");
		long sbDone = System.currentTimeMillis();
		System.out.println("20000次Append  " + (sbDone - sbStart) + "ms");
		
		sb = new StringBuilder();
		sbStart = System.currentTimeMillis();
		for (int i = 0; i <= 20000; i++) 
			sb.append("ha");
		sb.reverse();
		sbDone = System.currentTimeMillis();
		System.out.println("20000次append()后逆置  " + (sbDone - sbStart) + "ms");
		
		sb = new StringBuilder();
		sbStart = System.currentTimeMillis();
		for (int i = 0; i <= 20000; i++) 
			sb.insert(0, "ha");
		sbDone = System.currentTimeMillis();
		System.out.println("20000次头部insert  " + (sbDone - sbStart) + "ms");
		
		sb = new StringBuilder();
		sbStart = System.currentTimeMillis();
		for (int i = 0; i <= 20000; i++) 
			sb.insert(i/2, "ha");
		sbDone = System.currentTimeMillis();
		System.out.println("20000次中间insert  " + (sbDone - sbStart) + "ms");
		
		long sStart = System.currentTimeMillis();
		for(int i = 0; i < 20000; i++)
			s+="ha";
		long sDone = System.currentTimeMillis();
		System.out.println("20000次+=  " + (sDone - sStart) + "ms");
	}
	
}
