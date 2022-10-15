package algorithm.combination;

import java.util.Arrays;
import java.util.Scanner;

public class CombinationTest {
	static int N, R, totalCnt;
	static int[]input;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		R = sc.nextInt();
		totalCnt = 0;
		
		input = new int[N];//전체 n개 배열
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		//comb(0, 0, new int[R]);
		comb2(0, 0, new int[R]);
		
		System.out.println("총 경우의 수 : " + totalCnt);
	}
	
	//조합
	public static void comb(int cnt, int start, int[] output) {
		if(cnt == R) {
			totalCnt++;
			System.out.println(Arrays.toString(output));
			return;
		}
		
		//start부터 처리하여 중복 수 추출 방지 및 순서가 다른 조합 추출 방지
		for (int i = start; i < N; i++) {
			//앞쪽에서 선택되지 않았다면 수를 사용
			output[cnt] = input[i];
			
			//다음 수 뽑으러 가기
			comb(cnt+1, i+1, output);
		}
		
	}
	
	//중복 조합 
	public static void comb2(int start, int cnt, int[] output) {
		if(cnt == R) {
			totalCnt++;
			System.out.println(Arrays.toString(output));
			return;
		}
		
		for (int i = start; i < N; i++) {
			output[cnt] = i;
			comb2(i, cnt+1, output); 
		}
		
	}
	
}
