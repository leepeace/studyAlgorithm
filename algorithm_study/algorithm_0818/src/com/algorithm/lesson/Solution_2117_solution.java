package com.algorithm.lesson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 완전탐색, 시뮬레이션
 * k <= 20*20
 * */
public class Solution_2117_solution {
	
	private static int[] cost = {1,1,5,13,25,41,61,85,113,145,181,221,265,313,365,421,481,545,613,685,761,841,925,1013,1105,1201,1301,1405,1513,1625,1741,1861,1985,2113,2245,2381,2521,2665,2813,2965,3121,};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(tokens.nextToken());//도시의 크기 5 <= N <= 20
			int M = Integer.parseInt(tokens.nextToken());//하나의 집에서 지불할 수 있는 비용 1 <= M <= 10
			
			//{행,열}
			List<int[]> home = new ArrayList<int[]>();//전체를 저장하는 것이 아니라 집의 좌표 정보만 저장
			
			for (int r = 0; r < N; r++) {
				String s = br.readLine();
				for (int c = 0, index = 0; c < N; c++, index += 2) {
					if(s.charAt(index) == '1') {//집이면 '1'
						//int[] temp = new int[]{r,c};
						home.add(new int[]{r,c});//{행, 열}, 익명배열 사용
					}
				}
			}
			
			int maxCntHome = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					for(int K = 1; K <= 40; K++) {
						int cntHome = 0;
						for (int h = 0; h < home.size(); h++) {
							//범위가 k일때, 집들을 전부 카운트한다
							if(Math.abs(home.get(h)[0]-r) + Math.abs(home.get(h)[1]-c) < K) {
								cntHome++;
							}
						}
						if(cntHome * M >= cost[K] && maxCntHome < cntHome) {
							//최댓값 갱신
							maxCntHome = cntHome;			
						}
					}
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(maxCntHome).append("\n");
		}//end of test case
		
		System.out.println(sb);
	}
	
}
