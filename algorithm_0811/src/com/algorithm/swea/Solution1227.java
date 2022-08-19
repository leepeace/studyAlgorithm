package com.algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * dfs로 풀어보기
 * 
 * */
public class Solution1227 {
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};//상하좌우
	static int[][] arr;
	static int startX, startY;
	static int endX, endY;
	static int result;
	
	public static void main(String[] args) throws IOException {
		int T = 10;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			
			int tc = Integer.parseInt(tokens.nextToken());
			
			// 1은 벽을 나타내며 0은 길, 2는 출발점, 3은 도착점
			arr = new int[100][100];
			
			for(int i = 0; i < arr.length; i++) {
				
				for(int j = 0; j < arr[i].length; j++) {
					arr[i][j] = Integer.parseInt(tokens.nextToken());
					if(arr[i][j] == 2) {
						startX = i;
						startY = j;
					}else if(arr[i][j] == 3) {
						endX = i;
						endY = j;
					}
				}
			}
			
			
			
			System.out.println("#" + tc + " " + result);
		}
	}
	

	
	private static void search() {
		int nextX = 0, nextY = 0;
		int i = 0;
		while(true) {
			nextX = startX + dir[i][0];
			nextY = startY + dir[i][1];
			
			//모든 방향에 대해서 길이 막혀있는 경우 종료
			int temp = 0;
			for(int j = 0; j < dir.length; j++) {
				int tempX = startX + dir[j][0];
				int tempY = startY + dir[j][1];
				if(arr[tempX][tempY] == 1) {
					temp++;
				}
			}
			if(temp == 4) {//4방향에 대해 모두 탐색불가
				result = 0;
				break;
			}
			
			//벽을 만나거나 범위를 넘어선 경우 방향을 전환해줌
			if(nextX < 0 || nextY < 0 || nextX > 100 || nextY > 100 || arr[nextX][nextY] == 1) {
				i = (i + 1) % 4;
			}
			
			//도착지에 도달한 경우
			if(arr[nextX][nextY] == 3) {
				result = 1;
				break;
			}
			//현재 위치를 다음 이동 위치로 바꾸어줌
			startX = nextX;
			startY = nextY;
			
		}
	}
	
}
