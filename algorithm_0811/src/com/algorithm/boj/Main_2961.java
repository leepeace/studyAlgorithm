package com.algorithm.boj;

import java.util.Scanner;

/*
 * 문제 : 백준 2961 도영이가 만든 맛있는 음식
 * 출력 : 신맛과 쓴맛의 차이가 가장 작은 요리의 차이
 * 접근 유형 : 부분집합(바이너리 카운팅을 이용하거나 재귀를 활용하여 풀 수 있음)
 * */
public class Main_2961 {
	private static int N;
	private static int[] sour;
	private static int[] bitter;
	private static int result = Integer.MAX_VALUE;
	private static boolean[] visited;//재료 선택 여부
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		sour = new int[N];
		bitter = new int[N];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			sour[i] = sc.nextInt();
			bitter[i] = sc.nextInt();
			search(i, 1, 0, 0);
		}
		
		System.out.println(result);
		
		sc.close();
	}
	
	// 조건 : 신맛은 곱, 쓴맛은 합
	private static void search(int start, int multiply, int plus, int cnt) {
		if(start >= N) {
			return;
		}
		
		for(int i = start; i < N; i++) {
			if(!visited[i]) {
				cnt++;
				visited[i] = true;
				search(i+1, multiply * sour[i], plus + bitter[i], cnt+1);
			}
			visited[i] = false;
		}
		
		if(cnt > 0)
			result = Math.min(result, Math.abs(multiply-plus));
		
		return;
	}
	
}
