package com.algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_14621 {
	
	private static boolean[] visited;
	private static int N;
	private static char[] gender;
	private static Node[] node;
	private static int[] parents;
	
	static class Node implements Comparable<Node>{
		int to;
		int weight;
		
		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());//학교의 수
		int M = Integer.parseInt(st.nextToken());//도로의 개수
		
		visited = new boolean[N+1];
		gender = new char[N+1];
		
		node = new Node[N+1];
		
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			gender[i] = st.nextToken().charAt(0);
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			node[from] = new Node(to, d);
		}
		
		make();
		
		Arrays.sort(node);
		
		//visitUniversity(1, 0, gender[1], 0);
		visitUniversity();
		
		//System.out.println(result);
	}//end of main
	
	
	private static void visitUniversity(){
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(1, 0));//1번 정점에서 시작
		
		int count = 0, sum=0;
		while(!queue.isEmpty()) {
			if(count >= N-1) break;
			
			Node now = queue.poll();
			
			if(visited[now.to]) continue;
			
			visited[now.to] = true;
			
			for(int i = 1; i < N+1; i++) {
				if(!visited[i] && gender[now.to] != gender[i] && union(now.to, node[i].to)) {
					queue.add(new Node(node[i].to, node[i].weight + sum));
				}
			}
		}
		System.out.println(sum);
	}
	
	private static void make() {
		parents = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int data) {
		if(parents[data] == data) {
			return data;
		}
		return parents[data] = find(parents[data]);
	}
	
	private static boolean union(int a, int b) {
		int a_root = find(a);
		int b_root = find(b);
		
		if(a_root == b_root) return false;
		
		parents[b_root] = a_root;
		return true;
	}
	
	
	
}
