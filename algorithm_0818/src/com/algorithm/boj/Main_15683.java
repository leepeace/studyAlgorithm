package com.algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 문제 : 백준 15683 감시
 * 출력 : CCTV의 방향을 적절히 정해서, 사각 지대의 최소 크기를 구함
 * 조건 : 감시 카메라 방향은 상,하,좌,우 방향으로 설정할 수 있음
 * */
public class Main_15683 {
	
	private static int[][] direction = {{-1,0}, {1,0}, {0,-1}, {0,1}};//상하좌우
	
	private static List<Coordinate> cctv = new ArrayList<>();//cctv 좌표
	private static int N;//세로 크기
	private static int M;//가로 크기
	private static int[][] office;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		//0은 빈 칸, 6은 벽, 1~5는 cctv번호
		office = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				office[i][j] = Integer.parseInt(tokens.nextToken());
				if(office[i][j] >= 1 && office[i][j] <= 5)
					cctv.add(new Coordinate(i, j));//cctv 좌표 저장
			}
		}
		
		//1~5번까지의 cctv 방향을 어떻게 처리할 것인가? 
		
		for (int i = 0; i < cctv.size(); i++) {
			calMinBlindSpot(cctv.get(i).x, cctv.get(i).y, 0);
		}
		
		
	}//end of main
	
	static class Coordinate{
		int x;
		int y;
		
		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	//모든 방향에 대해 검사한다.
	//0인 경우에 감시할 수 있음
	//cctv가 있는 좌표를 미리 저장하자?? o
	//cctv좌표를 하나씩 꺼내보면서 모든 방향에 대해 탐색해본다.
	//벽을 만나거나 배열을 벗어날때까지 방향을 이동할 수 있다.
	//사각 지대의 최소 크기는? 최대한 많이 이동할 수 있는 방향을 선택해야 얻을 수 있다.
	
	/**
	 * @param row 현재 행 
	 * @param col 현재 열
	 * @param count 이동 개수
	 */
	private static void calMinBlindSpot(int row, int col, int count) {
		//탈출 조건: 벽을 만난 경우
		if(office[row][col] == 6)
			return;
		
		//현재 방향에 대해 갈 수 있는 모든 방향을 탐색해본다.
		for (int r = row; r < N; r++) {
			for (int c = col; c < M; c++) {
				for(int dir = 0; dir < direction.length; dir++) {
					int nowX = row + direction[dir][0];//이동할 x 좌표
					int nowY = col + direction[dir][1];//이동할 y 좌표
					if(row < 0 || col < 0 || row >= N || col >= M)
						continue;
					if(office[nowX][nowY] == 0)
						calMinBlindSpot(nowX, nowY, count+1);
				}
			}
		}
	}
	
	
}
