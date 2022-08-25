package com.algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문제 : 백준 10971 외판원 순회 2
 * 외판원의 순회에 필요한 최소 비용
 * */
public class Main_10971 {
	private static int N;
	private static boolean[] visited;
	private static int[][] weight;
	private static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		weight = new int[N][N];
		visited = new boolean[N];
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				weight[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			calcMinCost(i, i,0, 0);
		}
		
		System.out.println(result);
	}
	
	
	//dfs + backtracking
	private static void calcMinCost(int start, int head,int cnt, int sum) {
		if(cnt == N && start == head) {
			//결과값 갱신
			result = Math.min(result, sum);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!visited[i] && weight[start][i] != 0) {//정점에 대해 방문했는지 여부와 0이 아닌지를 확인
				visited[i] = true;
				calcMinCost(i, head, cnt+1, sum+weight[start][i]);
				visited[i] = false;
			}
		}
		
	
	}
	
}
