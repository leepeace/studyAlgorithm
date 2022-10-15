package com.algorithm.example;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTest02 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(0);
		list.add(100);
		list.add(3);
		
		Collections.sort(list);
		
		System.out.println(list.toString());
		
		/////////////////////////////////////////////////
		
		
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i) == 1) {
				list.remove(i);
				i--;
			}
			System.out.print(list.get(i) + " ");
		}
		
		
	}
}
