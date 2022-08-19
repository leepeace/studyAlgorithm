package com.algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//ȸ�翡�� ����ؼ� �̵��� ��� �湮�ϰ� ���� ���ư��� ��� �� �� �̵��Ÿ��� ���� ª�� ��θ� ã�� ���α׷�
public class Solution_1247 {
	private static boolean[] visited;//�湮���� Ȯ��
	private static int N;//���� ��
	private static Coordinate[] customer;//N���� ���� ��ǥ
	//private static int result = 0;//�����
	private static Coordinate home;//���� ��ǥ
	private static Coordinate company;//ȸ���� ��ǥ
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			//ȸ���� ��ǥ,���� ��ǥ, N���� ���� ��ǥ
			company = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			customer = new Coordinate[N];
			
			for (int i = 0; i < N; i++) {
				customer[i] = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			visited = new boolean[N];
			int result = Integer.MAX_VALUE;
			
			for(int i = 0; i < N; i++) {
				result = calcMinRoute(i, 1, Math.abs(company.x - customer[i].x) + Math.abs(company.y - customer[i].y), result);
			}			
			
			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}//end of main
	
	static class Coordinate{
		int x;
		int y;
		public Coordinate(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}	
		
	}
	
	//���� ���� �湮�ϸ� �湮ó����
	//�湮���� �ε����� [0~N]
	//�Ķ���ʹ� ���� �湮�� ���°���� ������ �޾ƾ� ��
	//�� �̵� �Ÿ� : ȸ�翡�� ù �� �湮 �� ������ �Ÿ��� ������ + �� ������ �Ÿ� + ������ ���� ���� ���� �� �Ÿ� ����
	//������ �� ���� �湮�� ��� ������ ���� ���� ���� ��ǥ�� ���־� ������� ����
	
	/**
	 * @param start ��� �湮 �����ε���
	 * @param count �̵�Ƚ��
	 * @param route ������
	 * @param result �����
	 * @return
	 */
	private static int calcMinRoute(int start, int count, int route, int result) {
	
		if(count == N) {
			result = Math.min(result, route + Math.abs(home.x-customer[start].x) + Math.abs(home.y-customer[start].y));
		}
		
		visited[start] = true;
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				result = calcMinRoute(i, count+1, route+Math.abs(customer[i].x - customer[start].x) + Math.abs(customer[i].y - customer[start].y), result);				
			}
		}
		
		visited[start] = false;
		return result;
	}
	
}
