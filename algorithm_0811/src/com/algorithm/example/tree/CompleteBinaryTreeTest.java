package com.algorithm.example.tree;

public class CompleteBinaryTreeTest {
	public static void main(String[] args) {
		CompleteBinaryTree tree = new CompleteBinaryTree(9);
		
		for(int i = 0; i < 9; i++) {
			tree.add((char)('A' + i));//알파벳 순서대로 삽입
		}
		
		//tree.bfs();
		//tree.bfs2();
		//tree.dfs();
		
		tree.dfsByPreOrder(1);//본인을 제일 먼저 처리
		System.out.println();
		
		//이진 트리이기 때문에 중간 처리가 가능해진다. 
		tree.dfsByInOrder(1);//자신을 중간에 처리
		System.out.println();
		
		tree.dfsByPostOrder(1);//자신을 마지막에 처리
		System.out.println();
	}
}

/*  트리 모양        (높이=너비)
 *  	A		0
 * 	  B   C		1
 *   D E F G	2
 *  H I			3
 * */
