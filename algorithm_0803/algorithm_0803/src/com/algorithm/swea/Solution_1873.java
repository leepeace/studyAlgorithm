package com.algorithm.swea;


import java.io.IOException;
import java.util.Scanner;

public class Solution_1873 {
	
	static int N;
	static char nowDirection;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	
		for(int test_case = 1; test_case <= T; test_case++){
			//StringTokenizer st = new StringTokenizer(br.readLine());
			int H = sc.nextInt();//맵의 높이
			int W = sc.nextInt();//맵의 너비

			char[][] map = new char[W][H];//게임 맵
			
			for(int i = 0; i < H; i++) {
				map[i] = sc.next().toCharArray();
			}
			
			N = sc.nextInt();
			char[] direction = new char[N];//사용자가 넣을 수 있는 입력의 종류
			direction = sc.next().toCharArray();
			
			//입력 끝
			

			
			/*
			 * 	U : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
			 *  D  : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
			 *	L : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
			 *	R : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
			 *	S : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
			 * 
			 * */
			/*
			 * 1. 전차가 이동 시 배열의 범위를 넘어서면 이동하지 않는다.
			 * 2. shoot인 경우, '*', '#'에 닿거나 배열의 범위를 넘어설때까지 직진한다.
			 * 	2-1. 만약 '*'인 경우 '.'이 된다.
			 * 3. shoot이 배열의 범위를 넘어서면 아무런 일도 일어나지 않음;
			 * 
			 * */
			int i = 0;
			int nowX = 0, nowY = 0;//현재 위치
			
			while(i < N) {
				switch (direction[i]) {
					case 'U':
						if(checkMove(nowX-1, nowY)) {
							while(map[nowX-1][nowY] == '.') {
								if(!checkMove(nowX-1, nowY)) {
									break;
								}
								nowX = nowX - 1;
							}
							nowDirection = 'U';
						}else {
							checkCharacter(nowX, nowY, map);
						}
						break;
					case 'D':
						if(checkMove(nowX+1, nowY)) {
							while(map[nowX+1][nowY] == '.') {
								if(!checkMove(nowX+1, nowY)) {
									break;
								}
								nowX = nowX + 1;
							}
							nowDirection = 'D';
						}else {
							checkCharacter(nowX, nowY, map);
						}
						
						break;
					case 'L':
						if(checkMove(nowX, nowY-1)) {
							while(map[nowX][nowY-1] == '.') {
								if(!checkMove(nowX, nowY-1)) {
									break;
								}
								nowY = nowY - 1;
							}
							nowDirection = 'L';
						}else {
							checkCharacter(nowX, nowY, map);
						}
						break;
					case 'R':
						if(checkMove(nowX, nowY+1)) {
							while(map[nowX][nowY+1] == '.') {
								if(!checkMove(nowX, nowY+1)) {
									break;
								}
								nowY = nowY + 1;
							}
							nowDirection = 'R';
						}else {
							checkCharacter(nowX, nowY, map);
						}
						break;
					case 'S':
						while(true) {
							//'#'에 닿거나 배열의 범위를 넘어서면 break;
							if(!checkMove(nowX, nowY) ||  map[nowX][nowY] == '#') {
								break;
							}
							if(map[nowX][nowY] == '*') {
								map[nowX][nowY] = '.';
							}else if(map[nowX][nowY] == '.'){
								if(nowDirection == 'U') {
									nowX = nowX - 1;
								}else if(nowDirection == 'D') {
									nowX = nowX + 1;
								}else if(nowDirection == 'L') {
									nowY = nowY - 1;
								}else if(nowDirection == 'R') {
									nowY = nowY + 1;
								}		
							}else {
								checkCharacter(nowX, nowY, map);
							}
						
						}
						break;							
					default:
						break;
				}
				i++;
			}
			
			for(int l = 0; l < N; l++) {
				for(int j = 0; j < N; j++) {
					System.out.print(map[l][j]);
				}
				System.out.println();
			}
			
		}//end for
	}
	
	//움직이려는 이동이 배열의 범위를 넘어서는지 확인함
	public static boolean checkMove(int moveX, int moveY) {
		if(moveX >= 0 && moveY < N && moveY >= 0 && moveY < N) {
			return true;
		}
		return false;
	}
	
	public static void checkCharacter(int moveX, int moveY, char[][] gameMap) {
		switch (gameMap[moveX][moveY]) {
		case '^':
			gameMap[moveX][moveY] = ' ';
			nowDirection = 'U';
			break;
		case 'v':
			gameMap[moveX][moveY] = ' ';
			nowDirection = 'D';
			break;
		case '<':
			gameMap[moveX][moveY] = ' ';
			nowDirection = 'L';
			break;
		case '>':
			gameMap[moveX][moveY] = ' ';
			nowDirection = 'R';
			break;
		default:
			break;
		}
	}
	
}
