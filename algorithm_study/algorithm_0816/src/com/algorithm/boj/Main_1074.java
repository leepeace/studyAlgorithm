package com.algorithm.boj;

import java.util.Scanner;

/*
 * 분할
 * */
public class Main_1074 {
	private static int r;
	private static int c;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		search(0, N-1, 0);
	}
	
	private static void search(int start, int end, int count) {
		if(start == r && end == c) return;
		
		int mid = (start + end) / 2;
		
		search(mid+1, end, count++);
		
		search(start, mid, count++);
		
	}
	
	
}
