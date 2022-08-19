package com.algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 해당 노드에 자식 노드가 있으면, 리프노드가 아니므로 인덱스는 전체 배열 크기의 N의 절반보다 작아야 한다.
 * 
 * 
 * */
public class Solution_1223 {
	 public static void main(String[] args) throws NumberFormatException, IOException {
		int T = 10;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens;
		for(int test_case = 1; test_case <= T; test_case++) {
			tokens = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(tokens.nextToken());//트리 정점의 총 수
			
			int[] node = new int[N+1];
			
			int result = 1;//유효성 여부 확인함. 1은 유효
			
			for(int i = 1; i <= N; i++) {
				tokens = new StringTokenizer(br.readLine());	
				int parent = Integer.parseInt(tokens.nextToken());//부모 노드
				char operation = tokens.nextToken().charAt(0);//연산자
				node[parent] = operation;
			}
			
			//부모  : i/2
			//왼쪽 자식 노드 : 2*i
			//오른쪽 자식 노드 : 2*i + 1
			//맨 밑에 리프노드가 숫자이면 되나??
			//노드의 자식이 없는 경우?? 
 			/*for(int i = 1; i <= N; i++) {
				if(node[i] == 0) {
					int temp = node_operation[i] - '0';
					if(temp >= 0 && temp <= 9) {
						result = 1;
					}else {
						result = 0;
					}
				}
			}*/
			
			int nodeIdx = N / 2;//유효성 판단의 기준
			for(int i = 1; i < N+1; ++i) {
				if(node[i]-'0' >= 0 && node[i]-'0' <= 9) {
					if(i <= nodeIdx) {// 리프 노드가 아닌 경우 숫자가 올 수 없음
						result = 0;
						break;
					}
				}else {//연산자가 올때
					if(i > nodeIdx) {//
						result = 0;
						break;
						
					}
				}
			}
			
			//계산이 가능하다면 1, 계산이 불가능할 경우 0을 출력
			System.out.println("#" + test_case + " " + result);
		}
		
	 }
	 
	
	 
}
