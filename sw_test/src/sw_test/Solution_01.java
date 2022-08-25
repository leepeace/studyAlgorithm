package sw_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//조합???
public class Solution_01 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			
			int size = 3;
			int[] entrance = new int[size+1];
			int[] fisherman = new int[N+1];
			
			StringTokenizer st = null;
			for (int i = 1; i <= size; i++) {
				st = new StringTokenizer(br.readLine());
				entrance[i] = Integer.parseInt(st.nextToken());
				fisherman[entrance[i]] = Integer.parseInt(st.nextToken());
			}
			
			
		}
		
	}

}
