package com.algorithm.swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 제한된 칼로리 안에서 가장 맛에 대한 점수가 높은 햄버거 칼로리를 출력
 * N개의 재료 중 L칼로리를 안 넘는 조합
 * 재료를 선택하는 경우와 선택하지 않는 경우를 나누어야 함
 * */
public class Solution5215 {
	static int N;//재료의 수
	static int L;//제한 칼로리
	
	static int[] taste = new int[N];//맛에 대한 점수 
	static int[] calorie = new int[N];//칼로리
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			L = sc.nextInt();
			
			taste = new int[N];//맛에 대한 점수 
			calorie = new int[N];//칼로리
			for(int i = 0; i < N; i++) {
				taste[i] = sc.nextInt();
				calorie[i] = sc.nextInt();
			}
			
			visited = new boolean[N];
			
			int choose = 0;
			int max = 0;
			for(int i = 0; i < N; i++) {
				int temp = 0;
				if(!visited[i]) {
					choose = calorie[i];
					temp += taste[i];
					visited[i] = true;
					
					int j = 0;
					if(choose < L) {
						while(true) {
							if(j >= N || calorie[j] >= L) {
								break;
							}
							if(!visited[j]) {
								int sum = choose + calorie[j];	
								if(sum <= L) {
									choose += calorie[j];
									temp += taste[j];	
								}
							}
							j++;
						}
					}
					visited[i] = false;	
					max = Math.max(max, temp);
				}
					
			}
			System.out.println("#" + test_case + " " + max);
		}//end for
		
		sc.close();
	}
	
	private void search(int food) {
		
		
	}
	
}
