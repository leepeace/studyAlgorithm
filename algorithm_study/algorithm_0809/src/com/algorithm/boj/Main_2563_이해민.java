package com.algorithm.boj;

import java.util.Scanner;

/*
 * 문제 : 백준 2563번 색종이
 * 접근 유형 : 100*100 배열 형태에서 색종이에 해당하는 
 * */
public class Main_2563_이해민 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();//색종이의 수
	
		int result = 0;
	
		boolean[][] check = new boolean[100][100];
		
		int squareLength = 10; 
		int leftDistance = 0;//왼쪽 변과 도화지의 왼쪽 변 사이의 거리
		int downDistance = 0;//아래쪽 변과 도화지의 아래쪽 변 사이의 거리
		
		for(int i = 0; i < N; i++) {
			leftDistance = sc.nextInt();
			downDistance = sc.nextInt();
			
			//100*100 정사각형에서 색종이가 존재하는 배열에 대해서 count++
			for(int l = leftDistance; l < leftDistance + squareLength; l++) {
				for(int j = downDistance; j < downDistance + squareLength; j++) {
					if(!check[l][j]) {
						result++;
						check[l][j] = true;
					}	
					
				}
			}
		}
		
	
		
		System.out.println(result);
		
		sc.close();
	}
}
