package com.algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문제 : SWEA 9229 한빈이와 Spot Mart
 * 추가방안 : 백트래킹으로 접근해보기
 * */
public class Solution_9229 {
	
	static int M, N;
	static int result;
	static boolean[] visited;
	static int[] snack;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		int TC = Integer.parseInt(tokens.nextToken());
		
		for(int test_case = 1;  test_case <= TC; test_case++) {
			tokens = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tokens.nextToken());//과자 봉지의 개수
			M = Integer.parseInt(tokens.nextToken());//무게 합 제한
			
			snack = new int[N];
			
			tokens = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				snack[i] = Integer.parseInt(tokens.nextToken());
			}
		
			int temp = 0;
			/*for(int i = 0; i < N; i++) {
				for(int j = i+1; j < N; j++) {
					temp = snack[i] + snack[j];//과자는 두봉지 사야함
					if(temp <= M) {
						result = Math.max(result, temp);
					}
				}
			}*/
			
			//재귀함수 호출
			solve(0, 0, 0);
			
			if(result == 0) {
				result = -1;
			}
			
			System.out.println("#" + test_case + " " + result);
			result = 0;
		}
		
		br.close();
	}
	
	private static void solve(int start, int count, int temp) {
		
		//탈출 조건(과자는 두봉지 사야하므로)
		if(count == 2){
			//결과 값 갱신
			result = Math.max(result, temp);			
			return;
		}
		
		//경로 탐색
		for(int i = start; i < N; i++) {
			if(temp + snack[i] > M) {
				continue;
			}
			
			//재귀 호출
			solve(i+1, count+1, temp + snack[i]);
		}
		
		return;
	}
	
	
}
