package com.algorithm.example;

import java.util.Scanner;

//bfs도 해보기!!!
public class AdjListTest {
	static class Node{
		int to;
		Node next;
		//int weight;//가중치 변수
		
		public Node(int to, Node next) {
			super();
			this.to = to;
			this.next = next;
		}
		
	}
	
	static Node[] adjList;
	static int N;
	private static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int E = sc.nextInt();
		
		adjList = new Node[N];
		visited = new boolean[N];
		
		//간선정보에 해당하는 부분만 덮어옴
		for(int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(to, adjList[to]);
		}
		
		dfs(0);
		
	}

	private static void dfs(int cur) {		
		visited[cur] = true;
		System.out.print((char)(cur + 'A'));
	
		//현재 정점의 인접정점들 큐에 넣어서 차후 탐색하도록 만들기
		for(Node temp = adjList[cur]; temp != null; temp = temp.next) {
			//방문하지 않았으면 인접한 경우
			if(!visited[temp.to]) {
				dfs(temp.to);
			}
		}
		
	}
	
	
	
}
