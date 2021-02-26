package day23File;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TestWriteInt {
	public static void main(String[] args) throws IOException {
		File file = new File("src/day23File/haha.txt");
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		// 将游标定位到最后一个位置的后面(不是最后一个字符上) (游标从0开始)
		raf.seek(raf.length());
		// write 直接在游标处写入
		raf.write('\n');
		/* 大端描述下，高地址8位为'A'的二进制(0100 1001) 低地址部分为 'B'的二进制(0100 1010)
		   16706 = 0100 1001 0100 1010					
		   RandomAccessFile 的write写进去的则是写进去了int的低八位 也就是从最低有效位开始数的8位。*/
		raf.write(16706);
		System.out.println(Integer.toBinaryString(16706));
		raf.close();
	}
}
