package com.algorithm.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 간선의 최대개수는 (V-1)*V/2으로 나타낼수있고 
 * log(V^2/2)는 로그법칙에 의해 1/2*log(V)로 뺄수 있음
 * */
public class PrimTest_02 {
	
	static class Node{
		int vertex, weight;
		Node next;
		
		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
		
	}
	
	static class Vertex{
		int no, weight;

		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}
	
	}
	
	//완전그래프에 가까우면 인접리스트나 인접행렬은 차이가 없다
	//그러나, E < V^2의 경우에는 차이가 생긴다.
	//인접리스트 : O(V^2+E), V^2 + step3 E번
	//인접행렬 : O(2V^2) step1 V번 * step3 V번
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
	
		Node[] adjList = new Node[V];//각 정점별 인접리스트
		
		for (int i = 0; i < E; i++) {
			st  = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
		
			//무향처리
			adjList[from] = new Node(to, weight, adjList[from]);
			adjList[to] = new Node(from, weight, adjList[to]);
		}
		
		//프림 알고리즘에 필요한 자료 구조
		int[] minEdge = new int[V];//각 정점 입장에서 신장트리에 포함된 정점과의 간선 비용 중 최소 비용
		boolean[] visited = new boolean[V];//신장 트리에 포함 여부
		
		Arrays.fill(minEdge, Integer.MAX_VALUE);//최소값 관리하기 위해 큰 값 세팅
		
		//1. 임의의 시작점 처리, 0번 정점을 신장 트리의 구성의 시작점
		minEdge[0] = 0;
		int result = 0;//최소 신장 트리 비용 누적
		
		////////////////추가/////////////////////
		//간선이 작은 순서대로 나오게 함
		PriorityQueue<Vertex> pQueue = new PriorityQueue<>((v1, v2)->v1.weight - v2.weight);
		pQueue.offer(new Vertex(0, minEdge[0]));
		
		int cnt = 0;//신장트리에 추가된 정점 수
		while(true) {//V개의 정점 처리하면 끝
			//step1. 신장트리의 구성에 포함되지 않은 정점 중 최소 비용 정점 선택
			Vertex minVertex = pQueue.poll();
			
			//먼저 처리된 정점은 비용이 더 유리하므로
			if(visited[minVertex.no]) continue;
			
			//step2. 신장트리에 추가
			visited[minVertex.no] = true;
			result += minVertex.weight;
			if(++cnt == V) break;
			
			//step3. 신장트리에 새롭게 추가되는 정점과 신장트리에 포함되지 않은 정점들의 기존 최소 비용과 비교해서 갱신
			//신장트리에 새롭게 추가되는 정점의 모든 인접 정점을 들여다보며 처리
			for(Node temp = adjList[minVertex.no]; temp != null; temp = temp.next) {
				if(!visited[temp.vertex] && minEdge[temp.vertex] > temp.weight) {
					minEdge[temp.vertex] = temp.weight;
					pQueue.offer(new Vertex(temp.vertex, minEdge[temp.vertex]));
				}
			}
			
		}
		System.out.println(result);
	}
}
