package com.algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2001 {
	static int M;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());//테스트 케이스
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());//배열의 크기
			M = Integer.parseInt(st.nextToken());//파리채의 크기
			
			int result = 0;
			
			int[][] num = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					num[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			/*
			 * (k,l) ~ (k+M,l+M)사이의 합을 구함
			 * */
			for(int k = 0; k + M <= N; k++) {
				for(int l = 0; l + M <= N; l++) {
					result = Math.max(result, maxCount(k, l, num));
				}
			}
			
			System.out.println("#" + test_case + " " + result);
		}//end testcase
		
	}
	
	//가장 많은 파리의 개수를 구함
	public static int maxCount(int row, int col, int[][] array) {
		int sum = 0;
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < M; j++) {
				sum += array[i+row][j+col];
			}
		}
		return sum;
	}
	
}
