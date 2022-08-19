package com.algorithm.example.greedy;

import java.util.Scanner;

//동전 자판기 문제
public class CoinGreedyTest {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int targetMoney = sc.nextInt();
		
		int[] units = {500, 100, 50, 10, 5, 1};
		int[] counts = {sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};
		
		int totalMoney = 0;
		for (int i = 0, size = units.length; i < size; i++) {
			//보유하고 있는 모든 동전들로 만들 수 있는 금액 계산
			totalMoney += units[i] * counts[i];
		}
		
		//갖고 있는 돈에서 음료수 값을 지불하고 남은 나머지 금액
		int remainMoney = totalMoney - targetMoney;
		
		//음료수값을 지불하는데 동전을 최대로 사용하려면, 지불하고 남은 금액의 동전수를 최소로 하면 됨
		int sum = 0, maxCnt = 0, availCnt = 0;
		for (int i = 0, size = units.length; i < size; i++) {//가장 큰 화폐단위부터 많이 사용하도록
			maxCnt = remainMoney / units[i];//해당 금액을 i화폐단위로 가장 많이 쓸때의 개수
			availCnt = maxCnt <= counts[i] ? maxCnt : counts[i];
			
			counts[i] -= availCnt;//사용하고 남은 동전의 개수 : 음료수 값을 지불하는데 사용될 동전의 개수가 됨
			remainMoney -= availCnt * units[i];
			sum += counts[i];//사용되고 남은 동전이 지불하기 위해 사용될 동전 수 
		}
		System.out.println(sum);//음료수 값을 지불하기 위해 사용된 동전의 수
		
		for (int i = 0, size = counts.length; i < size; i++) {
			System.out.print(counts[i] + " ");
		}
		
	}
}
