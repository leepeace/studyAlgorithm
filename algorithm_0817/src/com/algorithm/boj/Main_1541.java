package com.algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ���� : ���� 1541 �Ҿ���� ��ȣ
 * ���� ���� �ּڰ����� ������ ��
 * */
public class Main_1541_���ع� {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		
		String[] num = temp.split("-");//������ �������� �и�
	
		
		//������ �������� �и��ѵ� ������ ���� ����Ѵ�.
		
		int result = 0;
		for(int i = 0; i < num.length; i++) {
			int sum = 0;
			String[] str = num[i].split("\\+");
			for(int j = 0; j < str.length; j++) {
				sum += Integer.parseInt(str[j]);
			}
			if(i == 0) result += sum;
			else result -= sum;
		}
		
		
		System.out.println(result);
	}

}
