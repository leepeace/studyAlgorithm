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

		sc.close();
	}//end of main
	
	
	
	/**
	 * @param start 현재 뽑을려는 숫자
	 * @param cnt 뽑은 개수
	 */
	private static void backtracking(int start, int cnt) {

		if(cnt == M) {//M개의 수를 전부 뽑은 경우
			/*for (int i = 1; i <= N; i++) {
				if(visited[i])
					System.out.print(i + " ");
			}*/
			for (int i = 0; i < M; i++) {
				System.out.print(num[i] + " ");
			}
			System.out.println();
			return;
		}

		//star부터 시작하면 중복 호출을 막을 수 있다.
		for(int i = start; i <= N; i++) {
			//visited[i] = true;
			num[cnt] = i;
			backtracking(i+1,cnt+1);	
			
			//visited[i] = false;
		}	
		return;
	}
	
	
}
