package com.algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 12891번 DNA 비밀번호
 * 접근 유형 : 슬라이딩 윈도우
 * 출력 : 만들 수 있는 비밀번호의 종류의 수
 * */
public class Main_2493 {
	
	static int A, C, G, T;
	static String DNAStr = "ACGT";
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());//DNA 문자열 길이
		int P = Integer.parseInt(st.nextToken());//부분 문자열의 길이
		
		char[] dna = new char[S];//임의의 DNA 문자열
		
		String temp = br.readLine();
		for(int i = 0; i < dna.length; i++) {
			dna[i] = temp.charAt(i);
		}
		
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		
		int result = 0;
		int start = 0, end = P-1;
		
		int[] count = {0, 0, 0, 0};//A,C,G,T 순서대로
		//초기 세팅
		for(int i = start; i <= end; i++) {
			count[DNAStr.indexOf(dna[i])]++;
		}
		
		result += countDNA(result, count);
		start++;
		end++;
		while(end < S) {
			//start-1은 버리기, end는 더하기
			count[DNAStr.indexOf(dna[start-1])]--;
			
			
			count[DNAStr.indexOf(dna[end])]++;
			
			result = countDNA(result, count);
			
			//범위를 조정함
			start++;
			end++;
		}
		
		System.out.println(result);
	}
	
	public static int countDNA(int count, int[] result) {
		boolean check = false;
		int[] temp = {A, C, G, T};
		for(int i = 0; i < 4; i++) {
			if(result[i] == temp[i]) {
				check = true;
			}else {
				break;
			}
		}
		
		if(check) {
			count++;
		}
		
		return count;
	}
	
}
