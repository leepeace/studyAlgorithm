package com.algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문제 : 백준 치킨 배달
 * 접근 유형 : 조합, 
 * 출력 : 도시의 치킨 거리의 최솟값
 * */
public class Main_15686 {
	
	private static int result;//도시의 치킨 거리
	private static int M;
	private static int N;
	private static int[][] city;
	private static int houseX, houseY;
	private static boolean[][] visited;
	private static int[] dx = {-1, 1, 0, 0};//상하좌우
	private static int[] dy = {0, 0, -1, 1};//상하좌우
	private static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tokens.nextToken());//배열 크기
		M = Integer.parseInt(tokens.nextToken());//치킨 집 최대 개수
		
		city = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(city[i][j] == 1) {
					houseX = i; houseY = j;
					search(i, j, Integer.MAX_VALUE);	
				}
			}
		}
		System.out.println(result);
	}
	
	//그전에 방문했던 치킨집과 현재 방문한 치킨집과의 값을 비교해야함...
	private static void search(int row, int col, int min) {
		//방문했거나 배열의 범위를 넘어선 경우
		if(row < 0 || col < 0 || row >= N || col >= N || visited[row][col])
			return;
		
		if(cnt == M) {
			for(int i = 0; i < dx.length; i++) {
				if(!visited[row][col]) {
					visited[row][col] = true;
					//치킨 집을 만난경우
					if(city[row][col] == 2) {
						int temp = Math.abs(houseX - row) + Math.abs(houseY - col);
						if(temp < min) {
							System.out.print("현재 집 좌표 row = " + houseX + ", col = " + houseY);
							System.out.println(" row = " + row + ", " + "col = " + col);
							min = Math.min(temp, min);	
							result += min;
							cnt++;
						}
					}
				}
				//visited[row][col] = false;
			}	
		}
		
		
		return;
	}
	
}
