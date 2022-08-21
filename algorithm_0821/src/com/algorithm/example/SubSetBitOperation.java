package com.algorithm.example;

/*
 * 부분집합을 비트연산자를 이용하여 생성할 수 있습니다.
 * 1 << N은  모든부분집합의 수 2^N을 의미
 * 비트마스크
 * */
public class SubSetBitOperation {
	public static void main(String[] args) {
		int[] input = {1,3,4,5,2};
		int N = input.length;
		
		//0001 << N은 부분집합의 최대 개수 2^N과 동일
		//flag는 부분집합의 개수만큼 반복문을 반복함
		for(int flag = 0; flag < (1 << N); flag++) {
			System.out.print(flag+1 + "번째 : ");
			//현 비트열의 상태에 대해 각 원소의 부분집합에 포함 유/무 확인
			for (int j = 0; j < N; j++) {//j가 1씩 증가할때마다 1칸씩 밀림
				if((flag & (1 << j)) != 0) {//j 원소가 부분집합에 포함
					System.out.print(input[j] + " ");
				}
			}
			System.out.println();	
		}
	}
	
}
