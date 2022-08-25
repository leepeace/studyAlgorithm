package sw_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*헌터 */
public class Solution_02 {

	private static boolean[][] visited;
	private static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};//상하좌우

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] map = new int[N][N];
			visited = new boolean[N][N];
			
			
			StringTokenizer st = null;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
		}
	}
	
	private static void dfs() {
		
	}
	
}
