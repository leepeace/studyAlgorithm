package com.algorithm.example.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MeetingRoomTest {
	static class Meeting implements Comparable<Meeting>{
		int start, end;//회의 시작, 종료 시간

		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Meeting o) {//종료 시간 기준 오름차순, 종료 시간이 같다면 시작 시간 기준 오름차순
			//a-b < 0인 경우 a < b이다. 오름차순이므로 그래도 둔다.
			//a-b > 0인 경우 a > b이다. 오름차순이므로 switch시킴
			//a-b == 0인 경우 a == b이다. 
			return this.end != o.end ? this.end - o.end : this.start - o.start;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//총 회의 개수
		
		Meeting[] meetings = new Meeting[N];
		
		for(int i = 0; i < N; i++) {
			meetings[i] = new Meeting(sc.nextInt(), sc.nextInt());
		}
		
		List<Meeting> result = getSchedule(meetings);
		System.out.println(result.size());
		for (Meeting meeting : result) {
			System.out.println(meeting.start + " " + meeting.end);
		}
	
	}
	
	private static List<Meeting> getSchedule(Meeting[] meetings){
		List<Meeting> result = new ArrayList<Meeting>();
		//모든 회의를 종료 시간 기준 오름차순, 종료 시간이 같다면 시작 시간 오름차순 정렬		
		Arrays.sort(meetings);

		result.add(meetings[0]);//첫 회의 스케줄에 추가
		
		for (int i = 1, size = meetings.length; i < size; i++) {
			//list에 넣은 마지막 스케줄 시간보다 시작시간이 더 큰 경우
			//오버랩 되지 않음
			if(result.get(result.size()-1).end <= meetings[i].start) {
				result.add(meetings[i]);
			}
		}
		
		return result;
	}
	
}
