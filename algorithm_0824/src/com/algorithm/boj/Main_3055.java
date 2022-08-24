package com.algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055 {
	
	//상하좌우
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static char[][] map;
	private static int C;
	private static int R;
	private static int[][] waterDepth, animalDepth;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		boolean[][] visited = new boolean[R][C];
 		
		Queue<int[]> queue = new LinkedList<>();
		
		waterDepth = new int[R][C];
		
		int hedgehogX = 0, hedgehogY = 0;
		for (int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = tmp.charAt(j);
				if(map[i][j] == '*') {
					queue.add(new int[] {i,j});
					waterDepth[i][j] = 1;
					visited[i][j] = true;
				}else if(map[i][j] == 'S') {
					hedgehogX = i;
					hedgehogY = j;
				}
			}
		}

		bfs(queue, visited, waterDepth, true);
		
		queue = new LinkedList<>();
		visited = new boolean[R][C];
		animalDepth = new int[R][C];
		
		queue.add(new int[] {hedgehogX, hedgehogY});
		animalDepth[hedgehogX][hedgehogY] = 1;
		visited[hedgehogX][hedgehogY] = true;
		
		
		bfs(queue, visited, animalDepth, false);
	}//end of main
	

	private static void bfs(Queue<int[]> queue, boolean[][] visited, int[][] depth, boolean water) {
		
		int nowX = 0, nowY = 0; 
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			nowX = temp[0];//x좌표
			nowY = temp[1];//y좌표
			
			if(map[nowX][nowY] == 'D' && !water) break;//비버가 도착한 경우
			
			int nextX = 0, nextY = 0;
			
			for(int i = 0, size = dr.length; i < size; i++) {
				nextX = nowX + dr[i];
				nextY = nowY + dc[i];
				
				if(nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) continue;
				
				if(map[nextX][nextY] == 'X') continue;
				if(map[nextX][nextY] == 'D' && water) continue;//물은 비버의 소굴로 이동할 수 없다.
				if(map[nextX][nextY] == '*' && !water) continue;
				
				if(!visited[nextX][nextY]) {
					visited[nextX][nextY] = true;
					depth[nextX][nextY] = depth[nowX][nowY] + 1;
					
					if(!water) {//고슴도치
						//고슴도치가 갈 수 있는 위치인지 고슴도치의 깊이와 물의 깊이와 비교한다.
						if(waterDepth[nextX][nextY] > depth[nextX][nextY] || waterDepth[nextX][nextY] == 0) {
							queue.add(new int[] {nextX, nextY});
						}
					}else {//물인 경우
						queue.add(new int[] {nextX, nextY});
					}
				}
			}
			
		}//end of while
		if(!water) {
			if(map[nowX][nowY] == 'D') {
				System.out.println(depth[nowX][nowY]-1);
			}else {
				System.out.println("KAKTUS");
			}
		}
		
	}
	

}
