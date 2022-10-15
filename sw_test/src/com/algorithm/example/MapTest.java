package com.algorithm.example;

import java.util.HashMap;
import java.util.Iterator;

public class MapTest {
	public static void main(String[] args) {
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		//데이터 삽입
		map.put(1, "Java");
		map.put(2, "C++");
		map.put(3, "python");
		map.put(4, "GO");
		
		Iterator<Integer> keys = map.keySet().iterator();
		while(keys.hasNext()) {
			int key = keys.next();
			String value = map.get(key);
			System.out.println(key + ", " + value);
		}
		System.out.println("-------------------");
		
		map.remove(3);
		
		Iterator<Integer> keys2 = map.keySet().iterator();
		while(keys2.hasNext()) {
			int key = keys2.next();
			String value = map.get(key);
			System.out.println(key + ", " + value);
		}
		System.out.println("-------------------");
		
		//key 존재 확인
		System.out.println(map.containsKey(3));
		System.out.println(map.containsKey(2));
		System.out.println("-------------------");
		
		//key의 value 확인
		System.out.println(map.get(1));
		System.out.println("-------------------");
		

		//value 존재 확인
		System.out.println(map.containsValue("Java"));
		System.out.println("-------------------");
		
		
	}
}
