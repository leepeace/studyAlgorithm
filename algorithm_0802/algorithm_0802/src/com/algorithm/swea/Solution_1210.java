package com.algorithm.swea;

import java.io.IOException;
import java.util.Scanner;

//SWEA 1210번 Ladder1
//역으로 출발지에서부터 시작해서 도착지를 찾기
public class Solution_1210{

	public static void main(String[] args) throws IOException {
		
		//'1'은 사다리, '2'는 도착지점
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++){
			
			int[][] data = new int[100][100];
			int startCol = 0, startRow = 99;//도착 열,행 위치

			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					data[i][j] = sc.nextInt();
					if(data[i][j] == 2) {
						startCol = j;
					}
				}
			}
		
			int result = 0;
			int[][] dir = {{0, 1}, {0, -1}, {-1, 0}};//우, 좌, 상
			for(int col = startCol; col >= 0; col--) {
				if(startRow == 0) {
					result = startCol;
					break;
				}
				for(int i = 0; i < dir.length; i++) {
					int tempX = startRow + dir[i][0];
					int tempY = startCol + dir[i][1];
					if(tempY < 100 && data[tempX][tempY] == 1) {//오른쪽
						if(data[tempX][tempY] == 1) {
							startRow = tempX;
							startCol = tempY;
						}
					}else if(tempY >= 0 && data[tempX][tempY] == 1) {//왼쪽
						startRow = tempX;
						startCol = tempY;
					}else if(tempX >= 0 && data[tempX][tempY] == 1){//위로 올라감
						startCol = tempY;
						startRow = tempX;
					}
					
				}
			}
			
			System.out.println("#" + test_case + " " + result);
		}//end for
		
		sc.close();
	}

}
