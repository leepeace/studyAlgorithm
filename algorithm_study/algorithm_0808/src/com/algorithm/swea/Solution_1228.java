package com.algorithm.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 문제 : SWEA 1228번 암호문1
 * 접근 유형 : List
 * 1. LinkedList <- 원본 암호문을 저장
 * 2. 명령어의 개수
 * 3. M번의 명령어 입력을 받아 수행(반복)
 * 	3-1. I : 명령어 -> 저장할 필요없음
 * 	3-2. 암호문 삽입 위치 x(인덱스 0부터 시작하므로 그대로 사용해도 됨)
 * 	3-3. 삽입할 숫자의 개수 y
 *  3-4. 암호문 위치에 넣어주기(반복)
 *  	시작위치 : x -> 끝나는 위치 x+y
 *  	add(i) : i라는 인덱스 위치에 값 넣기
 *  	add(x, 입력값);
 * 4. 출력 : 숫자 10개만 출력
 * */
public class Solution_1228 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());//원본 암호문의 길이
			
			//값의 변경이 자주 일어나므로 LinkedList를 활용하자!!!
			List<Integer> originalCipher = new LinkedList<Integer>();//원본 암호문
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				//공백 기준으로 잘라서 list에 암호문 담아주기
				originalCipher.add(i, Integer.parseInt(st.nextToken()));
			}
			
			st = new StringTokenizer(br.readLine());
			int commandCount = Integer.parseInt(st.nextToken());//명령어의 개수
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < commandCount; i++) {
				String command_I = st.nextToken();//명령문의 시작을 알려주는 I
				int index = Integer.parseInt(st.nextToken());//삽입할 인덱스 위치
				int command = Integer.parseInt(st.nextToken());//삽입할 숫자의 개수 : y
				int[] commandArray = new int[command];//y개의 숫자를 담을 배열
				
				for(int j = 0; j < command; j++) {
					commandArray[j] = Integer.parseInt(st.nextToken());
				}
				
				for(int k = 0; k < command; k++) {
					originalCipher.add(index+k, commandArray[k]);	
				}
		
			}//암호문 수정 완료

			//결과 출력
			bw.write("#" + test_case + " ");
			for(int i = 0; i < 10; i++) {
				bw.write(originalCipher.get(i) + " ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
