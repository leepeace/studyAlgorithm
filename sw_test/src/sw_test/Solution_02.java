package sw_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*헌터 */
public class Solution_02 {

	private static boolean[] visited;
	private static int N;
	private static ArrayList<Pair> location;
	private static int size;
	private static int result;

	static class Pair implements Comparable<Pair>{
		int x;
		int y;
		int num;//몬스터인지, 고객인지 
		
		public Pair(int x, int y, int num) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
		}

		@Override
		public int compareTo(Pair o) {
			if(Math.abs(this.num) == Math.abs(o.num)) 
				return this.num - o.num;
			else
				return this.num - o.num;
		}
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			result = Integer.MAX_VALUE;
			location = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					if(tmp != 0) {
						location.add(new Pair(i, j, tmp));
					}
				}
			}
			
			//1. 몬스터와 고객의 집 위치를 전부 하나의 배열에 저장함, 이후 배열에 대해 번호 기준으로 정렬함
			//2. dfs를 통해 모든 경우의 수에 대해 탐색함
			//3. return 시 맨해튼 거리
			
			Collections.sort(location);
			
			size = location.size();
			visited = new boolean[size+1];
			
			dfs(0, 0, 0, 0);
		
			System.out.println("#" + test_case + " " + result);
		}
	}//end of main
	
	private static void dfs(int depth, int row, int col, int sum) {
		if(depth == location.size()) {
			//결과값 갱신
			result = Math.min(result, sum);
			return;
		}
		
		for (int i = 0; i < size; i++) {
			//방문했거나 || 먼저 몬스터를 방문하지 않고, 고객을 방문한 경우
			if(visited[i] || (i % 2 == 0 && !visited[i+1])) continue;
			
			Pair now = location.get(i);
			visited[i] = true;
			dfs(depth+1, now.x, now.y, sum + getDistance(now.x, now.y, row, col));
			visited[i] = false;
		}
		
	}
	
	private static int getDistance(int startX, int startY, int endX, int endY) {
		return Math.abs(startX - endX) + Math.abs(startY - endY);
	}
	
}