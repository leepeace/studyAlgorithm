package com.algorithm.swea;

import java.util.Scanner;
import java.util.Stack;

public class Solution_1218_이해민 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			Stack<Character> stack = new Stack<Character>();
			int size = sc.nextInt();
			char[] str = new char[size];
			int result = 1;//1 - 유효함, 0 - 유효하지 않음
			char[][] bracket = {{'(', ')'}, {'[', ']'}, {'{', '}'}, {'<', '>'}};
			
			String temp = sc.next();
			for(int i = 0; i < size; i++) {
				str[i] = temp.charAt(i);
			}
			
			
			stack.push(str[0]);
			
			int idx = 1;
			while(idx < size) {
				int tempIdx = -1;
				
				if(stack.isEmpty()) {
					stack.push(str[idx]);
					idx++;
					continue;
				}
				for(int i = 0; i < bracket.length; i++) {
					if(stack.peek() == bracket[i][0] && str[idx] == bracket[i][1]) {
						stack.pop();
						tempIdx = i;
						break;
					}
				}
				if(tempIdx == -1) {
					stack.push(str[idx]);
				}
				idx++;
			}
			
			if(!stack.isEmpty()) {
				result = 0;
			}
			
			System.out.println("#" +test_case + " " + result);
		}
		sc.close();
	}

}
