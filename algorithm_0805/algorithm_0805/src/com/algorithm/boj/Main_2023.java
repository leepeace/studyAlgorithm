package com.algorithm.boj;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2023 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int first = (int) Math.pow(10, N);
		int last = first-1;
		
		//소수가 아닌 경우 false, 소수인 경우 true
		boolean[] isPrime = new boolean[last+1];
		Arrays.fill(isPrime, true);
		
		checkPrime(isPrime, last);
		
		for(int i = first; i <= last; i++) {
			if(isPrime[i]) {
				System.out.println(i);
			}
		}
		
		
	}
	
	public static void checkPrime(boolean[] prime, int end) {	
		for(int i = 2; i <= end; i++) {
			for(int j = i*i; j <= end; j+=i) {
				prime[j] = false;
			}
		}
	}
	
}
