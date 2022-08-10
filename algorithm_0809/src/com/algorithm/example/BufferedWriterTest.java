package com.algorithm.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class BufferedWriterTest {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = "abcd";
		
		bw.write(s + "\n");
		bw.write("hello");
		
		bw.flush();
		bw.close();
	}
}
