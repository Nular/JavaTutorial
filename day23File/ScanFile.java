package day23File;

import java.io.File;
import java.io.FileFilter;
import java.util.LinkedList;
import java.util.List;

public class ScanFile {
	private static List<File> files = new LinkedList<File>() {
		private static final long serialVersionUID = 1L;
		// 重写了toString 打印起来更好看了。
		@Override
		public String toString() {
			StringBuilder s = new StringBuilder();
			for(File f : this) {
				s.append(f.getPath());
				s.append("\n");
			}
			return s.toString();
		}
	};
	
	public static void main(String[] args) {
		File f = new File("src");
		scan(f);
		System.out.println(files);
	}
	
	// 2021-2-20 复习时候写的， 优美的递归！！
	private static void scan(File file) {
		// 判空出口
		if(file == null || !file.exists())
			return;
		// 目录则继续递归
		else if(file.isDirectory()) {
			for(File f : file.listFiles())
				scan(f);
		// 判断文件的条件，如果满足条件则归入files链表
		}else if(file.isFile() && file.length() >= 300){
			files.add(file);
		}
	}
	
	// 上课的时候写的，使用了 FileFilter进行过滤
	@SuppressWarnings("unused")
	private static void findFiles(File dir) {
		File[] tempFiles = dir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File sub) {
				// 如果是目录则保留不动
				if(sub.isDirectory())
					return true;
				return sub.length() >= (300 * 1 << 20);	// sub要大于300MB，1 << 20为1MB的精确值
			}
		});
		// 倘若是满足需求的文件，则加入LinkedList中，否则递归继续扫描
		if(tempFiles == null)
			return;
		for(File file : tempFiles) {
			if(file.isDirectory()) {
				findFiles(file);
			}
			else {
				files.add(file);
			}
		}
	}
}