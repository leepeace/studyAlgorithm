package com.algorithm.lesson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//(x1,y1)->(x2,y2)
//(x + 1, y), (x - 1, y)
//(x, y + 1), (x , y - 1)
//(x + 1, y), (x - 1, y)
//(x, y + 1), (x , y - 1)

public class Solution_8382 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(tokens.nextToken());
			int y1 = Integer.parseInt(tokens.nextToken());
			int x2 = Integer.parseInt(tokens.nextToken());
			int y2 = Integer.parseInt(tokens.nextToken());
			
			int i = 1;
			int count = 0;
			while(true) {
				if(x1 == x2 && y1 == y2) break;
				if(i % 2 == 1) {//세로
					if(x1 > x2) x1--;
					else x1++;
				}else {
					if(y1 > y2) y1--;
					else y1++;
				}
				count++;
				i = i % 2 + 1;
			}
			System.out.println("#" + test_case + " " + count);
		}
	}
}
