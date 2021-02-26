package day24Stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

public class SaveAndLoadObj {
	public static final File FILE = new File("src/day24Stream/student.obj");
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// 匿名内部重写了 toString。
		// 十分不推荐下述写法，一旦本匿名类发生任何修改，亦或者是本文件被移除、修改名称，那么都会导致之前输出的文件失效 。
		// 因为序列化时会把类描述信息一同放入文件中，在读取时利用类似反射的机制将其重新创建出来。
//		List<Student> list = new LinkedList<Student>() {
//			private static final long serialVersionUID = 1L;
//			@Override
//			public String toString() {
//				StringBuilder s = new StringBuilder();
//				for(Object o : this) {
//					s.append(o.toString());
//					s.append('\n');
//				}
//				return s.toString();
//			}
//		};

		List<Student> list = new LinkedList<Student>() ;
		for(int i = 1; i < 5 ; i++)
			list.add(new Student("na" + i , i + 18, (int)(Math.random() * 10)));
		save(list, FILE);
		list = (List<Student>) load(FILE);
		System.out.println(list);
	}
	
	/**
	 * 将 o 存储至 file中
	 * @param o 传入的任意可序列化对象
	 * @param file 目录可用的一个文件。
	 */
	public static void save(Object o, File file) {
		// 创建文件输出的节点流，套接上对象输出处理流，这样就可以经由OOS处理，底层由FOS输出一个对象了。
		try(FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 从file中读取
	 * @param file
	 * @return
	 */
	public static Object load(File file) {
		Object o = null;
		try(FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);){
			o = ois.readObject();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return o;
	}
}
