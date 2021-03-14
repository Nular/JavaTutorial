package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.List;

import day24IOStream.Student;

public class TestLoad {
	public static final File FILE = new File("src/day24Stream/student.obj");
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		List<Student> list = new LinkedList<Student>();
		list = (List<Student>) load(FILE);
		System.out.println(list);
	}
	
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
