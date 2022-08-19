package com.algorithm.boj;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 문제 : 백준 15649 N과 M
 * 접근 유형 : 백트래킹
 * */
public class Main_15649 {

	private static boolean[] visited;
	private static int M;
	private static int N;
	private static int[] num;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		visited = new boolean[N+1];
		num = new int[M];
		
		backtracking(0);
		
	}

	private static void backtracking(int cnt) {

		
		//뽑아야 할 숫자를 전부 뽑은 경우
		if(cnt == M) {
			for (int i = 0; i < num.length; i++) {
				System.out.print(num[i] + " ");
			}
			System.out.println();
			return;	
		}
		
		for(int i = 1; i <= N; i++) {
			if(visited[i]) {//이미 방문한 경우 뽑지않음
				continue;
			}
			
			//방문 체크 및 결과값 셋팅
			visited[i] = true;
			num[cnt] = i;
			
			//다음 수를 뽑으러 감
			backtracking(cnt+1);	
			
			//원래 값 회복
			visited[i] = false;
		}
	}
	
	
}
