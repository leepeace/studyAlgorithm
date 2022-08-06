package com.ssafy.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorStudentTest {
	//-- Comparator: 필요시에 정렬 구현 사용 
	public static void main(String[] args) {
		Student[] students = {
				new Student("홍길동", 26),
				new Student("강감찬", 50),
				new Student("강감찬", 26),
				new Student("이순신", 35),
				new Student("김유신", 27)
		};

		System.out.println("-- 학생정보 정렬 전");
		for(Student s: students) {
			System.out.println(s);
		}
		
		//--- 배열 자료저장구조 정렬방법
		// 학생이름 올림 정렬 구현
		Arrays.sort(students, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.name.compareTo(o2.name);
			}
			
		});
		
		System.out.println("--- 학생이름 올림 정렬 후");
		for(Student s: students) {
			System.out.println(s);
		}
		
		// 학생이름 내림 정렬 구현 
		Arrays.sort(students, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return -(o1.name.compareTo(o2.name));
			}
			
		});
		
		System.out.println("--- 학생이름 내림 정렬 후");
		for(Student s: students) {
			System.out.println(s);
		}

		// 학생 나이가 작은 순서 정렬
		Arrays.sort(students, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return Integer.valueOf(o1.age).compareTo(Integer.valueOf(o2.age));
			}
			
		});
		
		System.out.println("--- 학생나이 올림 정렬 후");
		for(Student s: students) {
			System.out.println(s);
		}
		
		// 학생 나이가 작은 순서로 정렬, 단, 나이가 같으면 이름 올림 정렬
		Arrays.sort(students, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				if(o1.age==o2.age) {
					return o1.name.compareTo(o2.name);
				}
				return Integer.valueOf(o1.age).compareTo(Integer.valueOf(o2.age));
			}
			
		});
		
		System.out.println("--- 학생나이 올림, 나이가 같으면 이름 올림 정렬 후");
		for(Student s: students) {
			System.out.println(s);
		}
		
		//--- Collection 자료저장구조 정렬방법
		ArrayList<Student> list = new ArrayList<>();
		list.add(new Student("홍길동", 26));
		list.add(new Student("강감찬", 50));
		list.add(new Student("강감찬", 26));
		list.add(new Student("이순신", 35));
		list.add(new Student("김유신", 27));
		
		System.out.println("--- Collection: 학생 정렬 전");
		for(Student s: list) {
			System.out.println(s);
		}

		//--- Collection 
		Collections.sort(list, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				if(o1.age==o2.age) {
					return o1.name.compareTo(o2.name);
				}
				return Integer.valueOf(o1.age).compareTo(Integer.valueOf(o2.age));
			}
		});
		
		System.out.println("--- Collection: 학생 이름, 나이 올림 정렬 후");
		for(Student s: list) {
			System.out.println(s);
		}
	}
}

/*
-- 학생정보 정렬 전
홍길동 | 26
강감찬 | 50
강감찬 | 26
이순신 | 35
김유신 | 27
--- 학생이름 올림 정렬 후
강감찬 | 50
강감찬 | 26
김유신 | 27
이순신 | 35
홍길동 | 26
--- 학생이름 내림 정렬 후
홍길동 | 26
이순신 | 35
김유신 | 27
강감찬 | 50
강감찬 | 26
--- 학생나이 올림 정렬 후
홍길동 | 26
강감찬 | 26
김유신 | 27
이순신 | 35
강감찬 | 50
--- 학생나이 올림, 나이가 같으면 이름 올림 정렬 후
강감찬 | 26
홍길동 | 26
김유신 | 27
이순신 | 35
강감찬 | 50
--- Collection: 학생 정렬 전
홍길동 | 26
강감찬 | 50
강감찬 | 26
이순신 | 35
김유신 | 27
--- Collection: 학생 이름, 나이 올림 정렬 후
강감찬 | 26
강감찬 | 50
김유신 | 27
이순신 | 35
홍길동 | 26
*/
