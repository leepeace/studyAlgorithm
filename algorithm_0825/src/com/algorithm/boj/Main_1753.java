package com.algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 문제 : 1753 최단 경로
 * 다익스트라 알고리즘(음수 가중치 X)
 */
/*public class Main_1753 {
	
	static class Node{
		int to;
		int weight;
		
		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());//정점의 개수
		int E = Integer.parseInt(st.nextToken());//간선의 개수
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());//시작 정점
		
		int[] result = new int[V+1];
		boolean[] visited = new boolean[V+1];
		
		Arrays.fill(result, Integer.MAX_VALUE);
		result[start] = 0;//시작 정점 0으로 처리
		
		List<LinkedList<Integer>> node = new LinkedList<Integer>();
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			n
		}
		
		int min, minIdx = -1;
		PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.weight - o2.weight;
			}

		});
		
		queue.offer(new Node(start, 0, node[start].to));
		
		while(!queue.isEmpty()) {
			Node vertex = queue.poll();
			
			min = Integer.MAX_VALUE;
			
			//최단 경로 찾음
			for (int j = 1; j <= V; j++) {
				if(!visited[j] && min > result[j]) {
					min = result[j];
					minIdx = j;
				}
			}
			
			visited[minIdx] = true;
			
			
		}
		
		for(int i = 1; i <= V; i++) {
			if(result[i] != Integer.MAX_VALUE)
				System.out.println(result[i]);
			else
				System.out.println("INF");
		}
		
	}//end of main
	
}*/
