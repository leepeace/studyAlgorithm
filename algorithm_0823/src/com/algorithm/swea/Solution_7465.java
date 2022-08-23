package com.algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author lee haemin
 * 문제 : swea 7465 창용 마을 무리의 개수
 */
public class Solution_7465 {
	
	private static List<LinkedList<Integer>> node;
	private static boolean[] visited;//방문 여부 확인
	private static int N;//마을에 사는 사람의 수
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());//서로를 알고 있는 사람의 관계 수
			
			node = new LinkedList<LinkedList<Integer>>();
			visited = new boolean[N+1];
			
			for (int i = 0; i < N+1; i++) {//인접리스트 초기화
				node.add(new LinkedList<Integer>());
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				//양방향
				node.get(from).add(to);
				node.get(to).add(from);
			}
			
			int result = 0;
			
			//모든 정점에서 시작하여 탐색
			for (int i = 1; i <= N; i++) {
				if(!visited[i]) {//아직 방문하지않은 경우에는 카운트를 +1 한 뒤 인접한 노드들에도 방문 처리
					searchCycle(i);
					result++;	
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}//end of testcase
		System.out.println(sb.toString());
	}
		
	//몇 사람을 거쳐서 알 수 있는 관계를 찾는다
	private static void searchCycle(int from) {		
		visited[from] = true;
		
		for(int i = 0; i < node.get(from).size(); i++) {
			if(!visited[node.get(from).get(i)]) {
				searchCycle(node.get(from).get(i));
			}
		}
	}
	
}
