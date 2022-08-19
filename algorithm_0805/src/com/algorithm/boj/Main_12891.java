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
public class Main_12891 {
	static int A, C, G, T;
	static String DNAStr = "ACGT";
	static int[] count = {0, 0, 0, 0};//A,C,G,T 순서대로
	
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
		
		//초기 세팅
		for(int i = start; i <= end; i++) {
			count[DNAStr.indexOf(dna[i])]++;
		}
		
		result = countDNA(result);
		
		while(end+1 < S) {
			//이전 문자는 버리기, 새로운 문자는 더하기
			count[DNAStr.indexOf(dna[start])]--;
			
			count[DNAStr.indexOf(dna[end+1])]++;
			
			result = countDNA(result);
			
			//범위를 조정함
			start++;
			end++;
		}
		
		System.out.println(result);
	}
	
	/*
	 * 부분 문자열에 포함되어야 할 dna의 최소 개수가 일치한지 판단
	 * @return dna_count
	 */
	public static int countDNA(int dna_count) {
		int[] temp = {A, C, G, T};//A,C,G,T 개수 순서대로
		
		//temp와 count를 비교해야함
		for(int i = 0; i < temp.length; i++) {
			if(count[i] == temp[i]) {
				continue;
			}else {
				return dna_count;
			}
		}

		//포함되어야 할 dna 개수가 일치하므로 카운트
		dna_count++;

		return dna_count;
	}
	
}
