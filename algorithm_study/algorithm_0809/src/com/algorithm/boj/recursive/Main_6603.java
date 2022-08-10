package com.algorithm.boj.recursive;

import java.util.Scanner;

/*
 * 문제 : 백준 6603번 로또
 * 접근 유형 : 재귀, 조합
 * 1. 로또 번호의 순서와 상관없이 선택해야하므로->조합
 * */
public class Main_6603 {
	
	static int k;
	static boolean[] check;
	static int[] lotto;
	static int[] temp = new int[6];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			k = sc.nextInt();//로또 개수
			if(k == 0) {
				break;
			}
			lotto = new int[k];
			check = new boolean[k];
			for(int i = 0; i < k; i++) {
				lotto[i] = sc.nextInt();
			}
			chooseLotto(0, k, 6);
			System.out.println();
			
		}
	
		
		sc.close();
	}
	
	
	
	/**
	 * @param depth 배열의 길이
	 * @param k
	 * @param r 뽑아야하는 개수
	 */
	private static void chooseLotto(int count, int k, int r) {
		//탈출 조건 : 6개의 수를 전부 고른 경우
		if(r == 0) {
			print();
			return;
		}
		//배열의 길이까지 돈 경우
		if(count == k) {
			return;
		}
		
		//현재 번호를 뽑은 경우
		check[count] = true;
		chooseLotto(count+1, k, r-1);
		
		//현재 번호를 뽑지 않은 경우
		check[count] = false;
		chooseLotto(count+1, k, r);
		
		return;
	}
	
	private static void print() {
		for(int i = 0; i < k; i++) {
			if(check[i]) {
				System.out.print(lotto[i] + " ");
			}
		}
		System.out.println();
	}
	
}
