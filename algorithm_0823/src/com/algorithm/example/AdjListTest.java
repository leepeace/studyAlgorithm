package com.algorithm.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

//무방향 그래프-인접 리스트
public class AdjListTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//정점 개수
		int V = sc.nextInt();
		//edge의 개수
		int E = sc.nextInt();
		
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		
		adjList.add(new ArrayList<Integer>());
		for(int i = 0; i < V; i++)
			adjList.add(new ArrayList<Integer>());
		
		for(int i = 0; i < E; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			
			//방향이 없는 그래프이므로, 양쪽에 edge가 있다는 것을 구현해야 함
			adjList.get(v1).add(v2);
			adjList.get(v2).add(v1);
		}
		
		for(int i = 1; i <= V; i++) {
			Iterator<Integer> iterator = adjList.get(i).iterator();
			System.out.print("[" + i + "] : ");
			while(iterator.hasNext()) {
				System.out.print(iterator.next() + " ");
			}
			System.out.println();
		}
		
	}
}
