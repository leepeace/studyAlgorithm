package com.algorithm.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16935 {
	static int N;
	static int M;
	static int[][] num;
	static int[][] temp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		//조건 : N, M은 짝수
		N = Integer.parseInt(tokens.nextToken());//행
		M = Integer.parseInt(tokens.nextToken());//열
		int R = Integer.parseInt(tokens.nextToken());//연산의 수
		
		num = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				num[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		tokens = new StringTokenizer(br.readLine());

		
		for(int l = 0; l < R; l++) {
			int mode = Integer.parseInt(tokens.nextToken());
			
			if(mode == 1) {//상하 반전
				operation1();			
			}else if(mode == 2) {//좌우 반전
				operation2();
			}else if(mode == 3) {//오른쪽으로 90도 회전
				operation3();
			}else if(mode == 4) {//왼쪽으로 90도 회전
				operation4();
			}else if(mode == 5) {
				operation5();
			}else {
				operation6();
			}
			
			//System.out.println("--------------");
		}//end for
		
		print(num);
		
	}
	
	private static void print(int[][] printArray) {
		for(int i = 0; i < printArray.length; i++) {
			for(int j = 0; j < printArray[i].length; j++) {
				System.out.print(printArray[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static void operation1() {
		int mid = N / 2;
		temp = new int[N][M];
		
		for(int i = 0; i < mid; i++) {
			System.arraycopy(num[i], 0, temp[N-1-i], 0, num[i].length);
			System.arraycopy(num[N-1-i], 0, temp[i], 0, num[i].length);
		}
		//원본배열에 임시배열의 주소값을 넣어줌
		num = temp;
	}
	
	private static void operation2() {
		int mid = M / 2;
		temp = new int[N][M];
		
		for(int i = 0; i < mid; i++) {
			for(int j = 0; j < N; j++) {
				temp[j][i] = num[j][M-1-i];
				temp[j][M-1-i] = num[j][i];
			}
		}
		num = temp;
	}
	
	private static void operation3() {
		temp = new int[M][N];
		
		for(int i = 0; i < M; i++) {
			for(int j = N-1; j >= 0; j--) {
				temp[i][N-1-j] = num[j][i];
			}
		}
		
		//사이즈 조정
		int size = N;
		N = M;
		M = size;
		
		num = temp;
	}
	
	private static void operation4() {
		temp = new int[M][N];
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				temp[i][j] = num[j][M-1-i];
			}
		}
		
		//사이즈 조정
		int size = N;
		N = M;
		M = size;
		
		num = temp;
	}
	
	private static void operation5() {
		temp = new int[N][M];
		
		//1번->2번 그룹 위치 옮김
		for(int i = 0; i < N/2; i++) {
			for(int j = 0; j < M/2; j++) {
				temp[i][M/2 + j] = num[i][j];
			}
		}
		//2번->3번 그룹 위치 옮김
		for(int i = 0; i < N/2; i++) {
			for(int j = M/2; j < M; j++) {
				temp[N/2+i][j] = num[i][j];
			}
		}
		
		//3번->4번 그룹 위치 옮김
		for(int i = N/2; i < N; i++) {
			for(int j = 0; j < M/2; j++) {
				temp[i][j] = num[i][M/2+j];
			}
		}
		
		//4번->1번 그룹 위치 옮김
		for(int i = 0; i < N/2; i++) {
			for(int j = 0; j < M/2; j++) {
				temp[i][j] = num[N/2 + i][j];
			}
		}
		
		num = temp;
	}
	
	private static void operation6() {
		temp = new int[N][M];
		
		//1번->4번 그룹 위치 옮김
		for(int i = 0; i < N/2; i++) {
			for(int j = 0; j < M/2; j++) {
				temp[N/2+i][j] = num[i][j];
			}
		}
		
		//4번->3번 그룹 위치 옮김
		for(int i = N/2; i < N; i++) {
			for(int j = 0; j < M/2; j++) {
				temp[i][M/2+j] = num[i][j];
			}
		}
		
		//3번->2번 그룹 위치 옮김
		for(int i = 0; i < N/2; i++) {
			for(int j = M/2; j < M; j++) {
				temp[i][j] = num[N/2+i][j];
			}
		}
		
		//2번->1번 그룹 위치 옮김
		for(int i = 0; i < N/2; i++) {
			for(int j = 0; j < M/2; j++) {
				temp[i][j] = num[i][M/2+j];
			}
		}
			
		num = temp;
	}
}
