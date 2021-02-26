package day23File;

import java.io.File;
import java.io.IOException;

public class TestFileAndPath {
	public static void main(String[] args) throws IOException {
		File file = new File("src/day23File/test");
		// 目录一次只能建立一层，文件必须在目录存在的前提下建立【怎么这么麻烦啊喂】
		createFile(file);
		System.out.println(file.getName());
		System.out.println(file.getAbsolutePath());
	}

	private static void createFile(File file) {
		if(file == null) {
			;
		}else if(!file.exists()) {
			file.mkdir();
		}else if(file.isDirectory()) {
			
		}else if(file.isFile()) {
			
		}
	}
}
