package com.algorithm.example;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 순열 : 순서가 있음
 * 조합 : 순서가 없음
 * */
public class Ex_DiceTest {
	
	static int N, totalCnt;
	static int[] numbers;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//던지는 주사위의 수
		int mode = sc.nextInt();//던지기 모드
		
		totalCnt = 0;
		numbers = new int[N];
		
		switch (mode) {
		case 1://중복순열
			dice1(0);
			break;
		case 2://순열
			isSelected = new boolean[7];//1~6의 주사위 눈 선택  여부
			dice2(0);
			break;
		case 3://중복조합
			dice3(0, 1);
			break;
		case 4:
			dice4(0, 1);
			break;
		default://조합
			System.out.println("잘못된 입력입니다.");
			break;
		}
		
		System.out.println("총 경우의 수 : " + totalCnt);
	}
	
	//주사위 던지기 1 : 중복 순열
	private static void dice1(int cnt) {
		if(cnt == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		//가능한 모든 수 시도 (주사위 눈 1~6)
		for(int i = 1; i <= 6; i++) {
			//수의 중복 선택이 가능하므로 중복 체크 필요없음!
			//해당 수 선택
			numbers[cnt] = i;
			//다음 주사위 던지러 가기
			dice1(cnt+1);
		}
	}
	
	//주사위 던지기 2 : 순열
	private static void dice2(int cnt) {
		if(cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		//가능한 모든 수 시도 (주사위 눈 1~6)
		for(int i = 1; i <= 6; i++) {
			//중복 체크 필요!
			if(isSelected[i]) {
				continue;
			}
			
			//해당 수 선택
			numbers[cnt] = i;
			isSelected[i] = true;
			
			//다음 주사위 던지러 가기
			dice2(cnt+1);
			
			//전부 돌고나면 다시 미방문 상태로 바꾼다.
			isSelected[i] = false;
		}	
	}
	
	//주사위 던지기 3 : 중복 조합
	private static void dice3(int cnt, int start) {
		if(cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice3(cnt+1, i);
		}
	}
	
	//주사위 던지기 4: 조합
	private static void dice4(int cnt, int start) {
		if(cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice4(cnt+1, i+1);
		}
	}
	
	
}
