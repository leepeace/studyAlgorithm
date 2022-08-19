package com.algorithm.boj;

import java.util.Scanner;

/*
 * 문제 : 백준 1074 Z
 * 출력 : r행 c열을 몇 번째로 방문했는지 출력
 * 분할
 * */
public class Main_1074 {
	private static int r;
	private static int c;
	private static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		visitedCount(0, (int) Math.pow(2, N), 0);
	}
	
	private static void visitedCount(int start, int end, int count) {
		if(start == r && end == c) return;
		
		int mid = (start + end) / 2;
		
		//visitedCount(mid+1, end, count++);
		//visitedCount(start, mid, count++);
		
		for (int i = start; i < start + N/2; i++) {
			
		}
		
		
	}
	
	
}
