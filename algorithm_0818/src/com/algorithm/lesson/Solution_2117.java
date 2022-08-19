package com.algorithm.lesson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * 문제 : swea 2117 [모의 SW 역량테스트] 홈 방범 서비스
 * 참고 url : https://goodteacher.tistory.com/134
 * */
//1. 맨해튼 거리에 들어오는지 
public class Solution_2117 {
	private static int[][] city;
	private static int N;//도시의 크기
	private static boolean[][] visited;//방문여부 확인
	private static int[][] direction = {{-1, 0}, {1,0}, {0,-1}, {0,1}};//상하좌우
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tokens.nextToken());
			int M = Integer.parseInt(tokens.nextToken());//하나의 집에서 지불할 수 있는 비용
			
			city = new int[N][N];//도시 정보
			visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				tokens = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					city[i][j] = Integer.parseInt(tokens.nextToken());
				}
			}
			
			
			
		}//end of test case
		
	}//end of main
	
	
	//탐색은 중심에서 시작?? 깊이만큼??
	//현재 좌표를 중심 좌표(시작 좌표)로 한다.
	private static void calcMaxHomeCount(int row, int col) {
		
		int K = 1;
		int cost = K * K + (K - 1) * (K - 1);//운영 비용
		
		//보안회사의 이익 = 서비스 제공받는 집들을 통해 얻는 수익- 운영 비용
		
		
		visited[row][col] = true;
		
		//모든 방향에 대해 탐색
		for(int i = 0; i < direction.length; i++) {
			int nextX = row + direction[i][0];
			int nextY = col + direction[i][1];
			if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
			if(!visited[nextX][nextY]) 
				calcMaxHomeCount(nextY, nextX);
		}
		
	}
	
	

}
