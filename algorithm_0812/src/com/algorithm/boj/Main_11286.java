package com.algorithm.boj;

import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/*
 * 문제 : 절댓값 힙
 * 접근 유형 : 우선순위 큐
 * */
public class Main_11286 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//낮은 값이 우선순위
		Queue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) == Math.abs(o2)) {
					return o1 - o2;
				}
				return Math.abs(o1) - Math.abs(o2);
			}
		});
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//연산의 개수
	
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			int x = sc.nextInt();
			if(x == 0) {
				if(queue.isEmpty())	sb.append(0 + "\n");
				else sb.append(queue.poll() + "\n");
			}else {
				queue.add(x);
			}
		}	
		
		//0을 만나면 0의 개수만큼 큐에서 값을 빼야한다.
		//그러나, 큐에 값이 없는 경우 0을 출력한다.
		//절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고(비교 기준 넣어주기)
		
		
		
		System.out.println(sb.toString());
		
	}//end of main
}
