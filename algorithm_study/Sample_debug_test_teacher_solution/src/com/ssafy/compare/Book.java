package com.ssafy.compare;

public class Book implements Comparable<Book>{
	public String isbn;
	public String title;
	public int price;
	
	public Book(String isbn, String title, int price) {
		this.isbn = isbn;
		this.title = title;
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(isbn);
		builder.append(" | ");
		builder.append(title);
		builder.append("\t| ");
		builder.append(price);
		return builder.toString();
	}

	@Override
	public int compareTo(Book o) {
		//현재 객체 멤버 왼쪽에 위치 --> 올림 정렬
		//현재 객체 멤버 오른쪽에 위치 --> 내림 정렬
		
		//1. 도서번호 올림차순 정렬
		return this.isbn.compareTo(o.isbn);
		
		//2. 도서 가격 내림차순 정렬
//		return Integer.valueOf(o.price).compareTo(this.price);
		
	}
}

