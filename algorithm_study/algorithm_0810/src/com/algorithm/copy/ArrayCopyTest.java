package com.algorithm.copy;
import java.util.Arrays;

public class ArrayCopyTest {
	public static void main(String[] args) {
		
		int[][] original = {{1,2,3}, {4,5,6}, {7,8,9}, {10,11,12}};
		int[][] copy = new int[original.length][original[0].length];
		
		for(int i = 0; i < original.length; i++) {
			System.arraycopy(original[i], 0, copy[i], 0, original[i].length);
		}
		
		for (int i = 0; i < copy.length; i++) {
			for (int j = 0; j < copy[i].length; j++) {
				System.out.print(copy[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}