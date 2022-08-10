package com.algorithm.list;

public class MainStackTest {
	public static void main(String[] args) {
		IStack<Integer> stack = new IStackImpl<Integer>();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		System.out.println(stack.peek());
		System.out.println(stack.size());
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
