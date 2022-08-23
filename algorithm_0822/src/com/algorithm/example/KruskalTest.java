package com.algorithm.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class KruskalTest {
	
	//간선 정보 저장
	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			//return Integer.compare(this.weight, o.weight);
			return this.weight - o.weight;
		}
		
	}
	
	static int[] parents;//부모 인덱스
	static int V,E;//정점 개수, 간선 개수
	static Edge[] edgeList;//간선 리스트
	
	static void make() {//크기가 1인 서로소 집합 생성
		parents = new int[V];
		
		for (int i = 0; i < V; i++) {//모든 노드가 자신을 부모로 하는 (대표자)
			parents[i] = i;
		}
	}
	
	static int find(int a) {//a의 대표자 찾기
		if(parents[a] == a) {//나의 부모가 곧 나인 경우(내가 대표자)
			return a;
		}
		
		//우리의 대표자를 나의 부모로 바꾼다. : path compression
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {//리턴값 : true=>union 성공
		 int aRoot = find(a);
		 int bRoot = find(b);
		 
		 if(aRoot == bRoot) return false;
		 
		 parents[bRoot] = aRoot;
		 return true;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		edgeList = new Edge[E];
		
		for (int i = 0; i < E; i++) {
			 st = new StringTokenizer(br.readLine(), " ");
			 edgeList[i] = new Edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));	
		}
		
		make();
		
		Arrays.sort(edgeList);//간선 기준 오름차순
		
		int result = 0;
		int count = 0;
		
		for (Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {//union에 성공하면
				result += edge.weight;//가중치 비용 누적
				if(++count == V-1) break;//count가 간선개수  N-1개가 되면
			}	
		}
		
		System.out.println(result);
	}//end of main
	
}
