package com.algorithm.example;

import java.util.ArrayList;
import java.util.Arrays;

public class CopyTest {
	public static void main(String[] args) {
		///////////////////////2차원 배열 복사/////////////////////////
		int[][] original = {{1,2,3}, {4,5,6}, {7,8,9}, {10,11,12}};
		int[][] copy = new int[original.length][original[0].length];
		
		
		for (int i = 0, size = original.length; i < size; i++) {
			System.arraycopy(original[i], 0, copy[i], 0, original[i].length);
		}
		
		////////////////////////////출력///////////////////////////
		for (int i = 0; i < copy.length; i++) {
			for (int j = 0; j < copy[i].length; j++) {
				System.out.print(copy[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------------");
		
		////////////////////1차원 배열 복사/////////////////////////////
		int[] arr = {0,1,2,3,4,5,6};
		int[] arr1 = Arrays.copyOfRange(arr, 0, arr.length);
		
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println("---------------------------");
		
		////////////////ArrayList 복사///////////////////////////
		ArrayList<Integer> originalList = new ArrayList<Integer>();
		originalList.add(0);
		originalList.add(1);
		originalList.add(2);
		originalList.add(12);
		
		ArrayList<Integer> copyList = new ArrayList<Integer>();
		
		copyList.addAll(originalList);
		
		System.out.println(originalList.toString());
		
	}	
}
