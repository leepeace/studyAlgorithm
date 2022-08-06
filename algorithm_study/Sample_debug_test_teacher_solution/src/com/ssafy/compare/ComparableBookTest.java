package com.ssafy.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableBookTest {
	public static void main(String[] args) {
		//--- Array
		Book[] array = {
			new Book("book-01", "자바의 정석", 55000),
			new Book("book-05", "알고리즘의 정석", 42000),
			new Book("book-03", "웹프로그래밍", 35000),
			new Book("book-02", "알고리즘의 정석", 62000),
			new Book("book-04", "스프링부트", 78000)
		};
		
		System.out.println("\n-- 전체 조회");
		for(Book b : array) {
			System.out.println(b);
		}
		
		//도서 기본 정렬로 올림, 내림, 도서명(올림), 가격(내림) 순으로 정렬할 수 있도록 변경해보세요
		System.out.println("\n-- 전체 조회 : 도서번호 올림 정렬[도서 기본 정렬]");
		Arrays.sort(array); //Arrays 기본 정렬 사용. 정렬 기준 넣어 줘야함
							//Book에 Comparable implements, compareTo() 메서드 오버라이딩
		for(Book b : array) {
			System.out.println(b);
		}
		
		System.out.println("\n-- 전체 조회 : 도서가격 올림 정렬");
		//Arrays의 sort 사용. 정렬 기준을 외부에서 넣어 주기. 
		// Comparator 구현해서 넣기. compare() 메서드 오버라이딩
		Arrays.sort(array,new Comparator<Book>() {

			@Override
			public int compare(Book o1, Book o2) {
				//첫번째 객체 멤버 왼쪽에 위치 --> 올림 정렬
				//첫번째 객체 멤버 오른쪽에 위치 --> 내림 정렬
//				return o1.price-o2.price;
				return Integer.valueOf(o1.price).compareTo(Integer.valueOf(o2.price));
			}
		});
		for(Book b : array) {
			System.out.println(b);
		}
		
		System.out.println("\n-- 전체 조회 : 도서가격 내림 정렬");
		Arrays.sort(array,new Comparator<Book>() {

			@Override
			public int compare(Book o1, Book o2) {
				//첫번째 객체 멤버 왼쪽에 위치 --> 올림 정렬
				//첫번째 객체 멤버 오른쪽에 위치 --> 내림 정렬
//				return o1.price-o2.price;
				return Integer.valueOf(o2.price).compareTo(Integer.valueOf(o1.price));
			}
		});
		for(Book b : array) {
			System.out.println(b);
		}
		
		System.out.println("\n-- 전체 조회 : 도서명(올림), 가격(내림) 순으로 정렬");
		Arrays.sort(array, new Comparator<Book>() {

			@Override
			public int compare(Book o1, Book o2) {
				if(o1.title.equals(o2.title)) {
					return Integer.valueOf(o2.price).compareTo(Integer.valueOf(o1.price));
				}

				return o1.title.compareTo(o2.title);
			}
		});
		for(Book b : array) {
			System.out.println(b);
		}
		
		//--- Collection List
		Book b1 = new Book("book-01", "자바의 정석", 55000);
		Book b2 = new Book("book-05", "알고리즘의 정석", 42000);
		Book b3 = new Book("book-03", "웹프로그래밍", 35000);
		Book b4 = new Book("book-02", "알고리즘의 정석", 62000);
		Book b5 = new Book("book-04", "스프링부트", 78000);
		
		List<Book> list = new ArrayList<Book>();
		list.add(b1);
		list.add(b2);
		list.add(b3);
		list.add(b4);
		list.add(b5);
		
		System.out.println("\n-- [Collection List] 전체 조회");
		for(Book b : list) {
			System.out.println(b);
		}
		
		System.out.println("\n-- [Collection List] 전체 조회: 도서번호 올림 정렬조회[기본 정렬]");
		Collections.sort(list);
		for(Book b : list) {
			System.out.println(b);
		}
		
		System.out.println("\n-- [Collection List] 전체 조회: 도서명 올림 정렬조회");
		Collections.sort(list,new Comparator<Book>() {

			@Override
			public int compare(Book o1, Book o2) {
				// TODO Auto-generated method stub
				return o1.title.compareTo(o2.title);
			}
		});
		for(Book b : list) {
			System.out.println(b);
		}
	}
	
	public static void printArray(Book[] array) {
		for(Book b : array) {
			System.out.println(b);
		}
	}
}