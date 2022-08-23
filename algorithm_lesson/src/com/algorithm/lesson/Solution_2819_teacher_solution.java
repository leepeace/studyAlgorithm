package com.algorithm.lesson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

//List - ArrayList, LinkedList
//Set(빠른 검색) - Tree, Hash(양이 많아질때 유리)
//Map
public class Solution_2819_teacher_solution {
	private static int[][] m;
	private static int cnt;
	//private static HashSet<String> hs;
	private static HashSet<Integer> hs;//->시간 절약(문자열 결합쓰지말고)
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= TC; test_case++) {
			//m = new char[4][4];
			m = new int[4][4];
			
			for (int i = 0; i < 4; i++) {
				String s = br.readLine();
				for (int j = 0, index = 0; j < 4; j++, index += 2) {
					m[i][j] = s.charAt(index)-'0';//공백을 뛰기 위해 +2
				}
			}
			cnt = 0;
			//hs = new HashSet<String>();
			hs = new HashSet<Integer>();
			
			for(int r = 0; r < 4; r++) {
				for (int c = 0; c < 4; c++) {
					//go(r,c,1,"");
					go(r,c,1,0);
				}
			}
			sb.append("#").append(test_case).append(" ").append(hs.size()).append("\n");
			//sb.append("#").append(test_case).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int[] dr = {-1, 1, 0, 0};//상하좌우
	private static int[] dc = {0, 0, -1, 1};
	
	private static void go(int r, int c, int step, int num) {
		//범위 체크
		if(r < 0 || r >= 4 || c < 0 || c >= 4) return;
		//글자 이어붙이기
		num = num * 10 + m[r][c];
		//str += m[r][c];
		//7글자인가?
		if(step == 7) {
			//중복되어 있지 않았으면, 카운팅, 추가
			if(!hs.contains(num)) {
				hs.add(num);
				//cnt++;
			}
			return;
		}
		
		for (int i = 0; i < dc.length; i++){
			//재귀 상하좌우 호출
			go(r + dr[i], c + dc[i], step+1, num);	
		}
		
	}
	
	
	
}
