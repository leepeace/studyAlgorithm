package com.ssafy.compare;

import java.util.Arrays;
import java.util.Collections;

public class ComparableStringTest {

	public static void main(String[] args) {
		print("문자열 비교");
		System.out.println("김상현".compareTo("황예은"));
		// 김상현, 황예은
		System.out.println("정상균".compareTo("정상균"));
		// 정상균, 정상균
		// 황예은, 김상현
		System.out.println("황예은".compareTo("김상현"));
		
		String[] names = {"김상현", "윤명지", "정상균", "이하림", "정유진", "황예은"};
		print("문자열 전체조회");
		print(names);
		
		print("문자열 정렬조회");
		Arrays.sort(names);
		print(names);
		
		print("문자열 내림 정렬조회");
		Arrays.sort(names, Collections.reverseOrder());
//		sortStringDesc(names);
		print(names);
		
		
	}
	
	public static void sortStringDesc(String[] array) {
		Arrays.sort(array, Collections.reverseOrder());
//		String tmp = null;
//		for(int i = 0; i<array.length;i++) {
//			for(int j=i+1; j<array.length; j++) {
//				if(array[i].compareTo(array[j])<0) {
//					tmp = array[i];
//					array[i]=array[j];
//					array[j]=tmp;
//				}
//			}
//		}
	}

	public static void print(String msg) {
		//System.out.println("\n--- " + msg);
		System.out.println(new StringBuilder("\n--- ").append(msg));
	}
	
	public static void print(String[] array) {
		for(String s: array) {
			System.out.println(s);
		}
	}
}
