package com.algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1208 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//Scanner sc = new Scanner(System.in);
		//int T;
		//T=sc.nextInt();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case <= 10; test_case++){
			int dump = Integer.parseInt(br.readLine());
			String[] temp = br.readLine().split(" ");
			int[] box = new int[temp.length];
			
			for(int i = 0; i < temp.length; i++) {
				box[i] = Integer.parseInt(temp[i]);
			}//입력 끝
			
			int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;//가장 낮은곳과 높은곳의 값
			int result = 0;
			
			int maxIdx = 0, minIdx = 0;//가장 높은곳과 낮은곳의 인덱스를 구함
			for(int i = 0; i < box.length; i++) {
				max = Math.max(max, box[i]);
				min = Math.min(min, box[i]);
				if(max == box[i]) {
					maxIdx = i;
				}
				if(min == box[i]) {
					minIdx = i;
				}
			}
			
			//가장 높은 곳에 있는 상자를 가장 낮은 곳으로 옮기는 작업
			while(dump-- > 0) {
				//가장 높은 곳과 가장 낮은 곳의 차이가 최대 1 이내
				if(max-min < 1) {
					//result = max-min;
					break;
				}
				
				//덤프 작업을 수행함(높은 곳->낮은곳)
				box[maxIdx]--;
				box[minIdx]++;
					
				max = box[maxIdx];
				min = box[minIdx];
				
				//result = max - min;
				
				//다시 가장 높은 곳과 낮은 곳을 찾는다.
				for(int i = 0; i < box.length; i++) {
					max = Math.max(max, box[i]);
					min = Math.min(min, box[i]);
					if(min == box[i]) {
						minIdx = i;
					}
					if(max == box[i]) {
						maxIdx = i;
					}
				}
			}//end while
			result = max-min;
			System.out.println("#" + test_case + " " + result);
		}//end for

	}

}
