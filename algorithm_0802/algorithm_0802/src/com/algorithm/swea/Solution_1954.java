package com.algorithm.swea;

import java.util.Scanner;

/*
 * swea 문제
 * 방향을 전환시켜가며 풀어야하는 문제
 * */
public class Solution_1954 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt();//달팽이의 크기
			int[][] data = new int[N][N];
			
			int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
			
			boolean[][] check = new boolean[N][N];//방문 여부 확인
			
			int nowRow = 0, nowCol = 0;//현재 행,열 위치
			int num = 1;
			data[0][0] = num++;
			check[0][0] = true;
			
			int i = 0;
			while(true) {
				if(num > N*N) {
					break;
				}
				while(true) {
					if(nowRow + dir[i][0] >= N || nowCol + dir[i][1] >= N || nowRow + dir[i][0] < 0 || nowCol + dir[i][1] < 0 || check[nowRow + dir[i][0]][nowCol + dir[i][1]]) {
						break;
					}
					if(!check[nowRow + dir[i][0]][nowCol + dir[i][1]]) {//방문하지 않은 경우 
	  					data[nowRow + dir[i][0]][nowCol + dir[i][1]] = num++;
						check[nowRow + dir[i][0]][nowCol + dir[i][1]] = true;
						nowRow = nowRow + dir[i][0];
						nowCol = nowCol + dir[i][1]; 
					}
				}
				i = (i + 1) % 4;//방향 전환
			}
			
			
			System.out.println("#" + test_case);
			for(int l = 0; l < N; l++) {
				for(int k = 0; k < N; k++) {
					System.out.printf("%d ", data[l][k]);
				}
				System.out.println();
			}
		}//end for
		
		sc.close();
	}
}
