package com.algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lee haemin
 * 문제 : 백준 10026 적록색약
 * 접근 유형 : bfs
 */
public class Main_10026 {
	
	private static int[][] direction = {{-1,0}, {1,0}, {0,-1}, {0,1}};//상하좌우
	private static int N;

	static class Color{
		int x;
		int y;
		
		public Color(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		char[][] rgb = new char[N][N];
		
		boolean[][] visited = new boolean[N][N];
		
		char[][] rg_same = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < N; j++) {
				rgb[i][j] = tmp.charAt(j);
				if(rgb[i][j] == 'G') {//적록색약의 경우 'R'과 'G'를 같은 경우로 보아야하므로 바꾸어줌
					rg_same[i][j] = 'R';
				}else {
					rg_same[i][j] = rgb[i][j];
				}
			}
		}
		
		
		//적록색약이 아닌 사람이 봤을 때 구역의 수를 구함
		int rgb_result = 0;
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {//bfs를 통해 같은 색상 그룹에 대해 탐색하므로, 방문하지 않은 경우는 다른 색상 그룹이라는 뜻
					searchArea(rgb, visited, i, j);
					rgb_result++;
				}
			}
		}
		
		
		visited = new boolean[N][N];
		
		//적록색약인 사람이 봤을 때 구역의 수를 구함
		int rg_same_result = 0;
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					searchArea(rg_same, visited, i, j);
					rg_same_result++;
				}
			}
		}
		
		
		System.out.println(rgb_result + " " + rg_same_result);
	}
	
	
	/*
	 * bfs탐색을 통해 같은 색상 그룹을 방문하며 true로 바꾸어놓음.
	 * */
	private static void searchArea(char[][] map, boolean[][] visited, int row, int col) {
		Queue<Color> queue = new LinkedList<>();
		//초기화
		queue.add(new Color(row, col));
		visited[row][col] = true;
		
		//같은 색상이 더 이상 안나올때까지 while문을 돈다
		while(!queue.isEmpty()) {
			Color color = queue.poll();
			int nowX = color.x;
			int nowY = color.y;
			
			for (int i = 0, size=direction.length; i < size; i++) {
				int nextX = nowX + direction[i][0];
				int nextY = nowY + direction[i][1];
				
				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
				
				if(!visited[nextX][nextY]) {//방문하지 않은 경우
					if(map[nowX][nowY] == map[nextX][nextY]) {//같은 색상 그룹인 경우
						visited[nextX][nextY] = true;
						queue.add(new Color(nextX, nextY));
					}
				}
			}
		}
	}
	
}
