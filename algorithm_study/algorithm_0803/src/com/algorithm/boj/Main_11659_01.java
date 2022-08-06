package com.algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 : 11659번, 구간 합 구하기 4
 * */
public class Main_11659_01 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//Scanner sc = new Scanner(System.in);
		
		int N = Integer.parseInt(st.nextToken());//수의 개수
		int M = Integer.parseInt(st.nextToken());//합을 구해야 하는 횟수
		
		int[] num = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] subSum = new int[N+1];
		subSum[0] = num[0];
		for(int i = 1; i < N; i++) {
			subSum[i] = subSum[i-1] + num[i];
		}
	
		//i번째 수부터 j번째 수까지 합을 구함
		//sum[j] - sum[i]
		
		for(int l = 0; l < M; l++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			System.out.println(subSum[j] - subSum[i-1]);
		}
		
	}
	
	
}
