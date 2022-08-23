package com.algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 문제 : 백준 16236 아기상어
 * 
 * */
public class Main_16236 {
	
	//상하좌우
	private static int[] dr = {-1,1,0,0};
	private static int[] dc = {0,0,-1,1};
	
	private static boolean[][] visited;
	private static Queue<int[]> queue;
	private static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());//공간의 크기
		
		map = new int[N][N];
		visited = new boolean[N][N];
		queue = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {//아기상어의 위치 좌표
					queue.add(new int[] {i,j});
					visited[i][j] = true;
				}
			}
		}//입력 끝 
		
	}//end of main
	

	//더 이상 먹을 수 있는 물고기가 공간에 없다면 종료->큐가 비어있는 경우
	//bfs로 탐색하며, 먹을 수 있는 물고기를 발견한 경우 카운트
	//카운트가 1인 경우 
	private static void eatFish(int N) {
		int sharkSize = 2;//아기상어 크기 
		int min = Integer.MAX_VALUE;
		
		Queue<int[]> minDistance = new LinkedList<>();//거리가 가까운 물고기 좌표 저장
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int nowX = temp[0];//현재 x 좌표
			int nowY = temp[1];//현재 y 좌표
			
			int nextX = 0, nextY = 0;//이동할 좌표
			for (int i = 0, size = dr.length; i < size; i++) {//4방향 탐색 
				nextX = nowX + dr[i];
				nextY = nowY + dc[i];
				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
				
				if(map[nextX][nextY] > sharkSize) continue;//아기 상어 크기보다 큰 물고기가 있는 칸은 지나갈 수 없음
				
				if(!visited[nextX][nextY]) {
					visited[nextX][nextY] = true;
					if(map[nextX][nextY] < sharkSize && map[nextX][nextY] != 0) {
						minDistance.add(new int[] {nextX, nextY});
					}else {
						queue.add(new int[] {nextX, nextY});
					}
				}
			}
			
			//거리가 가장 작은 물고기를 구함 
			int size = minDistance.size();
			int minX = 0, minY = 0;
			int[] fish = minDistance.poll();
			int fishX = fish[0];
			int fishY = fish[1];
			if(size == 1) {//먹을 수 있는 물고기가 1마리인 경우
				queue.add(new int[] {fishX, fishY});
			}else {
				while(!minDistance.isEmpty()) {
					fish = minDistance.poll();
					fishX = fish[0];
					fishY = fish[1];
					if(min > getDistance(nowX, nowY, fishX, fishY)) {
						minX = fishX;
						minY = fishY;
						min = getDistance(nowX, nowY, fishX, fishY);
					}
				}
				queue.add(new int[] {minX, minY});
			}
			
		}//end of while
		
		System.out.println(min);
	}
	
	private static int getDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2) + Math.abs(y1-y2);
	}
	
}
