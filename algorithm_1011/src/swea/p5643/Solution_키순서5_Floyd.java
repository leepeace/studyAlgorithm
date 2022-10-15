package swea.p5643;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution_키순서5_Floyd {

	static int N,M,adjMatrix[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine().trim());
		for(int tc=1; tc<=TC; ++tc) {
			N = Integer.parseInt(in.readLine());
			M = Integer.parseInt(in.readLine());
			adjMatrix = new int[N + 1][N + 1];
			
			for (int m = 0; m < M; ++m) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				adjMatrix[i][j] = 1;
			}
			int answer = 0;
			for (int k=1; k<= N; ++k) {// 경유
				for(int i=1; i<=N; ++i) { // 출발
					if(i==k) continue;
					for(int j=1; j<=N; ++j) { // 도착
						if(adjMatrix[i][j]==1) continue;
						adjMatrix[i][j] = adjMatrix[i][k] & adjMatrix[k][j] ; 
					}
				}
			}
			for (int i = 1; i <= N; ++i) {
				for (int j = 1; j <= N; ++j) {
					adjMatrix[i][0] += adjMatrix[i][j]; // i보다 큰 j가 결국 카운트에 누적
					adjMatrix[0][j] += adjMatrix[i][j]; // j보다 작은 i가 결국 카운트에 누적
				}
			}
			for (int k = 1; k <= N; ++k) {
				if (adjMatrix[k][0] + adjMatrix[0][k] == N - 1) answer++;
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}
