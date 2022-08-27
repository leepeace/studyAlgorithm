package com.algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문제 : 백준 10971 외판원 순회 2
 * 외판원의 순회에 필요한 최소 비용
 * 문제 풀이 소감 : 방문여부를 확인하는 배열을 2차원 배열로 생성했었다. 
 * 그러나, 이 정점에 대해 방문여부를 확인해야 하므로 1차원배열로 할 수 있었다. 
 * 1->2->5->3->4->1 이런식으로 진행 시에 정점에 방문했는지 여부를 확인하기 위해서는 1차원으로 체크해야한다...
 * 각 정점들에 대해 dfs를 수행한다.
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
		
		calcMinCost(0, 0, 0, 0);
		
		
		System.out.println(result);
	}
	
	
	//dfs + backtracking
	private static void calcMinCost(int start, int head, int cnt, int sum) {
		//가지치기 : 진행중인 누적합이 이미 그 전의 최솟값보다 큰 경우 굳이 더 이상 진행할 필요가 없다.
		if(sum > result) return;
		
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
