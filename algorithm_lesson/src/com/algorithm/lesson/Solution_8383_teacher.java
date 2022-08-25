package com.algorithm.lesson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 문제 : swea 8382 방향 전환
 * 문제 접근 방법 
 * 1. 규칙을 발견해서 풀 수 있음
 * 2. bfs로 풀 수 있음
 */
public class Solution_8383_teacher {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(tokens.nextToken());
			int y1 = Integer.parseInt(tokens.nextToken());
			int x2 = Integer.parseInt(tokens.nextToken());
			int y2 = Integer.parseInt(tokens.nextToken());
			
			int dx = Math.abs(x2-x1);
			int dy = Math.abs(y2-y1);
			
			int min = Math.min(dx, dy);
			int max = Math.max(dx, dy);
			int result = min * 2 + (max - min) * 2 - ((max-min) % 2 == 0 ? 0 : 1);
			
			//(3,7)의 경우
			//(0,0)->(3,3) : 6번 이동 
			//작은쪽은 2*n이동
			//나머지 이동
			
			
			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}//end of testcase
		System.out.println(sb.toString());
	}
	
}
