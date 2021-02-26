package day24Stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestFileInputStream {
	public static void main(String[] args) {
		String pathname = "";
		File file = new File(pathname);
		
		try(FileInputStream fis = new FileInputStream(file)){
			fis.read();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
