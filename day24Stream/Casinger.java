package day24Stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Casinger {
	public static void casing(File file) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		String filePath = file.getPath();
		String trueName = file.getName().split("\\.\\d+")[0];
		String outPath = filePath.substring(0, filePath.length() - file.getName().length());
		File path = new File(outPath);
		byte[] buffer = new byte[Slicer.SLICE_LENGTH];
		try {
			fos = new FileOutputStream(outPath + "merged-" + trueName, true);
			File[] files = path.listFiles();
			for(int i = 1;i < files.length; i++)
				for(File f : files) {
					if(f.isFile() && f.getName().equals(trueName + "." + i)) {
						fis = new FileInputStream(f);
						fis.read(buffer);
						fos.write(buffer);
					}
				}
					
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		casing(new File(Slicer.PATH));
	}
}
