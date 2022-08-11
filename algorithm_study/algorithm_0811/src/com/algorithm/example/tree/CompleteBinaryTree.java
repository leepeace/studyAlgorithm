package com.algorithm.example.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//완전이진트리
//마지막 레벨을 제외한 윗레벨은 포화상태(전부 채워짐)
public class CompleteBinaryTree {

	private char[] node;
	private int lastIndex = 0;//마지막 노드의 인덱스
	private final int SIZE;
	
	//상황에 따라서 레벨에 따라서 사이즈를 결정해야할 수 도 있음
	public CompleteBinaryTree(int size) {
		SIZE = size;
		node = new char[SIZE + 1];//1인덱스부터 사용
	}
	
	public boolean add(char e) {//완전이진트리에 맞게 추가
		if(lastIndex == SIZE) {
			return false;
		}
		node[++lastIndex] = e;//마지막 노드의 인덱스 다음 위치
		return true;
	}
	
	public void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(1);//루트노드 인덱스부터
		
		while(!queue.isEmpty()) {//방문대상이 있을때까지 반복
			int current = queue.poll();//방문차례인 대상 정보 꺼내기
			System.out.print(node[current] + " ");//방문해서 해야할일 처리
			
			//현재 방문노드의 자식노드들을 대기열에 넣기
			if(current * 2 <= lastIndex) {
				queue.offer(current * 2);//왼쪽 자식
			}
			if(current * 2 + 1 <= lastIndex) {
				queue.offer(current * 2 + 1);//오른쪽 자식
			}
		}
		System.out.println();
	}
	
	public void bfs2() {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(1);//루트노드 인덱스부터
		
		while(!queue.isEmpty()) {//방문대상이 있을때까지 반복
			int size = queue.size();//큐 크기 확인(동일 너비 대상의 개수)
			
			while(--size >= 0) {//반복 진입 전 구현 큐 크기만큼만 반복
				int current = queue.poll();//방문차례인 대상 정보 꺼내기
				System.out.print(node[current] + " ");//방문해서 해야할일 처리
				
				//현재 방문노드의 자식노드들을 대기열에 넣기
				if(current * 2 <= lastIndex) {
					queue.offer(current * 2);//왼쪽 자식
				}
				if(current * 2 + 1 <= lastIndex) {
					queue.offer(current * 2 + 1);//오른쪽 자식
				}	
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void dfs() {
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(1);//루트노드 인덱스부터
		
		while(!stack.isEmpty()) {//방문대상이 있을때까지 반복
			int current = stack.pop();//방문차례인 대상 정보 꺼내기
			System.out.print(node[current] + " ");//방문해서 해야할일 처리
			
			//현재 방문노드의 자식노드들을 대기열에 넣기
			if(current * 2 <= lastIndex) {
				stack.push(current * 2);//왼쪽 자식
			}
			if(current * 2 + 1 <= lastIndex) {
				stack.push(current * 2 + 1);//오른쪽 자식
			}
		}
		System.out.println();
	}
	
	public void dfsByPreOrder(int current) {
		System.out.print(node[current] + " ");//방문해서 해야할일 처리
		
		//현재 방문노드의 자식노드들을 대기열에 넣기
		if(current * 2 <= lastIndex) {
			dfsByPreOrder(current * 2);
		}
		if(current * 2 + 1 <= lastIndex) {
			dfsByPreOrder(current * 2 + 1);
		}	
	}
	
	public void dfsByInOrder(int current) {
		if(current > lastIndex) return;
		
		//현재 방문노드의 자식노드들을 대기열에 넣기
		if(current * 2 <= lastIndex) {
			dfsByInOrder(current * 2);
		}
		
		System.out.print(node[current] + " ");//방문해서 해야할일 처리
		
		if(current * 2 + 1 <= lastIndex) {
			dfsByInOrder(current * 2 + 1);
		}
	}
	
	public void dfsByPostOrder(int current) {
		if(current > lastIndex) return;
		
		//현재 방문노드의 자식노드들을 대기열에 넣기
		if(current * 2 <= lastIndex) {	dfsByInOrder(current * 2);	}
				
		if(current * 2 + 1 <= lastIndex) {	dfsByInOrder(current * 2 + 1);	}
		
		System.out.print(node[current] + " ");//방문해서 해야할일 처리
	}
	
}
