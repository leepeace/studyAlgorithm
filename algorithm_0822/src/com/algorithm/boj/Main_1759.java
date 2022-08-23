package com.algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 조건 : 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성, 알파벳 증가순
 * */
public class Main_1759 {
	
	static boolean[] visited;
	static int C;//문자 개수
	static int L;//암호 구성 개수
	static char[] alphabet;//입력 알파벳
	static char[] vowels;//모음
	static char[] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
		alphabet = new char[C];
		visited = new boolean[C];
		result = new char[L];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {
			alphabet[i] = st.nextToken().charAt(0);
		}
			
		searchCipher(0,0);
	}//end of main
	
	public static void searchCipher(int index, int count) {
		if(count == L) {
			int tmpVowels = 0, tmpConsonant = 0;
			boolean check = false;
			//최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성, 알파벳 증가 순인 경우 출력
			for(int i = 0; i < result.length; i++) {
				for(int j = 0; j < vowels.length; i++) {
					if(result[i] == vowels[j]) {
						tmpVowels++;
						check = true;
					}
				}
				if(!check){
					tmpConsonant++;
				}	
			}
			if(tmpConsonant >= 2 && tmpVowels >= 1) {
				for(int i = 0; i < result.length-1; i++) {
					if(result[i] < result[i+1]) {
						System.out.println(result.toString());
					}
				}
			}
			return;
		}
		
		visited[index] = true;
		
		//모든 경우의 수에 대해 알아본다.
		for(int i = 0; i < C; i++) {
			if(!visited[i]) {
				result[count] = alphabet[i];
				searchCipher(i, count+1);				
			}
			visited[i] = false;
		}
		
	}
	
}
