package com.algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

/*
 * 문제 : 백준 1992번 쿼드트리
 * 유형 : 분할정복
 * */
public class Main_1992 {

	private static int[][] quadTree;
	private static List<Integer> result = new ArrayList<Integer>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
				
		quadTree = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				quadTree[i][j] = temp.charAt(j)-'0';
			}
		}
		compression(0, 0, N);
	}
	
	//4분할  
	private static void compression(int start, int end, int size) {
		boolean flag = false;
		flag = checkSameNum(start, end, size);
		
		if(!flag) {
			//(start, end) ~ (start+size, end+size)까지 모두 같다면
			System.out.print(quadTree[start][end]);
		}else {
			//4등분하여 다시 검사
			System.out.print("(");
			size = size / 2;
			compression(start, end, size);//왼쪽 위
			compression(start, end+size, size);//오른쪽 위
			compression(start+size, end, size);//왼쪽 아래
			compression(start+size, end+size, size);//오른쪽 아래
			System.out.print(")");
		}

	}
	
	//같은 숫자(0,1)을 가지고 있는지 확인함
	private static boolean checkSameNum(int start, int end, int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if(quadTree[start][end] != quadTree[start+i][end+j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	
}
