package algorithm.example;

import java.util.Arrays;
import java.util.Scanner;

public class PCSTest {
	
	static int N, R, input[], numbers[];//input : 입력배열, numbers:순열,조합에 선택된 수 배열
	private static boolean[] isSelected;//부분 집합 구성에 포함 여부
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		numbers = new int[R];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		System.out.println("------------순열--------------");
		permutation(0, 0);
		
		System.out.println("------------조합--------------");
		combination(0, 0);
		
		System.out.println("------------부분집합--------------");
		subset(0);
	}
	
	public static void permutation(int cnt, int flag) {
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 0; i < N; i++) {
			// 1 << i : 원하는 비트만 1로 만들기
			//& : 비트 확인 -> 사용을 확인함
			// | : 비트를 합치기 -> 사용 처리
			if((flag & 1 << i) != 0) continue;
			numbers[cnt] = input[i];
			permutation(cnt+1, flag | 1 << i);
		}
	}
	
	public static void combination(int cnt, int start) {
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			combination(cnt+1, i+1);
		}
	}
	
	public static void subset(int cnt) {
		if(cnt == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(isSelected[i] ? input[i] : "X");
			}
			System.out.println();
			return;
		}
		
		isSelected[cnt] = true;
		subset(cnt+1);
		
		isSelected[cnt] = false;
		subset(cnt+1);
	}
	
}
