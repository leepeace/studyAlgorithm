package com.algorithm.example;

public class ManhattanDistanceTest {
	public static void main(String[] args) {
		int[] a = {-1,2,3};
		int[] b = {4,0,-3};
		
		int sum = 0;
		
		for(int i = 0; i < a.length; i++) {
			sum += Math.abs(a[i]-b[i]);
		}
		
		System.out.println(sum);
	}
}
