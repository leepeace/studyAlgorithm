package com.algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문제 : SWEA 준환이의 양팔저울
 * 조건 : 오른쪽 위에 올라가 있는 무게의 총합이 왼쪽에 올라가 있는 무게의 총합보다 더 커져서는 안 된다.
*/
public class Solution_3234 {
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] weight = new int[N+1];
			boolean[] visited = new boolean[N+1];
						
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
		
			int result = searchCase(0, 0, 0, weight, 0, visited, N);
			
			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}//end of test case
		
		System.out.println(sb.toString());
	}//end of main class
	
	//순열사용(순서가 상관이 있음)
	//오른쪽 무게의 총합 < 왼쪽 무게의 총합
	//비교했을때 조건을 충족하는 경우 경우의 수 +1
	private static int searchCase(int count, int leftSum, int rightSum, int[] weight, int result, boolean[] visited, int N) {

		if(count == N) {
			if(rightSum <= leftSum) {
				result++;
			}
			return result;	
		}
	
		for (int i = 1; i <= N; i++) {
			if(visited[i] || rightSum > leftSum) continue;//이미 방문한 경우

			visited[i] = true;
		
			//다음 수 뽑으러 가기
			result = searchCase(count+1, leftSum, rightSum+weight[i], weight, result, visited, N);
			result = searchCase(count+1, leftSum+weight[i], rightSum, weight, result, visited, N);

			
			//사용했던 수에 대한 선택 되돌리기
			visited[i] = false;
		}
		
		
		
		return result;
	}
	
}
