package com.algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 문제 : 백준 1697 숨바꼭질
 * 조건 : 걷는다면 X-1 또는 X+1로 이동, 순간이동을 하는 경우에는 2*X의 위치 이동
 * 접근 유형 : bfs
 * */
public class Main_1697_이해민 {

	static class Coordinate{
		int x;
		int count;
		
		public Coordinate(int x, int count) {
			super();
			this.x = x;
			this.count = count;
		}
	}
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());//수빈이가 있는 위치
		int K = Integer.parseInt(st.nextToken());//동생이 있는 위치
		boolean[] visited = new boolean[100001];
		
		int result = Integer.MAX_VALUE;
		int count = 0;
		Queue<Coordinate> queue = new LinkedList<Coordinate>();
		//초기값 셋팅
		queue.offer(new Coordinate(N, count));
		visited[N] = true;
		
		//최단 거리를 구해야 함
		//수빈이가 이동하는 점을 큐에 넣는다.
		//순서대로 -1,1,*2에 대해서 해보자.이동한 점이 동생이 있는 점과 같다면 끝이나고, Math.min을 구해보기
		//bfs로 풀어보자
		while(!queue.isEmpty()) {
			Coordinate location = queue.poll();//현위치

			count = location.count;
			
			if(location.x == K) {
				result = Math.min(result, location.count);
				break;
			}
			
			if(location.x - 1 >= 0 && !visited[location.x - 1]) {
				queue.offer(new Coordinate(location.x - 1, count+1));
				visited[location.x-1] = true;
			}
			if(location.x + 1 <= 100000 && !visited[location.x + 1]) {
				queue.offer(new Coordinate(location.x + 1, count+1));
				visited[location.x+1] = true;
			}
			if(location.x * 2 <= 100000 && !visited[location.x * 2]) {
				queue.offer(new Coordinate(location.x * 2, count+1));
				visited[location.x * 2] = true;
			}
			
		}
		
		
		System.out.println(result);
	}


	
}
