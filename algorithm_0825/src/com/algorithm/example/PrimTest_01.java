package com.algorithm.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PrimTest_01 {
	
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
		
		//다른 방법 : 0을 무조건 신장트리에 포함시킨 다음 업데이트를 시킬 수 있는 값을 업데이트시킬 수 있음
		//아래 방법은 0번을 신장트리에 포함 안시킨 상태에서 시작하다. 
		
		for (int c = 0; c < V; c++) {//V개의 정점 처리하면 끝
			//step1. 신장트리의 구성에 포함되지 않은 정점 중 최소 비용 정점 선택
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			for (int i = 0; i < V; i++) {
				//방문하지 않은 경우는 아직 신장트리 구성에 포함되지 않았다는 소리
				if(!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;//최소 비용 정점 번호 저장
				}
			}
			
			//step2. 신장트리에 추가
			visited[minVertex] = true;
			result += min;
			
			//step3. 신장트리에 새롭게 추가되는 정점과 신장트리에 포함되지 않은 정점들의 기존 최소 비용과 비교해서 갱신
			//신장트리에 새롭게 추가되는 정점의 모든 인접 정점을 들여다보며 처리
			for(Node temp = adjList[minVertex]; temp != null; temp = temp.next) {
				if(!visited[temp.vertex] && minEdge[temp.vertex] > temp.weight) {
					minEdge[temp.vertex] = temp.weight;
				}
			}
			
		}
		System.out.println(result);
	}
}
