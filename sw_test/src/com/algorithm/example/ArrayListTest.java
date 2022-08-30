package com.algorithm.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListTest {
	public static void main(String[] args) {
		
		//2차원 list->초기화 생성 필수
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0, size=10; i < size; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		/////////인접 리스트 -- 입력을 넣을때/////////////
		int from = 0;
		int to1 = 1, to2 = 4;
		
		list.get(from).add(to1);
		list.get(from).add(to2);
		
		/////////////////출력//////////////////
		System.out.print("0번 인덱스에 저장된 list 값 : ");
		for (int i = 0, size = list.get(from).size(); i < size; i++) {
			System.out.print(list.get(from).get(i) + " ");
		}
		System.out.println();
		
		System.out.println("----------------------------");
		
		/////////////ArrayList에서 값을 하나씩 가져와서 배열에 넣는 경우////////
		List<Integer> num = new ArrayList<Integer>();
		num.add(1);
		num.add(2);
		num.add(4);

		int[] arr = new int[num.size()];
		
		for (int i = 0, size = num.size(); i < size; i++) {
			arr[i] = num.get(i).intValue();
		}
		
		Arrays.stream(arr).forEach(n->System.out.print(n + " "));
		System.out.println();
		System.out.println("----------------------------");
		
		///////////////////배열->리스트 변환////////////////////////
		String[] arr2 = {"aaa", "bbb", "ccc", "ddd"};
		//Arrays.asList : 배열에 엘리먼트를 추가하거나 삭제할 수 없어서 배열의 사이즈를 변경할 수 없다.
		List<String> list3 = Arrays.asList(arr2);
		
		System.out.println(list3);
		System.out.println("----------------------------");
		
		///////////////리스트에서 최솟값,최댓값 구하기///////////////////////////
		ArrayList<Integer> list4 = new ArrayList<>(Arrays.asList(0,2,1,3,4,5));
		
		int max = Collections.max(list4);
		System.out.println("max : " + max);
		
		int min = Collections.min(list4);
		System.out.println("min : " + min);
		
		
	}
}
