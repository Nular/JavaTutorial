package day24IOStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 用于将文件拆分成 {@value SLICE_LENGTH} Byte 大小的块。
 * @author Nular
 */
public class Slicer {
	public static final int SLICE_LENGTH = 16;
	public static final String PATH = "src/day23File/haha/haha.txt";
	public static void slice(File file) {
		if(file == null || !file.exists())
			return;
		byte[] buffer = new byte[SLICE_LENGTH]; 
		FileOutputStream fos = null;
		try(FileInputStream fis = new FileInputStream(file);){
			// 读了之后写进新文件，后缀添加数字
			for(int length = fis.read(buffer), i = 1; length != -1; length = fis.read(buffer), i++) {
				fos = new FileOutputStream(new File(file.getPath() +"." + i));
				fos.write(buffer);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		File file = new File(PATH);
		slice(file);
	}
}
