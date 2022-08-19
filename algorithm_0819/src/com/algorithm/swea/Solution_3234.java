package com.algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * ���� : SWEA ��ȯ���� ��������
 * ���� : ������ ���� �ö� �ִ� ������ ������ ���ʿ� �ö� �ִ� ������ ���պ��� �� Ŀ������ �� �ȴ�.
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
	
	//�������(������ ����� ����)
	//������ ������ ���� < ���� ������ ����
	//�������� ������ �����ϴ� ��� ����� �� +1
	private static int searchCase(int count, int leftSum, int rightSum, int[] weight, int result, boolean[] visited, int N) {

		if(count == N) {
			if(rightSum <= leftSum) {
				result++;
			}
			return result;	
		}
	
		for (int i = 1; i <= N; i++) {
			if(visited[i] || rightSum > leftSum) continue;//�̹� �湮�� ���

			visited[i] = true;
		
			//���� �� ������ ����
			result = searchCase(count+1, leftSum, rightSum+weight[i], weight, result, visited, N);
			result = searchCase(count+1, leftSum+weight[i], rightSum, weight, result, visited, N);

			
			//����ߴ� ���� ���� ���� �ǵ�����
			visited[i] = false;
		}
		return result;
	}
	
}
