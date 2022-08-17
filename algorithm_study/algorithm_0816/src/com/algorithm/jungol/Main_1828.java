package com.algorithm.jungol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * 문제 : Jungol 1828 냉장고
 * 조건 : Ci는 온도 xi이상, yi이하의 온도에서 보관
 * 유형 : 그리디 알고리즘
 * */
public class Main_1828 {
	static class Celsius implements Comparable<Celsius>{
		int lowCelsiu;//최저보관온도
		int highCelsius;//최고보관온도
		
		public Celsius(int lowCelsiu, int highCelsius) {
			super();
			this.lowCelsiu = lowCelsiu;
			this.highCelsius = highCelsius;
		}
		
		@Override
		public int compareTo(Celsius o) {
			//최고 온도로 오름차순 정렬하되, 최고 온도가 같은 경우 최저 온도로 정렬
			if(this.highCelsius == o.highCelsius)
				return this.lowCelsiu - o.lowCelsiu;
			
			return this.highCelsius - o.highCelsius;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Celsius[] celsius = new Celsius[N];
		
		for (int i = 0; i < N; i++) {
			int low = sc.nextInt();
			int high = sc.nextInt();
			celsius[i] = new Celsius(low, high);
		}
		
		Arrays.sort(celsius);
		
		for (int i = 0; i < celsius.length; i++) {
			System.out.println("low : " + celsius[i].lowCelsiu + "high : " + celsius[i].highCelsius);
		}
		
		System.out.println(searchMin(celsius));
		
	}
	
	private static int searchMin(Celsius[] cel){
		List<Celsius> list = new ArrayList<Celsius>();
		
		list.add(cel[0]);
		
		int result = 1;
		
		int size = cel.length;
		
		//온도가 겹쳐지면 같은 냉장고를 사용할 수 있다.
		//list의 최고온도 <= 최저온도 (겹쳐지지 않는 경우)
		//최고온도 갱신
		for(int i = 1; i < size; i++) {
			if(list.get(list.size()-1).highCelsius <= cel[i].lowCelsiu) {
				result++;
				list.add(cel[i]);
			}
		}
		
		return result;
	}
	
}
