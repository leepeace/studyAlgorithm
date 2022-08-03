package com.algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//원재의 메모리 복구하기 문제
public class Solution_1289 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//Scanner sc = new Scanner(System.in);
		int T;
		//T = sc.nextInt();
		T=Integer.parseInt(br.readLine());//"2\n" -> 2를 읽음
		
		for(int test_case = 1; test_case <= T; test_case++){
			int result = 0;
		
			String bitArray = br.readLine();

			StringBuilder initBit = new StringBuilder();//초기화 비트
			for(int i = 0; i < bitArray.length(); i++) {
				initBit.append('0');//초기화 비트 0으로 세팅
			}
			
			for(int i = 0; i < bitArray.length(); i++) {
				//초기값이 원래값과 같아지면 break
				if(initBit.equals(bitArray)) {
					break;
				}
				//원래 비트와 초기화 비트가 다른 경우 바꿔줌
				if(initBit.charAt(i) != bitArray.charAt(i)) {
					char changeBit = bitArray.charAt(i);
					//초기화 비트를 changeIndex 부터 끝까지 다시 반복문을 통해 바꿔줌
					for(int j = i; j < bitArray.length(); j++) {
						initBit.setCharAt(j, changeBit);
					}
					result++;
				}
			}
			System.out.println("#" + test_case + " " + result);
		}//end for

		
	}//end main

}
