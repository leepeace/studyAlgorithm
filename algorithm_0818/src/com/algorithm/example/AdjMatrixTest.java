package com.algorithm.example;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class AdjMatrixTest {
	static int[][] adjMatrix;
	static int N;
	private static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int E = sc.nextInt();
		
		adjMatrix = new int[N][N];//0으로 초가화
		
		//간선정보에 해당하는 부분만 덮어옴
		for(int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjMatrix[to][from] = adjMatrix[from][to] = 1;//무향 그래프
		}
		visited = new boolean[N];//방문관리 배열

		
		//bfs();
		
		dfs(0);
		
	}
	
	private static void dfs(int cur) {

		visited[cur] = true;
		System.out.print((char)(cur + 'A'));

		//현재 정점의 인접정점들 큐에 넣어서 차후 탐색하도록 만들기
		for(int i = 0; i < N; i++) {
			//방문하지 않았으면 인접한 경우
			if(!visited[i] && adjMatrix[cur][i] != 0) {
				dfs(i);
			}
		}
	}
	
	private static void bfs(){
		//0번 정점을 시작점으로
		Queue<Integer> queue = new ArrayDeque();		
		
		visited[0] = true;
		queue.offer(0);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			System.out.print((char)(cur + 'A'));
			
			//현재 정점의 인접정점들 큐에 넣어서 차후 탐색하도록 만들기
			for(int i = 0; i < N; i++) {
				//방문하지 않았으면 인접한 경우
				if(!visited[i] && adjMatrix[cur][i] != 0) {
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
		System.out.println();
	}
	
}
