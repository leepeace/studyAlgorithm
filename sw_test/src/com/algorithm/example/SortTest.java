package com.algorithm.example;

import java.util.Arrays;
import java.util.Collections;

public class SortTest {

	public static void main(String[] args) {
		//int[] arr = {10,30,1,40,2,5};
		Integer[] arr = {10,30,1,40,2,5};
		
		//내림차순
		//배열을 내림차순으로 정렬할 때 Collections.reverseOrder()을 사용하는 경우에는 기본 타입의 배열을 래퍼 클래스로 만들어야 한다.
		Arrays.sort(arr, Collections.reverseOrder());
		System.out.print("내림차순 : ");
		System.out.println(Arrays.toString(arr));
		
		
		///////////////////////////배열 항목 검색/////////////////////////////
		Arrays.sort(arr);
		System.out.print("오름차순 : ");
		System.out.println(Arrays.toString(arr));
		//Arrays.binarySearch()메서드로 원하는 항목의 인덱스 값을 찾을 수 있다.
		System.out.println(Arrays.binarySearch(arr, 40));
		
	}
}
