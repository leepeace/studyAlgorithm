package com.algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 : 17406번, 배열 돌리기4
 * 접근 방안
 * 1. 순서를 고려하기(순열)
 * 2. 배열을 회전시킬때 모서리 값을 저장한 뒤 회전시키기
 * */
public class Main_17406_이해민 {
	
	public static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//우 하 좌 상
	public static int N;//행
	public static int M;//열
	static boolean[][] visited;//방문 여부 확인
	static int[][] num;//원본 배열
	static int r, c, s;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tokens.nextToken());//행
		M = Integer.parseInt(tokens.nextToken());//열
		int K = Integer.parseInt(tokens.nextToken());//회전 연산의 개수
		
		num = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				num[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		int result = 0;
		
		for (int i = 0; i < K; i++) {
			tokens = new StringTokenizer(br.readLine());
			//회전 연산 (r, c, s)
			r = Integer.parseInt(tokens.nextToken());
			c = Integer.parseInt(tokens.nextToken());
			s = Integer.parseInt(tokens.nextToken());
			
			//가장 왼쪽 윗 칸 (r-s, c-s)
			//가장 오른쪽 아랫 칸 (r+s, c+s)
			int nowX = r-s, nowY = c-s;
			
			rotate(nowX, nowY, 1);
		}
		
		
		
		StringBuilder sb = new StringBuilder();
		for(int[] arr : num) {
			for(int data : arr) {
				sb.append(data + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
		System.out.println(result);
	}
	
	private static void rotate(int nowX, int nowY, int rotateCount) {
		
		//이동할 좌표
		int nextX = 0;
		int nextY = 0;
		
		//4방향 조절
		int dir = 0;
		
		int[][] edge = {{r-s, c-s}, {r+s, c+s}, {r+s, c-s}, {r+s, c+s}};//지워질 수 있는 모서리 값을 미리 저장
		

		while(dir < 4) {
			int temp = num[nowX][nowY];
			
			//이동할 좌표
			nextX = nowX + direction[dir][0];
			nextY = nowY + direction[dir][1];
			
			//범위를 벗어나거나 이미 방문한 경우
			if(nextX < r-s || nextY < c-s || nextX > r+s || nextY > c+s || nextX < 0 || nextY < 0 || nextX > N || nextY > M) {
				dir++;
			}
			
			num[nextX][nextY] = temp;
			
			//현재 위치에 다음 위치를 넣어줌
			nowX += direction[dir][0];
			nowY += direction[dir][1];
		
		}//end while
		
		if(rotateCount < Math.min(r+s, c+s)/2) {
			rotate(nowX, nowY, rotateCount+1);
		}
		
	}
	
}
