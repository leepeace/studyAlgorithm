package com.algorithm.swea;


import java.io.IOException;
import java.util.Scanner;

public class Solution_1873 {
	
	static int N;
	static char nowDirection;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	
		for(int test_case = 1; test_case <= T; test_case++){
			int H = sc.nextInt();//맵의 높이
			int W = sc.nextInt();//맵의 너비

			char[][] map = new char[W][H];//게임 맵
			
			for(int i = 0; i < H; i++) {
				map[i] = sc.next().toCharArray();
			}
			
			N = sc.nextInt();
			char[] command = new char[N];//사용자가 넣을 수 있는 입력의 종류
			command = sc.next().toCharArray();
			//입력 끝
			
			int tankX = 0, tankY = 0;//전차 위치
			
			for(int i = 0; i < W; i++) {
				for(int j = 0; j < H; j++) {
					if(map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						tankX = i;
						tankY = j;
						nowDirection = map[i][j];
					}
				}
			}
			
			map[tankX][tankY] = '.';
			
			/*
			 * 1. 전차가 이동 시 배열의 범위를 넘어서면 이동하지 않는다.
			 * 2. shoot인 경우, '*', '#'에 닿거나 배열의 범위를 넘어설때까지 직진한다.
			 * 	2-1. 만약 '*'인 경우 '.'이 된다.
			 * 3. shoot이 배열의 범위를 넘어서면 아무런 일도 일어나지 않음;
			 * 
			 * */
			int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};//상, 하, 좌, 우
			char[] tankDirection = {'^', 'v', '<', '>'};//상, 하, 좌, 우
			for(int j = 0; j < command.length; j++) {
				if(command[j] == 'S') {
					int tempX = tankX;
					int tempY = tankY;
					while(true) {
						if(checkMovePossbile(tempX, tempY)) {
							break;
						}
						if(map[tempX][tempY] == '#') {//강철벽 만난 경우
							break;
						}
						if(map[tempX][tempY] == '*') {
							map[tempX][tempY] = '.';
							break;
						}
						for(int i = 0; i < tankDirection.length; i++) {
							if(nowDirection == tankDirection[i]) {
								tempX += delta[i][0];
								tempY += delta[i][1];
							}
						}
						tankX = tempX;
						tankY = tempY;
					}	
				}else if(command[j] == 'U'){
					nowDirection = '^';
					if(map[tankX -1][tankY] == '.' && checkMovePossbile(tankX-1, tankY)) {
						map[tankX][tankY] = '.';
						tankX = tankX - 1;
					}
				}else if(command[j] == 'D') {
					nowDirection = 'v';
					if(map[tankX+1][tankY] == '.' && checkMovePossbile(tankX+1, tankY)) {
						map[tankX][tankY] = '.';
						tankX = tankX + 1;
					}
				}else if(command[j] == 'L') {
					nowDirection = '<';
					if(map[tankX][tankY-1] == '.' && checkMovePossbile(tankX, tankY-1)) {
						map[tankX][tankY] = '.';
						tankY = tankY - 1;
					}
				}else if(command[j] == 'R') {
					nowDirection = '>';
					if(map[tankX][tankY+1] == '.' && checkMovePossbile(tankX, tankY+1)) {
						map[tankX][tankY] = '.';
						tankY = tankY + 1;
					}
				}
			}					

			map[tankX][tankY] = nowDirection;
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}//end for
	}
	
	//움직이려는 이동이 배열의 범위를 넘어서는지 확인함
	public static boolean checkMovePossbile(int moveX, int moveY) {
		if(moveX >= 0 && moveY < N && moveY >= 0 && moveY < N) {
			return true;
		}
		return false;
	}
	

	
}
