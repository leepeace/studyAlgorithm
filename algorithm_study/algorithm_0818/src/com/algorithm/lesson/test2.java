package com.algorithm.lesson;

public class test2 {
	public static void main(String[] args) {
		for (int K = 0; K <= 40; K++) {
			int temp = K * K + (K - 1) * (K - 1);
			System.out.print(temp + ",");
		}
	}
}
