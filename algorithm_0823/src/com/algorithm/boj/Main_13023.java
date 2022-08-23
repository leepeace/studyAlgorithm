package com.algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_13023 {
	
	private static int N;
	private static boolean[] visited;
	private static int M;
	private static ArrayList<Integer>[] friends;
	private static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());//사람의 수
		M = Integer.parseInt(st.nextToken());//친구 관계의 수
		
		friends = new ArrayList[N];
		visited = new boolean[N+1];
		
		for(int i = 0; i < N; i++)
			friends[i] = new ArrayList<Integer>();
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			//양방향
			friends[from].add(to);
			friends[to].add(from);
		}
		
		
		//모든 정점에 대해 탐색 
		for(int i = 0; i < N; i++) {
			if(result == 1) break;
			visited[i] = true;
			dfs(i,0);
		}
		
		System.out.println(result);
	}
	
	//[0]->1
	//[1]->0,2
	//[2]->1,3
	//[3]->2,4
	//(from, to)
	private static void dfs(int start, int count) {
		if(count >= 4) {
			//친구 관계가 존재하는 경우
			result = 1;
			return;
		}
				
		for(int i = 0; i < friends[start].size(); i++) {
			if(!visited[friends[start].get(i)]) {
				visited[friends[start].get(i)] = true;
				dfs(friends[start].get(i), count+1);
				visited[friends[start].get(i)] = false;
			}
		}	
		return;
	}
	
	
}
