package com.algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17144 {
	
	private static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};//상하좌우
	private static Queue<int[]>	air_cleaner;
	private static Queue<int[]> dust;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R+1][C+1];
		
		air_cleaner = new LinkedList<>();
		dust = new LinkedList<>();
		
		for (int i = 1; i < R+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < C+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					air_cleaner.add(new int[] {i, j});
				}else if(map[i][j] != 0) {
					dust.add(new int[] {i, j});
				}
			}
		}
		
		
		
	}//end of main
	
	//공기청정기가 있는 칸으로는 확산이 일어나지 않음
	
	private static void spread() {
		
		while(true) {
			int nowX;
			int nowY;
			
			for (int i = 0, size = dir.length; i < size; i++) {
				
			}
			
		}
		
	}
	
}
