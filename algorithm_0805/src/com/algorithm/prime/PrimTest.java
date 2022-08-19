package com.algorithm.prime;

import java.util.Scanner;

public class PrimTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("소수를 확인 할 숫자를 입력하세요 : ");
		int n = sc.nextInt();

		if(isPrime(n)) {
			System.out.println(n+"은 소수입니다!");
		}else {
			System.out.println(n+"은 소수가 아니예요 ㅜㅜ");
		}
	}
	
	public static boolean isPrime(int n) {
		//1이하의 수는 소수가 아니므로 제외
		if(n<2) {
			return false;
		}
		//숫자 n이 2이상 n-1 이하의 수로 나누어 떨어지는지 확인
		for(int i=2; i<=n-1; i++) {
			if(n%i ==0) {//하나라도 나누어 떨어지면 소수X
				System.out.print(i+" ");
				return false;
			}
		}
		//여기까지 내려왔다는건, 소수!
		return true;
	}
	public static boolean isPrime2(int n) {
		//1이하의 수는 소수가 아니므로 제외
		if(n<2) {
			return false;
		}
		//숫자 n이 2이상 n/2 이하의 수로 나누어 떨어지는지 확인
		for(int i=2; i<=n/2; i++) {
			if(n%i ==0) {//하나라도 나누어 떨어지면 소수X
				System.out.print(i+" ");
				return false;
			}
		}
		//여기까지 내려왔다는건, 소수!
		return true;
	}
	
	public static boolean isPrime3(int n) {
		//1이하의 수는 소수가 아니므로 제외
		if(n<2) {
			return false;
		}
		//숫자 n이 2이상 루트N 이하의 수로 나누어 떨어지는지 확인
		for(int i=2; i*i<=n; i++) {//i<=루트n 는 실수값으로 근사값을 나타내기 때문에 제곱하여 i*i<=N
			if(n%i ==0) {//하나라도 나누어 떨어지면 소수X
				System.out.print(i+" ");
				return false;
			}
		}
		//여기까지 내려왔다는건, 소수!
		return true;
	}

}
