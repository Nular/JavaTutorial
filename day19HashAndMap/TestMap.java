package day19HashAndMap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
@SuppressWarnings("unused")
public class TestMap {

	public static void main(String[] args) {
//		testHashMap();
//		testLinkedHashMap();
//		testSortedHashMap();
	}
	
	private static void testHashMap(){
		Map<String, Integer> wordCount = new HashMap<String, Integer>();
		Scanner sc = new Scanner(System.in);
		String sentence = sc.nextLine();
		String[] words = sentence.split(" ");
		for(String word : words) {
			if(wordCount.containsKey(word))
				wordCount.put(word, wordCount.get(word) + 1);
			else
				wordCount.put(word, 1);
		}
		System.out.println(wordCount);
		sc.close();
	}
	
	private static void testLinkedHashMap() {
		Map<String, Integer> wordCount = new LinkedHashMap<String, Integer>();
		Scanner sc = new Scanner(System.in);
		String sentence = sc.nextLine();
		String[] words = sentence.split(" ");
		for(String word : words) {
			if(wordCount.containsKey(word))
				wordCount.put(word, wordCount.get(word) + 1);
			else
				wordCount.put(word, 1);
		}
		
		System.out.println(wordCount);
		sc.close();
	}
	
	private static void testSortedHashMap() {
		Map<String, Integer> wordCount = new HashMap<String, Integer>();
		Scanner sc = new Scanner(System.in);
		String sentence = sc.nextLine();
		String[] words = sentence.split(" ");
		for(String word : words) {
			if(wordCount.containsKey(word))
				wordCount.put(word, wordCount.get(word) + 1);
			else
				wordCount.put(word, 1);
		}
		
		List<Entry<String, Integer>> wordEntrys = 
				new LinkedList<Entry<String,Integer>>(wordCount.entrySet());
//		// 重写比较器，进行比较排序 
		// 以字符串为排序依据 升序排序
//		wordEntrys.sort(new Comparator<Entry<String,Integer>>() {
//			@Override
//			public int compare(Entry<String, Integer> entry1, Entry<String, Integer> entry2) {
//				return entry1.getKey().compareTo(entry2.getKey());
//			}
//		});
		// 重写比较器，进行比较排序 
		// 以出现次数为排序依据 升序排序
		wordEntrys.sort(new Comparator<Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> entry1, Entry<String, Integer> entry2) {
				return entry1.getValue() - entry2.getValue();
			}
		});
		System.out.println(wordEntrys);
		sc.close();
		
	}
}





