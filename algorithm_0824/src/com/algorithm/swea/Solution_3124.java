package com.algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제 : swea 3124 최소스패닝트리
 * V=10만, E=20만이므로 -> 희소 그래프
 * 크루스칼 알고리즘, 인접리스트
 */
public class Solution_3124 {
	static class Node{
		int from;
		int to;
		int weight;
		
		public Node(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
	}
}
