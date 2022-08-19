package com.algorithm.list;

//단순 연결 리스트의 삽입, 삭제, 조회 알고리즘을 스택을 통해 구현해보자
public class IStackImpl<E> implements IStack<E>{

	private Node<E> top;
	
	@Override
	public void push(E data) {//첫 번째 노드로 삽입 알고리즘
		top = new Node<E>(data, top);
	}

	@Override
	public E pop() {
		if(isEmpty()) {
			System.out.println("공백 스택이어서 작업이 불가능합니다.");
			return null;
		}
		
		Node<E> popNode = top;
		top = popNode.link;//top 노드가 가리키는 다음 노드를 top으로 바꾼다
		popNode.link = null;//top 노드의 연결을 끊음
		
		return popNode.data;
	}

	@Override
	public E peek() {
		if(isEmpty()) {
			System.out.println("공백 스택이어서 작업이 불가능합니다.");
			return null;
		}
		return top.data;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public int size() {
		int cnt = 0;
		
		//마지막 노드의 link는 null
		//마지막 노드가 나올때까지 반복
		for (Node<E> temp = top; temp != null; temp = temp.link) {
			++cnt;
		}
		
		return cnt;
	}
	
	
}
