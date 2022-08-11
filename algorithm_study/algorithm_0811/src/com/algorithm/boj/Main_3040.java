package com.algorithm.boj;

import java.util.Scanner;

/*
 * 일곱난쟁이들의 모자 합은 100이 되어야함
 * 접근 유형 : 브루트포스 알고리즘
 * */
public class Main_3040 {
	
	private static int[] hat;
	private static int size;
	private static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		size = 9;
		hat = new int[size];
		
		for(int i = 0; i < size; i++) {
			hat[i] = sc.nextInt();
		}
		
		visited = new boolean[size];
		
		for(int i = 0; i < size; i++) {
			search(0, i, 0);
		}
		
		
		sc.close();
	}

	public static void search(int count, int start, int sum) {
		if(count == 7 && sum == 100) {
			for(int i = 0; i < size; i++) {
				if(visited[i])
					System.out.println(hat[i]);	
			}
			return;
		}
		if(count == 7) return;
		
		//모든 경우에 대해 탐색하기 위해
		for(int i = start; i < size; i++) {
			if(!visited[i])
				visited[i] = true;
			search(count+1, i+1, sum+hat[i]);
			visited[i] = false;
		}
		return;
	}
	
}
