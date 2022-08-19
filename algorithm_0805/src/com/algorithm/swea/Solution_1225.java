package com.algorithm.swea;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1225 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int T = 1;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int[] array = new int[8];
			int testnum = sc.nextInt();
			
			for (int j = 0; j < array.length; j++) {
				array[j] = sc.nextInt();
			}
		
			Queue<Integer> queue = new LinkedList<Integer>();
			
			int minusCycle = 1;
			
			for(int i = 0; i < array.length; i++) {
				queue.add(array[i]);
			}
			
			while(!queue.isEmpty()) {
				if(minusCycle > 5) {	
					minusCycle = 1;
				}
				
				int top = queue.poll();
				
				//숫자가 감소할 때 0보다 작아지는 경우
				if(top - minusCycle <= 0) {
					int rear = 0;
					queue.add(rear);
					break;
				}
				queue.add(top-minusCycle);
				
				minusCycle++;				
			}
			
			System.out.print("#" + testnum + " ");
			while(!queue.isEmpty()) {
				System.out.print(queue.poll() + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}
