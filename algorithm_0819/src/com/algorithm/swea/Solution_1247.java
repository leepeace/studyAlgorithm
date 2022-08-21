package com.algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//회사에서 출발해서 이들을 모두 방문하고 집에 돌아가는 경로 중 총 이동거리가 가장 짧은 경로를 찾는 프로그램
/*
 * SWEA 1247 최적 경로
 * 접근 방안 : 완전 탐색 DFS
 * 추가 개선 사항 : 순열에서 비트마스킹 사용
 * */
public class Solution_1247 {
	private static boolean[] visited;//방문여부 확인
	private static int N;//고객의 수
	private static Coordinate[] customer;//N명의 고객의 좌표
	//private static int result = 0;//결과값
	private static Coordinate home;//집의 좌표
	private static Coordinate company;//회사의 좌표
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			//회사의 좌표,집의 좌표, N명의 고객의 좌표
			company = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			customer = new Coordinate[N];
			
			for (int i = 0; i < N; i++) {
				customer[i] = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			visited = new boolean[N];
			int result = Integer.MAX_VALUE;
			
			for(int i = 0; i < N; i++) {
				result = calcMinRoute(i, 1, Math.abs(company.x - customer[i].x) + Math.abs(company.y - customer[i].y), result);
			}			
			
			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}//end of main
	
	//좌표 저장
	static class Coordinate{
		int x;
		int y;
		public Coordinate(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}	
		
	}
	
	//고객의 집을 방문하면 방문처리함
	//방문여부 인덱스는 [0~N]
	//파라미터는 현재 방문한 몇번째인지 순서를 받아야 함
	//총 이동 거리 : 회사에서 첫 고객 방문 집 사이의 거리를 구해줌 + 집 사이의 거리 + 마지막 고객의 집과 본인 집 거리 사이
	//마지막 고객 집에 방문한 경우 마지막 고객의 집과 집의 좌표를 빼주어 결과값을 갱신
	
	/**
	 * @param start 경로 방문 시작인덱스
	 * @param count 이동횟수
	 * @param route 누적합
	 * @param result 결과값
	 * @return
	 */
	private static int calcMinRoute(int start, int count, int route, int result) {
	
		if(count == N) {
			//마지막 고객의 집과 본인 집 거리 사이 갱신
			result = Math.min(result, route + Math.abs(home.x-customer[start].x) + Math.abs(home.y-customer[start].y));
		}
		
		visited[start] = true;
		
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				//고객간의 거리를 넘겨줌
				result = calcMinRoute(i, count+1, route+Math.abs(customer[i].x - customer[start].x) + Math.abs(customer[i].y - customer[start].y), result);				
			}
		}//추가 개선 사항 : 순열에서 비트 마스킹을 사용해보자
		
		visited[start] = false;
		return result;
	}
	
}
