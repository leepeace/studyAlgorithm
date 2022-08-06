package com.algorithm.compare;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 1. Comparable 인터페이스
 * 		Comparable 인터페이스를 통해 객체를 비교한다.
 * 		Comparable 인터페이스의 추상메서드인 compareTo 메서드를 구현해야함
 * 2. Comparator인터페이스
 * 		추상메서드인 compare메서드를 구현해야함
 * 		두 객체를 파라미터로 받아 비교함
 * */
public class CompareTest {

	public static void main(String[] args) {
		Integer x = 3;
		Integer y = 4;
		
		System.out.println(x.compareTo(y));
		
		Student[] students = {
				new Student("peter", 21), 
				new Student("alley", 25),
				new Student("cally", 35),
				new Student("benzino", 55)};
	
		System.out.println("-----------정렬 전------------");
		for(Student s : students) {
			System.out.println(s);
		}
		
		Arrays.sort(students);
		
		System.out.println("-------------이름 순으로 정렬 후------------- ");
		for(Student s : students) {
			System.out.println(s);
		}
		
		System.out.println("-------------나이 순으로 정렬 후------------- ");
		
		Arrays.sort(students, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return Integer.valueOf(o1.age).compareTo(o2.age);
			}
		});
		
		for(Student s : students) {
			System.out.println(s);
		}
		
	}
	
}

class Student implements Comparable<Student>{
	public String name;
	public int age;
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Student o) {
		return this.name.compareTo(o.name);
	}
	
	@Override
	public String toString() {
		return "학생 이름 : " + name + ", 나이 : " + age;
	}
	
}