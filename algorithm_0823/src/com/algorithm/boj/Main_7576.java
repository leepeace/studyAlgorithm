package com.algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 문제 : 백준 7576 토마토
 * 출력 : 토마토가 모두 익을 때까지의 최소 날짜
 * 접근유형 : BFS
 * */
public class Main_7576 {
	
	private static int[][] direction = {{-1,0}, {1,0}, {0,-1}, {0,1}};//상하좌우
	private static boolean[][] visited;
	private static int[][] tomato;
	private static int M;
	private static int N;
	private static Queue<int[]> queue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());//열
		M = Integer.parseInt(st.nextToken());//행 

		tomato = new int[M][N];
 		visited = new boolean[M][N];
		queue = new LinkedList<>();
 		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if(tomato[i][j] == 1) {
					queue.add(new int[] {i, j});
					visited[i][j] = true;
				}
			}
		}

		searchMinDate();
		
		int answer = maxDepth();

		System.out.println(answer);
	}//end of main
	
	private static int maxDepth() {
		int max = Integer.MIN_VALUE;
		
		//가장 큰 깊이를 구함
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(tomato[i][j] == 0) {
					return -1;
				}
				max = Math.max(max, tomato[i][j]);
			}
		}
		
		return max-1;
	}

	//정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸	
	//토마토가 모두 익을 때까지의 최소 날짜를 구함->깊이를 구해야함
	//BFS를 통해 탐색함
	private static void searchMinDate() {
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int nowX = temp[0];//x좌표
			int nowY = temp[1];//y좌표
			
			int nextX = 0, nextY = 0;
			for(int i = 0; i < direction.length; i++) {//4방향 탐색
				nextX = nowX + direction[i][0];
				nextY = nowY + direction[i][1];
				if(nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) continue;
				
				if(tomato[nextX][nextY] == -1) continue;
				
				if(!visited[nextX][nextY]) {
					visited[nextX][nextY] = true;
					tomato[nextX][nextY] = tomato[nowX][nowY] + 1;
					queue.offer(new int[] {nextX, nextY});
				}
			}
		}
	}//end of method
	
}
