package day23File;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RAFCopy {
	public static void main(String[] args) throws IOException {
		File f = new File("src/day23File/haha.txt");
		copy(f);
	}
	
	private static void copy(File f) {
		// try-with-resources jdk1.7 新特性，顾名思义，可以自动关闭，省去finally中的try分支，使得代码更简洁。
		// 本特性仅支持实现了java.lang.AutoCloseable接口的类。
		try(RandomAccessFile src = new RandomAccessFile(f, "r");
			RandomAccessFile dst = new RandomAccessFile(createFileName(f), "rw")){
			for(int i = src.read(); i != -1; i = src.read())
				dst.write(i);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static File createFileName(File f) {
		String path = f.getPath().substring(0, f.getPath().length() - f.getName().length());
		String filename = "copied-" + f.getName();
		return new File(path + filename);
	}
}
