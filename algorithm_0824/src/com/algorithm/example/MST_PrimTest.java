package com.algorithm.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//mst 알고리즘
public class MST_PrimTest {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());//정점의 개수
		
		StringTokenizer st = null;
		
		int[][] adjMatrix = new int[N][N];//인접 행렬을 저장할 2차원 배열
		int[] minEdge = new int[N];//다른 정점에서 자신으로의 간선 비용 중 최소 비용 저장
		boolean[] visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE;//최댓값으로 초기화
		}//입력 끝
		
		
		//다른 정점에서 자신으로 연결하는 간선비용 최솟값을 저장
		//update를 하며 간선비용 최솟값을 구한다.
		//이미 최소비용으로 간선이 fix된 노드는 true로 처리
		
		int result = 0;
		
		//1. 임의의 시작점 0으로 정하고 시작
		minEdge[0] = 0;
		
		//2. N개의 정점을 모두 연결하기 위해 N만큼 반복
		for (int c = 0; c < N; c++) {//N개의 정점을 모두 연결하기 위함 
			int min = Integer.MAX_VALUE;//최솟값을 찾아야 하므로 max값 넣고 시작함
			int minVertex = 0;//가장 작은 비용을 갖는 정점의 번호
			
			for (int i = 0; i < N; i++) {
				//신장트리에 포함되지 않고, 다른 정점에서 나에게로 연결된 최소 비용이 임시 최솟값보다 작은 경우 업데이트
				if(!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				}
			}
			
			//3. 선택된 정점을 신장트리에 포함시키기 
			visited[minVertex] = true;
			result += min;
			
			//4. 선택된 정점을 기준으로 최소신장트리에 포함되지 않은 다른 정점으로의 간선 비용을 따져보고 최솟값 갱신
			for (int l = 0; l < N; l++) {
				if(!visited[l] && adjMatrix[minVertex][l] != 0 && minEdge[l] > adjMatrix[minVertex][l]) {
					minEdge[l] = adjMatrix[minVertex][l];
				}
			}
		}
		System.out.println(result);
	}
	
	
}
