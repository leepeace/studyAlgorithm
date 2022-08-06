package com.ssafy.corona.virus;

//사용자 정의 에러
public class DuplicatedException extends Exception{
	public DuplicatedException(String msg) {
		super(msg);
	}
	public DuplicatedException() {
		this("Duplicated예외");
	}
}
