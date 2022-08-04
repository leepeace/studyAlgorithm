package com.algorithm.boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 문제 : 2164, 카드2
 * 조건 : 제일 위에 있는 카드는 버리고, 그 다음은 카드는 제일 아래로 옮김
 * 문제 유형 : 큐
 * */
public class Main_2164_이해민 {
	
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//카드의 수
		
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		boolean first = false, second = false;
		
		//큐에 카드가 하나 남을때까지 반복
		while(queue.size() != 1) {
			int tempFirst = queue.poll();
			int tempSecond = queue.poll();
			queue.add(tempSecond);
		}
		
		System.out.println(queue.peek());
		
		sc.close();
	}
	
}
