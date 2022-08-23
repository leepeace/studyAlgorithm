package com.algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author lee haemin
 * 문제 : 1238 [S/W 문제해결 기본] 10일차 - Contact
 * 접근 유형 : BFS
 */
public class Solution_1238_이해민 {
	
	private static Queue<Integer> queue = new LinkedList<Integer>();
	private static boolean[] visited;
	private static Node[] node;
	
	static class Node{
		int from;
		int to;
		
		public Node(int from, int to) {
			super();
			this.from = from;
			this.to = to;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int dataSize = Integer.parseInt(st.nextToken());//데이터의 길이
			int startNode = Integer.parseInt(st.nextToken());//시작점
			
			visited = new boolean[101];//방문 여부 확인
			node = new Node[dataSize/2];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0;i < dataSize/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				node[i] = new Node(from, to);
			}	
			int result = bfs(startNode);
			
			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}//end of test case
		
		System.out.println(sb.toString());
	}
	
	
	//bfs를 통해 갈 수 있는 노드 번호를 방문하기
	//현재 poll한 노드가 방문할 수 있는 노드를 큐에 넣어주기
	//마지막 노드를 구하기 위해서는 깊이가 제일 깊은 단말 노드를 구해야 함
	private static int bfs(int fromNode) {
		int[] depth = new int[101];//리프노드를 구하기 위해 깊이를 저장(노드번호를 인덱스로 사용)
		queue.offer(fromNode);
		depth[fromNode] = 1;//루트는 깊이 1
		visited[fromNode] = true;
		
		while(!queue.isEmpty()) {
			int fromData = queue.poll();//현재 방문할 노드
			
			for(int i = 0, size = node.length; i < size; i++) {
				if(node[i].from == fromData && !visited[node[i].to]) {
					queue.offer(node[i].to);
					visited[node[i].to] = true;
					depth[node[i].to] += depth[node[i].from]+1;//자식 노드 깊이 = 부모노드 깊이 + 1
				}
			}
		}//end of while
		
		int answer = 1;
		for (int i = 1; i < depth.length; i++) {
			if(depth[i] >= depth[answer])
				answer = i;//가장 깊은 깊이의 인덱스를 구함
		}
		
		return answer;
	}
}
