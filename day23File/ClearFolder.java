package day23File;

import java.io.File;

public class ClearFolder {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		String path = "src/day23File/test/";
		File file = new File(path);
		clearFolder(file);
	}

	private static void clearFolder(File file) {
		// 前两句判空，直接返回。
		if(file == null)
			return;
		else if(!file.exists())
			return;
		// 遍历文件内所有内容，并进入递归工作栈后删除空文件夹
		else if(file.isDirectory()) {
			File[] contents = file.listFiles();
			for(File f : contents) {
				clearFolder(f);
				System.out.println("进入" + f.getPath());
			}
			System.out.println("删除 " + file.getName() + " is " + file.delete());
		}
		// 最后一种情况，理当是为文件，直接删除
		else/* if(file.isFile()) */{
			file.delete();
		}
	}
}
