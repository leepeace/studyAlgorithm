package sw_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_02_2 {
	private static boolean[] visited;
	private static int N;
	private static ArrayList<Pair> location;
	private static int size;
	private static int result;

	static class Pair{
		int x;
		int y;
		int num;//몬스터는 양수로 주어지고 고객은 음수
		
		public Pair(int x, int y, int num) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			result = Integer.MAX_VALUE;
			location = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					if(tmp != 0) {
						location.add(new Pair(i, j, tmp));
					}
				}
			}
			
			permutation(new int[location.size()], 0, new boolean[location.size()]);
			
			sb.append("#").append(" ").append(result).append("\n");
		}//end of testcase	
		
		System.out.println(sb.toString());
	}//end of main
	
	
	/**
	 * 순열을 통해 몬스터와 고객의 순서를 정함
	 * @param output 순서 저장
	 * @param current 현재까지 저장된 카운트
	 */
	public static void permutation(int[] output, int current, boolean[] isSelected) {
		//몬스터 먼저 죽이고 고객 방문 해야하기 때문에 가지치기
		if(current > 0 && !isPossible(output, current)) return;
		
		if(current == output.length) {
			//현재 정해진 순서에 대해 구하고자 하는 거리를 계산
			calcuateDistance(output);
			return;
		}
		
		//인덱스 순서를 정함
		for (int i = 0, size = output.length; i < size; i++) {
			if(isSelected[i]) continue;
			output[current] = i;
			isSelected[i] = true;
			permutation(output, current+1, isSelected);
			isSelected[i] = false;
		}
		
	}
	
	
	/**
	 * 현재까지의 순열 순서가 몬스터가 먼저 잡히고 고객 방문하는 순서인지 확인하는 메서드
	 * @param output 현재까지 정해진 순서 (current 사이즈만큼만 유효함)
	 * @param current 현재까지 정해진 순서 횟수
	 * @return
	 */
	public static boolean isPossible(int[] output, int current) {
		int[] check = new int[current];
		boolean isPossibleAttack = false;
		
		for (int i = 0; i < check.length; i++) {
			check[i] = location.get(output[i]).num;
			if (check[i] < 0) {//고객인 경우
				for (int j = 0; j < i; j++) {//몬스터가 고객 순서 전에 나왔어야 함
					if(Math.abs(check[j]) == Math.abs(check[i])) {//몬스터가 고객 방문 전에 먼저 나온 경우
						isPossibleAttack = true;
						break;
					}
				}
				if(!isPossibleAttack) return false;
			}
		}
		
		return true;
	}
	
	/**
	 * 정해진 순서에 대해 거리를 계산
	 * @param output 정해진 순서(인덱스가 저장됨)
	 */
	public static void calcuateDistance(int[] output) {
		//헌터(0,0)의 시작 위치부터 첫번째 몬스터 위치 계산
		int sum = getDistance(0, 0, location.get(output[0]).x, location.get(output[0]).y);
		
		for (int i = 1; i < output.length; i++) {
			Pair first = location.get(i-1);
			Pair second = location.get(i);
			sum += getDistance(first.x, first.y, second.x, second.y);
		}
		result = Math.min(result, sum);
	}
	
	public static int getDistance(int startX, int startY, int endX, int endY) {
		return Math.abs(startX-endX) + Math.abs(startY - endY);
	}
	
}


