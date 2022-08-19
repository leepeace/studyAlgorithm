package com.algorithm.boj;
import java.util.Scanner;

/*
 * 2022.08.01
 * 문제 : 스위치 켜고 끄기
 * 입력 : 스위치 개수, 각 스위치의 상태, 학생수, 학생의 성별, 학생이 받은 수
 * 출력 : 최종 스위치 상태
 * */
public class Main_1244 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();//스위치 개수
		
		char[] switchStatus = new char[N+1];//각 스위치의 상태, '1' : 스위치 켜져 있음 , '0' : 꺼져 있음
		for(int i = 1; i <= N; i++) {
			switchStatus[i] = sc.next().charAt(0);
		}
		
		int studentCount = sc.nextInt();//학생수
		
		for(int i = 0; i < studentCount; i++) {
			int gender = sc.nextInt();//성별
			int student = sc.nextInt();//학생이 받은 스위치
			
			//남학생은 1로, 여학생은 2로 표시
			if(gender == 1) {
				//남학생은 스위치 번호가 자기가 받은 수의 배수이면, 그 스위치의 상태를 바꿈
				for(int j = student; j <= N; j+=student) {
					if(switchStatus[j] == '1') {
						switchStatus[j] = '0';
					}else {
						switchStatus[j] = '1';
					}
				}
			}else if(gender == 2) {
				//여학생은 자신의 스위치를 중심으로 좌우가 같으면서 가장 많은 스위치를 포함하는 구간을 찾아서, 그 구간에 속한 스위치의 상태를 모두 바꿈
				switchStatus[student] = (switchStatus[student] == '0') ? '1' : '0';
				for(int j = 1; j <= N; j++) {
					if((student - j) >= 1 && (student + j) <= N) {
						if(switchStatus[student - j] == switchStatus[student + j]) {
							switchStatus[student - j] = (switchStatus[student - j] == '0') ? '1' : '0';
							switchStatus[student + j] = (switchStatus[student + j] == '0') ? '1' : '0';
						}else {
							break;
						}
					}
				}
			}
			
		}
		
		for(int i = 1; i <= N; i++) {
			System.out.print(switchStatus[i] + " ");
			if(i%20 == 0) {
				System.out.println();
			}
		}
		
	}
	
}
