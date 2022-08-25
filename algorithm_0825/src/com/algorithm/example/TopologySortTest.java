package com.algorithm.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TopologySortTest {
	static class Node{
		int vertex;
		Node next;
		
		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}
		
	}

	private static int V;
	private static int E;
	private static Node[] adjList;
	private static int[] inDegree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
	
		adjList = new Node[V+1];//각 정점별 인접리스트
		inDegree = new int[V+1];//정점별 진입차수
		
		for (int i = 0; i < E; i++) {
			st  = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
		
			//유향처리
			adjList[from] = new Node(to, adjList[from]);
			//진입차수 처리
			inDegree[to]++;
		}//입력 끝
		
		ArrayList<Integer> list = topologySort();
		if(list.size() == V) {//위상 정렬 완성
			for (Integer i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
		}else {//사이클이 된 경우
			System.out.println("사이클이 된 경우");
		}
		
	}
	
	private static ArrayList<Integer> topologySort(){
		ArrayList<Integer> list = new ArrayList<>();
		Queue<Integer> queue = new ArrayDeque<>();
		
		//진입차수가 0인 행렬 큐에 넣기
		for (int i = 1; i <= V; i++) {
			if(inDegree[i] == 0) queue.offer(i);//진입차수가 0인 정점 삽입
		}
		
		//BFS
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			list.add(cur);
			
			for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
				if(--inDegree[temp.vertex] == 0) queue.offer(temp.vertex);
			}
		}
		return list;
	}
	
}
