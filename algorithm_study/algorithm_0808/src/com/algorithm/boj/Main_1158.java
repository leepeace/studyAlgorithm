package com.algorithm.boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 접근 유형 : 큐
 * */
public class Main_1158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();//사람 수
		int K = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<Integer>();
		//1~N번까지의 사람들을 넣음
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		int[] result = new int[N];
		int idx = 0;
		while(!queue.isEmpty()) {
			//k-1번째에 해당하는 데이터를 빼내야함
			for(int i = 1; i <= K-1; i++) {
				queue.add(queue.poll());
			}
			//K번째 해당하는 사람
			int people_K = queue.poll();
			result[idx++] = people_K;
		}
		
		System.out.print("<");
		for(int i = 0; i < N; i++) {
			if(i == N-1) {
				System.out.print(result[i]);
			}else {
				System.out.print(result[i] + ", ");	
			}
		}
		System.out.println(">");
		
		sc.close();
	}

}
