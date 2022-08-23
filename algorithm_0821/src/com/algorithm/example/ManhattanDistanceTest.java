package com.algorithm.example;

/*
 * 맨해튼 거리 : 각 좌표의 차를 모두 더한 것을 거리로 한다.
 * |X1 - X2| + |Y1 - Y2|가 두 점(X1,Y1), (X2,Y2)사이의 맨해튼 거리이다.
 * 각 점들의 X와 Y의 합과 차를 각각 저장한 후 정렬한 다음,
 * 최소 거리를 구한다면 차이가 가장 작은 값, 최대거리를 구한다면 차이가 가장 큰 값으로 답을 내면 됨
 * */
public class ManhattanDistanceTest {
	public static void main(String[] args) {
		int[] a = {-1,2,3};
		int[] b = {4,0,-3};
		
		int sum = 0;
		
		for(int i = 0; i < a.length; i++) {
			sum += Math.abs(a[i]-b[i]);
		}
		
		System.out.println(sum);
	}
}
