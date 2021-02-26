package day16Collection2020_3_9;

import java.util.Deque;
import java.util.LinkedList;

public class TestQueueStack {
	public static void main(String[] args) {
		Deque<Integer> q = new LinkedList<Integer>();
		System.out.println("Queue的入队出队: ");
		for(int i = 0 ; i < 10 ; i++) {
			q.offer(i);	// 入队尾，队尾为表尾
			System.out.println(q);
		}
		for(int i = 0 ; i < 10 ; i++) {
			System.out.println(q);
			q.poll();	// 从表头出队
		}
		System.out.println("\nStack的进栈出栈: ");
		for(int i = 0 ; i < 10 ; i++) {
			q.push(i);	// 入栈顶，栈顶为表头
			System.out.println(q);
		}
		for(int i = 0 ; i < 10 ; i++) {
			System.out.println(q);
			q.pop();	// 从表头出栈
		}
		
	}
}
