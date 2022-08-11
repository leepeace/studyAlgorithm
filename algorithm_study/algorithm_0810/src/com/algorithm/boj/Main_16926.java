package com.algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		int R = Integer.parseInt(token.nextToken());
		
		int[][] array = new int[N+1][M+1];
		for(int i = 1; i <= N; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				array[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		br.close();
		
		int[][] delta = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};//좌, 하, 우, 상
		
		//배열의 범위 끝에 닿을때까지 옮기기
		//회전이 한번 일어날때 모서리에 있는 원래있던 값은 하나씩 밀려남
		//마지막 값은 delta[j+1][]로 계산해야함
		//모서리 값을 그 다음 방향의 시작 값으로 셋팅하기
		
		int[][] xy = {{1,1}, {N,1}, {N,M}, {1,M}};
		int[][] move = {{1, 1}, {-1, 1}, {-1, -1}, {1, -1}};
		
		boolean[][] visited = new boolean[N+1][M+1];
		
		int nowX = 1, nowY = M;
		
		for(int j = 0; j < R; j++) {
			int i = 0;
			int nextX = 0, nextY = 0;
			while(true) {//4방향 탐색

				int saveValue = array[xy[i][0]][xy[i][1]];//모서리 값
				
				//다음 이동할 좌표 셋팅
				nextX = nowX + delta[i][0];
				nextY = nowY + delta[i][1];
				
				//배열의 범위를 넘어선 경우
				if(nextX < 0 || nextY < 0 || nextX < N || nextY < M) {//배열의 인덱스를 넘어선 경우
					i = (i + 1) % 4;
				}
				
				//모서리값을 그 다음 방향의 첫 시작 위치에 셋팅
				if(nextX == (xy[i][0] + delta[i][0]) && nextY == (xy[i][1] + delta[i][0])) {
					array[nextX][nextY] = saveValue;
				}
				
				//배열을 회전시킴
				array[nextX][nextY] = array[nowX][nowY];
				
				//현재 위치를 바꾸어야함
				nowX = nextX;
				nowY = nextY;
				
			}
			
			//다음 라운드의 모서리 좌표를 계산함
			//xy[i][0] += move[i][0];
			//xy[i][1] += move[i][1];	
		}//end for
		
		
		//결과 출력
		for(int i = 1; i <= N; i++) {
			for(int k = 1; k <= M; k++) {
				System.out.print(array[i][k] + " ");
			}
			System.out.println();
		}
		
	}
	
	private static void rotate() {
		
	}
	
}
