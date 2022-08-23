package com.algorithm.example;

import java.util.ArrayList;

public class ArrayListTest {
	public static void main(String[] args) {
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		arr1.add(1);
		arr1.add(2);
		list.add(arr1);
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.add(100);
		list.add(arr2);
		
		ArrayList<Integer> arr3 = new ArrayList<Integer>();
		arr3.add(10);
		arr3.add(20);
		arr3.add(30);
		list.add(arr3);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.print(i+"° : ");
			for(int j = 0; j < list.get(i).size(); j++) {
				System.out.print(list.get(i).get(j) + " ");
			}
			System.out.println();
		}
		
	}
}
