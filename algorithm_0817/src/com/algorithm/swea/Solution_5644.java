package com.algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ���� ���� : �ùķ��̼� + �ߺ�����(or �ߺ� ����)
 * */
public class Solution_5644 {
	
	private static int[] dx = {0, 0, 1, 0, -1};//�̵����� ����, �������
	private static int[] dy = {0, -1, 0, 1, 0};
	private static int M;
	private static int[] A;
	private static int[] B;
	private static int[] sumA;
	private static int[] sumB;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());//�� �̵� �ð�
			int BC =  Integer.parseInt(st.nextToken());//BC�� ����
			
			//�����A�� ������ (1, 1) ��������, �����B�� ������ (10, 10) �������� ���
			A = new int[M];//�����A�� �̵� ����
			B = new int[M];//����� B�� �̵� ����
			
			//0->�̵����� ����, 1->up, 2->right, 3->down, 4->left
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			sumA = new int[M];
			sumB = new int[M];
			
			int size = 10;
			
			
			BatteryCharge[] battery = new BatteryCharge[BC];
			for (int i = 0; i < BC; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				battery[i] = new BatteryCharge(x, y, c, p);
			}
			moveAxy(battery);
			for (int i = 0; i < M; i++) {
				System.out.print(sumA[i] +" ");
			}
			System.out.println();
			//moveBxy(battery);
			for (int i = 0; i < M; i++) {
				System.out.print(sumB[i] +" ");
			}
			
			int result = 0;
			for (int i = 0; i < M; i++) {
				result += sumA[i] + sumB[i];
			}
			
			System.out.println("#" + test_case + " " + result);
		}//end of testcase
		
	}//end of main
	
	static class BatteryCharge{
		//��ǥ(X, Y), ���� ����(C), ó����(P)
		int x;
		int y;
		int c;
		int p;
		
		public BatteryCharge(int x, int y, int c, int p) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}

		public BatteryCharge(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		
		
	}//end of BatteryCharge Class
	
	//���� ������ �ش��ϴ� ��� BC�� �켱���� ť�� �־���
	//��ǥ�� �����ؼ� ������ ��?
	private static void moveAxy(BatteryCharge[] battery) {
		//������� �̵� ������ ���� �̵��Ѵ�.
		//����ڴ� ���������� �̵��� �� ����.
		//���� ������ �� ���� ������ �Ÿ��� ���Ѵ�. 
		//���� ���͸��� ���� ������ ����ڰ� �θ��� �ִ� ��� �������� �й�
		//���� �� ������� ��ġ���� BC�� ���������� ��ġ�� ��� �� ������ ����
		
		
		int size = 10;
		int Ax = 1, Ay = 1;//A����� ��� ��ġ
		int Bx = 10, By = 10;//B����� ��� ��ġ
		for(int i = 0; i < M; i++) {
			int moveAx = Ax + dx[A[i]];
			int moveAy = Ay + dy[A[i]];
			
			int moveBx = Bx + dx[B[i]];
			int moveBy = By + dy[B[i]];
			
			int temp = 0;
			for (int j = 0; j < battery.length; j++) {
				int distance = Math.abs(moveAx - battery[j].x) + Math.abs(moveAy - battery[j].y);
				if(distance <= battery[j].c) {
					temp = Math.max(temp, battery[j].p);
				}
			}
			sumA[i] = temp; sumB[i] = temp;
			
			Ax = moveAx;
			Ay = moveAy;
			Bx = moveBx;
			By = moveBy;
			//vistiedAxy[i] = new BatteryCharge(Ax, Ay);
		}
		
	}//end of moveAxy
	
	
	
	private static void moveBxy(BatteryCharge[] battery) {
		
		int size = 10;
		int Bx = 10, By = 10;//B����� ��� ��ġ
		for(int i = 0; i < M; i++) {
			int moveBx = Bx + dx[B[i]];
			int moveBy = By + dy[B[i]];
			
			if(moveBx < 0 || moveBy < 0 || moveBx > size || moveBy > size) continue;
			
			//�������� ������ ������, BC ���� �ȿ� ���� ���
			//A�� ��ǥ�� 20�� �����ؾ� �ϳ�??
			//A�� B�� BC�ȿ� ������ ��ġ�� ��쿡�� �������� �й��ϰų�
			//BC�� ��ġ�� ������ ��쿡�� �� �� �ϳ��� �����ؼ� �ִ��� ����
			
			int temp = 0;
			for (int j = 0; j < battery.length; j++) {
				int distance = Math.abs(moveBx - battery[j].x) + Math.abs(moveBy - battery[j].y);
				if(distance <= battery[j].c) {
					temp = Math.max(temp, battery[j].p);
				}
			}
			
			sumB[i] = temp;
			
			
		}
		
	}
	
	
}
