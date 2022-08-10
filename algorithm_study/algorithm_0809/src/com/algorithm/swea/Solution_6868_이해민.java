package com.algorithm.swea;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 출력 : 인영이가 카드를 내는 9! 가지의 경우에 대해 규영이가 게임을 이기는 경우의 수와 게임을 지는 경우의 수
 * 
 * */

public class Solution_6868_이해민 {
	static int size = 9;
	static boolean[] check = new boolean[size];
	static int[] card1;//규영이의 카드
	static int[] card2;//인영이의 카드
	static int win = 1;//규영이가 이기는 경우
	static int lose = 1;//규영이가 지는 경우
	static int result = 1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			card1 = new int[size];
			card2 = new int[size];
			
			boolean[] exist = new boolean[19];
			for(int i = 0; i < size; i++) {
				card1[i] = sc.nextInt();
				exist[card1[i]] = true;
			}
			sc.close();
			
			int idx = 0;
			for(int i = 1; i <= 18; i++) {
				if(!exist[i]) {
					card2[idx++] = i; 
				}
			}
			
			//int result = 0;
	
			
			permutation(0, 0, 0);
			
			
			System.out.println(result);
		}
		
	}
	
	
	/**
	 * @param count 진행되는 라운드
	 * @param score_gyu 규영이의 점수
	 * @param score_in 인영이의 점수
	 */
	private static void permutation(int count, int score_gyu, int score_in) {
		
		//탈출 조건 : 9라운드 모두 진행
		if(count == size) {
			if(score_gyu > score_in) {	
				win++;
			}else {
				lose++;
			}
			return;
		}
		for(int i = 0; i < size; i++) {//9개 카드 중 선택
			if(check[i]) {
				continue;
			}
			check[i] = true;//카드 선택 처리
			if(card1[i] > card2[i]) {//이기는 사람이 해당 라운드의 카드 합을 가짐
				score_gyu+= card1[i] + card2[i];
				permutation(count+1, score_gyu, score_in);
			}else {
				score_in += card1[i] + card2[i];
				permutation(count+1, score_gyu, score_in);
			}
			//원래 값으로 되돌림(카드 선택 해제)
			check[i] = false;
		}
		
		
		return;
	}
	
	
}
