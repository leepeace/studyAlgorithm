package algorithm.floyd;

import java.util.Scanner;

//플로이드 알고리즘 : 음수 사이클만 존재하지 않으면, 음의 가중치를 갖는 간선이 존재해도 상관이 없다.
//양의 가중치 버전, 비용의 최대값이 1000000 넘지 않는다고 가정할 경우
//시간 복잡도 O(N^3)
public class Floyd {

	static final int INF = 9999999;
	static int N, distance[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		distance = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				distance[i][j] = sc.nextInt();
				if(i != j && distance[i][j] == 0) {//자기 자신으로의 인접 정보가 아니고, 인접해있지 않다면 INF로 채우기
					distance[i][j] = INF;
				}
			}
		}
		System.out.println("===========입력==========");
		print();
		
        // 출발지-->경유지-->목적지로 3중 루프 돌리면 오답
        // 경유지-->출발지-->목적지로 3중 루프 돌려야 정답
		for (int k = 0; k < N; k++) {//k를 중간 노드로 삼음
			for (int i = 0; i < N; i++) {//출발지
				if(i == k) continue;//출발지와 경유지가 같다면 다음 출발지
				for (int j = 0; j < N; j++) {//목적지
					if(i == j || k == j) continue;//경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
					if(distance[i][j] > distance[i][k] + distance[k][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
					}
				}
			}
		}

		print();
	}
	
	private static void print() {
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) {
				System.out.print(distance[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("=====================================");
		
	}

}
