package com.algorithm.lesson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * dfs로 풀어보기
 * 
 * */
public class Solution1227_teacher_solve {
	
	private static int[][] m;
	//private static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		int T = 10;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			br.readLine();//testcase번호 버림
			m = new int[100][100];//미로
			//visited = new boolean[100][100];//방문체크
			
			int sr = -1, sc = -1;
			for(int i = 0; i < 100; i++) {
				String s = br.readLine();
				for(int j = 0; j < 100; j++) {
					m[i][j] = s.charAt(j);//'0' 안해도 처리가능
					if(m[i][j] == '2') {//시작점인 경우
						sr = i; sc = j;
					}
				}
			}
			
			int result = dfs(sr, sc);		
			sb.append("#").append(test_case).append(" ").append(result).append("\n");
			System.out.println(sb.toString());
		}//end of for testcase
		
	}//end of main
	
	private static int[] dr = {-1, 1, 0, 0};//상하좌우
	private static int[] dc = {0, 0, -1, 1};
	
	//'3'에 도착하면 1을 리턴, 아닌경우 0을 리턴
	public static int dfs(int r, int c) {
		//if(visited[r][c] || m[r][c] == '1') return 0;
		if(m[r][c] == '1') return 0;
		if(m[r][c] == '3') return 1;
		
		//visited[r][c] = true;//여기는 지나간 길이라고 체크
		m[r][c] = '1';//길을 없앰(지나간 길이라고 체크)
		
		int result = 0;
		//도착하지않은 경우에만 탐색하기 위해 result를 사용
		for (int i = 0; i < dc.length && result == 0; i++) {
			result = dfs(r + dr[i], c + dc[i]);
		}
		
		return result;
	}
	
}//end of class
