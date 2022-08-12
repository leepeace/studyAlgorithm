package com.algorithm.boj;

import java.util.Scanner;

/*
 * 문제 : 백준 15650 N과 M(2)
 * 접근 유형 : 조합, 백트래킹
 */
public class Main_15650 {
	static int N, M;
	static int[] num;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		num = new int[M];
		visited = new boolean[N+1];
		
		backtracking(1, 0);	
		
		
	}
	private static void backtracking(int start, int cnt) {
		
		if(cnt == M) {//M개의 수를 전부 뽑은 경우
			for (int i = 0; i < num.length; i++) {
				System.out.print(num[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(visited[i]) {//이미 방문한 경우 
				continue;
			}
			
			//현재 수를 뽑은 경우
			visited[i] = true;
			num[cnt] = i;
			backtracking(i+1, cnt+1);
			
			//현재 수를 뽑지 않은 경우
			visited[i] = true;
			backtracking(i+1, cnt);
		}	
	}
	
	
}
