package day16Collection2020_3_9;

import java.util.ArrayList;

public class TestCollection {
	static class Temp{
		private int value;
		
		public Temp() {
			value = 0;
		}
		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Temp> ss = new ArrayList<Temp>();
		Temp s1 = new Temp();
		ss.add(s1);
		System.out.println(ss.get(0) == s1);
		s1.setValue(1);
		System.out.println(ss.get(0).getValue());
	}
}
