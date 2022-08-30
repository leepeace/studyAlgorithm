package com.algorithm.example;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueTest {
	static class Pair implements Comparable<Pair>{
		int x;
		int y;
		
		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pair o) {
			return this.x - o.x;
		}
		
		
	}
	public static void main(String[] args) {
		//최소 힙
		PriorityQueue<Pair> queue = new PriorityQueue<Pair>();
		
		queue.add(new Pair(2, 1));
		queue.add(new Pair(3, 9));
		queue.add(new Pair(21, 111));
		queue.add(new Pair(12, 21));
		
		while(!queue.isEmpty()) {
			Pair now = queue.poll();
			System.out.println(now.x + ", " + now.y);
		}
		
		//최대 힙
		PriorityQueue<Integer> queue2 = new PriorityQueue<Integer>(Collections.reverseOrder());
		queue2.add(2);
		queue2.add(132);
		queue2.add(21);
		queue2.add(62);
		queue2.add(12);
		
		System.out.println("---------------------------");
		while(!queue2.isEmpty()) {
			System.out.println(queue2.poll());
		}
		
	}
}
