package com.algorithm.example.backtracking;

import java.util.Scanner;

//같은 행에 퀸을 놓지 않으므로 일차원 배열로 하자!
//->각 행의 퀸에 놓아진 위치를 저장하게 됨(열 위치)
//1. 같은 열 : 열의 위치 값 비교
//2. 대각선을 체크해야 함 : |행 차이| == |열 차이|
//출력 : 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수
public class NQueenTest {
	
	static int N, cols[], ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		cols = new int[N+1];//1행부터 사용
		ans = 0;
		
		setQueen(1);
		System.out.println(ans);
	}
	
	public static void setQueen(int rowNo) {//하나의 퀸만 가능한 모든 곳에 놓아보기
		
		//유망성 체크 : 직전까지의 상황이 유망하지 않으면 현재 퀸을 놓을 필요가 없으니 백트랙!
		if(!isAvailable(rowNo-1)) return;
		
		//여기까지 내려오면 유망한 경우
		
		//탈출 조건 : 퀸을 다 놓은 경우(모든 퀸의 배치에 성공한 상황)
		if(rowNo > N) {
			ans++;//경우의 수 증가
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			cols[rowNo] = i;//해당 열에 퀸을 놓음
			setQueen(rowNo+1);//다음 퀸을 놓으러 감
		}
		
	}

	
	/**
	 * 유망한지 체크 : 나의 직전 퀸까지를 전부 비교	
	 * @param rowNo 현재 퀸을 놓으려는 위치
	 * @return
	 */
	private static boolean isAvailable(int rowNo) {
		for (int j = 1; j < rowNo; j++) {
			//열 위치가 같거나 행차이와 열차이가 같은경우(대각선)
			if(cols[j] == cols[rowNo] || 
					rowNo - j == Math.abs(cols[rowNo]-cols[j])) return false;
		}
		return true;
	}
	
	
	
}
