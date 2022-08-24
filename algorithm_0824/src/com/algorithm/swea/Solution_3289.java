package com.algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문제 : SWEA 3289 서로소 집합
 * 출력 : 1로 시작하는 입력에 대해서 같은 집합에 속해있다면 1을, 아니면 0을 순서대로 한줄에 연속하여 출력
 * */
public class Solution_3289 {
	
	static class Edge{
		int operation;
		int from;
		int to;
		
		public Edge(int operation, int from, int to) {
			super();
			this.operation = operation;
			this.from = from;
			this.to = to;
		}
		
	}
	
	static int[] parents;//부모 인덱스
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
	
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			
			int n = Integer.parseInt(tokens.nextToken());//집합 개수
			int m = Integer.parseInt(tokens.nextToken());//연산의 개수
			
			Edge[] edges = new Edge[m];
			
			//초기화
			make_set(n);
						
			for (int i = 0; i < m; i++) {
				tokens = new StringTokenizer(br.readLine());
				int operation = Integer.parseInt(tokens.nextToken());
				int a = Integer.parseInt(tokens.nextToken());
				int b = Integer.parseInt(tokens.nextToken());
				edges[i] = new Edge(operation, a, b);
			}
			
			for (int i = 0, size = edges.length; i < size; i++) {
				if(edges[i].operation == 0) {
					union(edges[i].from, edges[i].to);
				}else {//1인 경우
					if(find(edges[i].from) ==  find(edges[i].to)) {
						sb.append(1);
					}else {
						sb.append(0);
					}
				}
			}
			
			System.out.println("#" + test_case + " " + sb.toString());
		}
		
	}//end of main
	
	//MakeSet : 크기가 1인 서로소 집합 생성
	private static void make_set(int n) {
		parents = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
		
	}
	
	//union : 서로 다른 두 개의 집합을 병합
	private static boolean union(int a, int b) {
		int a_root = find(a);
		int b_root = find(b);
		
		if(a_root == b_root) return false;
		
		parents[b_root] = a_root;
		
		return true;
	}
	
	//find : 집합의 원소가 어떤 집합에 속해 있는지 판단
	private static int find(int data) {
		if(parents[data] == data) {//내가 대표자인 경우
			return data;
		}
		
		return parents[data] = find(parents[data]);
	}
	
}
