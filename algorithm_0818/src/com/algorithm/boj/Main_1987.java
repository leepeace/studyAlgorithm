package com.algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문제 : 백준 1987번 알파벳
 * 출력 : 말이 지날 수 있는 최대의 칸 수
 * 접근 방안 : 백트래킹을 이용한 DFS탐색
 * */
public class Main_1987{
	private static boolean[] visited = new boolean[26];//방문여부 확인(알파벳을 인덱스로 사용)
	private static int R;//세로
	private static int C;//가로
	private static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};//상하좌우
	private static char[][] board;//입력 배열
	private static int result;//말이 지날 수 있는 최대의 칸 수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		
		board = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = temp.charAt(j);
			}
		}
		
		//좌측 상단 시작 (0,0)
		dfs(0, 0, 0);
		
		System.out.println(result);
	}
	
	/**
	 * 갈 수 있는 경로에 대해 끝까지 가봐야 함
	 * @param row 현재 행
	 * @param col 현재 열
	 * @param count 몇 칸 지나왔는지 카운트
	 */
	private static void dfs(int row, int col, int count) {
		
		//탈출 조건 : 이전에 선택했던 알파벳과 현재 알파벳이 같은 경우
		if(visited[board[row][col]-'A']) {
			result = Math.max(result, count);//결과값 갱신
			return;
		}

		//현재 경로를 방문한다.
		visited[board[row][col]-'A'] = true;
		//System.out.print(board[row][col] + " ");
		
		//상하좌우 모든 방향에 대해 탐색
		for(int i = 0; i < direction.length; i++) {
			int nextX = row+direction[i][0];
			int nextY = col+direction[i][1];
			if(nextX < 0 || nextY < 0 || nextY >= C || nextX >= R) continue;
			dfs(nextX, nextY, count+1);
		}
		
		//방문했던 알파벳을 다시 미방문으로 처리
		visited[board[row][col]-'A'] = false;
		return;
	}
	
	
	/**
	 * 현재 선택한 알파벳 직전까지의 알파벳과 비교한다.
	 * @param row 현재 행
	 * @param col 현재 열
	 * @return true이면 알파벳이 겹치는 경우, false면 알파벳이 겹치지 않음
	 */
	//>>이 방법은 시간초과
	/*private static boolean checkAlphabet(int row, int col) {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(visited[i][j]) {
					if(board[row][col] == board[i][j]) {
						return true;
					}	
				}
			}
		}
		return false;
	}*/
	
}
