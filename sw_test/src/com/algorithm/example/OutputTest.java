package com.algorithm.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputTest {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int result = 0;
		for (int i = 0; i < 5; i++) {
			bw.write("#" + i + " " + result +"\n");
		}
		
		bw.flush();
		bw.close();
	}
}
