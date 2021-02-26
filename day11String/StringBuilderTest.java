package day11String;

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
		
		long start = System.currentTimeMillis();
		for(int i = 0; i < 10000; i++)
			sb.append("ha");
		long sbDone = System.currentTimeMillis();
		for(int i = 0; i < 10000; i++)
			s+="ha";
		long sDone = System.currentTimeMillis();

		System.out.println("10000次Append  " + (sbDone - start));
		System.out.println("10000次+=  " + (sDone - sbDone));
	}
	
}
