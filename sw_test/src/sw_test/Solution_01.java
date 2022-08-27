package sw_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_01 {

	private static boolean[] visited;
	private static int N;
	private static int[][] entrance_order;//출입구 순서(순열)
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());//낚시터의 개수
			
			int size = 3;
			int[] entrance = new int[N+1];
			visited = new boolean[N+1];
			entrance_order = new int[7][size+1];
			
			
			StringTokenizer st = null;
			for (int i = 1; i < size+1; i++) {
				st = new StringTokenizer(br.readLine());
				int location = Integer.parseInt(st.nextToken());//출입구의 위치
				entrance[location] = Integer.parseInt(st.nextToken());//해당 출입구에 대기하고 있는 낚시꾼들의 수
			}
			
			for (int i = 1; i < N+1; i++) {
				if(entrance[i] != 0)
					dfs(i, entrance[i], 0);
			}
			
			sb.append("#").append(test_case).append(" ").append(0).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	//갈 수 있는 방향에 대해 전부 가보고 이동거리를 구해본다.
	private static void dfs(int entry, int man, int sum) {
		
		for (int i = 1; i < N+1; i++) {
			
		}
	}

	
	
}