package com.algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4012 {
	
	static int mid;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case < T; test_case++) {
			int N = Integer.parseInt(br.readLine());//식재료의 수
			int[][] S = new int[N][N];
			mid = N/2; 
			
			StringTokenizer tokens;
			for(int i = 0; i < N; i++) {
				tokens = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					S[i][j] = Integer.parseInt(tokens.nextToken());
				}
			}
			
			
			
		}//end of testcase
		
	}//end of main
}
