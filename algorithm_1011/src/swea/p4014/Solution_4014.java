package swea.p4014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * swea 4014 활주로 건설
 * */
public class Solution_4014 {
	static int N,X;
	private static int[][] maps;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();		
		StringTokenizer st = null;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			maps = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					maps[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(maps[i][j] + " ");
				}				
				System.out.println();
			}
			solve();
			sb.append(String.format("#%d %d\n", tc, 0));
		}
		System.out.println(sb);
	}
	
	static void solve() {
		int result = calcRow();
	}
	
	//3 2 2 3과 같은 경우도 고려하기
	static int calcRow() {
		
		int rowCnt = 0;
		boolean[][] visited = new boolean[N][N];//건설하면 true
		
		for (int r = 0; r < N; r++) {
			boolean flag = false;
			for (int c = 0; c < N-1; c++) {
				int now = maps[r][c];
				int next = maps[r][c+1];
				
				if(now == next) continue;
				if(Math.abs(now-next) >= 2) break;
				
				if(now > next) {//오른쪽에 건설
					int rightCnt = 0;
					for (int i = c+1; i < N; i++) {
						if(visited[r][i]) break;
						if(next == maps[r][i]) {
							visited[r][i] = true;
							rightCnt++;
						}
					}
					if(rightCnt >= X) flag = true;
				}else {//왼쪽에 건설
					int leftCnt = 0;
					for (int i = c; i > 0; i--) {
						if(visited[r][i]) break;
						if(now == maps[r][i]) {
							visited[r][i] = true;
							leftCnt++;
						}
					}
					if(leftCnt >= X) flag = true;
				}
			}
			if(flag) rowCnt++;
		}
		return rowCnt;
	}
	
	static int calcCol() {
		int colCnt = 0;
		
		for (int c = 0; c < N; c++) {
			boolean flag = false;
			for (int r = 0; r < N-1; r++) {
				int now = maps[r][c];
				int next = maps[r+1][c];
				
				if(now == next) continue;
				if(Math.abs(now-next) >= 2) break;
				
			}
		}
		
		return colCnt;
	}
	
}
