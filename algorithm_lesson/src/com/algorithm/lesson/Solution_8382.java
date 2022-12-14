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
public class Solution_8382 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(tokens.nextToken());
			int y1 = Integer.parseInt(tokens.nextToken());
			int x2 = Integer.parseInt(tokens.nextToken());
			int y2 = Integer.parseInt(tokens.nextToken());
			
			int result = 0;
			
			int dx = Math.abs(x2-x1);
			int dy = Math.abs(y2-y1);
			
			if((dx + dy) % 2 == 0)
				result = Math.max(dx, dy) * 2;
			else
				result = Math.max(dx, dy) * 2 - 1;
			
			System.out.println("#" + test_case + " " + result);
		}
	}
	
}
