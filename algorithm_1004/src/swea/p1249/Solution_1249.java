package swea.p1249;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * swea 1249 보급로
 * 최단 경로(출발지->도착지의 경로)
 * 1. 가중치가 있는지 확인
 * 	1-1.(가중치가 없음 : BFS)
 * 	1-2.  가중치가 있음 : bfs도 가능함 -> 음가중치, 양가중치 : 다익스트라
 * 최단 경로->그래프 문제
 * 따라서, 2차원 배열 하나의 셀이 정점을 의미함, 4방향 이동이 간선을 의미하게 됨
 * 간선 가중치 : 최소 깊이
 * 너비가 짧더라도 더 비용이 작다는 것은 아니므로 
 * 방문체크를 true/false가 아닌 int[][] 배열로 관리한다.=>출발지에서 해당 정점까지의 최소 배용을 관리함
 * 도착지에 도착했다고 큐를 끝내면 안됨->비용상의 최적이 아닐 수 있으므로, 큐가 비어질때까지 탐색해본다.
 * bfs + pQ
 * 이 문제는 희소그래프(정점10000개, 간선 : 한 정점당 4개)
 * 희소 그래프 : 다익스트라 + PQ
 * */
public class Solution_1249 {
	private static int N;
	private static int[][] maps;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());

			maps = new int[N][N];

			for (int i = 0; i < N; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < N; j++) {
					maps[i][j] = tmp.charAt(j) - '0';
				}
			}

			sb.append(String.format("#%d %d\n", test_case, dijkstra(0, 0)));
		}
		System.out.println(sb.toString());
	}

	static int INF = Integer.MAX_VALUE;
	static int[] dr = { 1, 0, 0, -1 };
	static int[] dc = { 0, -1, 1, 0 };

	static int dijkstra(int startR, int startC) {
		// 출발지에서 자신으로의 최소 비용을 저장할 배열 생성 후 초기화
		int[][] minCost = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				minCost[i][j] = INF;
			}
		}

		boolean[][] visited = new boolean[N][N];

		// 출발지에서 출발지로의 최소 비용 0 처리
		minCost[startR][startC] = 0;
		int r = 0, c = 0, nr = 0, nc = 0, minTime = 0;

		r = c = -1;
		while (true) {
			// step1. 미방문 정점 중 최소 비용 정점 찾기
			minTime = INF;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && minTime > minCost[i][j]) {
						minTime = minCost[i][j];
						r = i;
						c = j;
					}
				}
			}

			// r=c=-1인 경우 더 이상 갈 수 있는 정점이 없다
			if (r == -1)
				return -1;

			visited[r][c] = true;
			if (r == N - 1 && c == N - 1)
				return minTime;// 도착지 도착

			// step2. 현재 정점 기준으로 인접한 정점을 들여다보며 경유 비용이 유리한지 계산
			for (int d = 0; d < 4; d++) {// 인접 정점 : 4방
				nr = r + dr[d];
				nc = c + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]
						&& minCost[nr][nc] > minTime + maps[nr][nc]) {
					minCost[nr][nc] = minTime + maps[nr][nc];
				}
			}
		}

	}

	static int solve2(int startR, int startC) {
		// int[] : {r, c, minTime}
		PriorityQueue<int[]> pQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];// minTime 오름차순
			}
		});

		// 출발지에서 자신으로의 최소 비용을 저장할 배열 생성 후 초기화
		int[][] minCost = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				minCost[i][j] = INF;
			}
		}

		boolean[][] visited = new boolean[N][N];

		// 출발지에서 출발지로의 최소 비용 0 처리
		minCost[startR][startC] = 0;
		pQueue.offer(new int[] { startR, startC, minCost[startR][startC] });

		int r = 0, c = 0, nr = 0, nc = 0, minTime = 0;

		r = c = -1;
		while (!pQueue.isEmpty()) {
			// step1. 미방문 정점 중 최소 비용 정점 찾기
			int[] current = pQueue.poll();
			r = current[0];
			c = current[1];
			minTime = current[2];

			if(visited[r][c]) continue;//처리된 정점이면 다음 정점을 뽑으러 감
			
			visited[r][c] = true;
			if (r == N - 1 && c == N - 1) return minTime;// 도착지 도착

			// step2. 현재 정점 기준으로 인접한 정점을 들여다보며 경유 비용이 유리한지 계산
			for (int d = 0; d < 4; d++) {// 인접 정점 : 4방
				nr = r + dr[d];
				nc = c + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]
						&& minCost[nr][nc] > minTime + maps[nr][nc]) {
					minCost[nr][nc] = minTime + maps[nr][nc];
					pQueue.offer(new int[] { nr, nc, minCost[nr][nc] });
				}
			}
		}
		return -1;
	}

}
