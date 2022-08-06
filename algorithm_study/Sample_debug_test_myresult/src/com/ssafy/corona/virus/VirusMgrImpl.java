package com.ssafy.corona.virus;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

//인터페이스를 유심히 보기(인터페이스를 제대로 구현했나 확인해야 함)
//예외 던지기 잘 되나 확인
//equals인지 확인해보기
public class VirusMgrImpl implements VirusMgr {
	private Virus[] virus;
	private int index;

	//2. 내부에서 싱글톤 객체 생성(private static 필수)
	private static VirusMgr instance = new VirusMgrImpl();

	//1. 생성자 private 처리
	private VirusMgrImpl() {
		//100개의 배열을 생성했으나 아직 값이 들어가 있지 않은 상태
		virus=new Virus[100];		
	}

	//3. getter 메서드 외부에 제공(public static 필수)
	public static VirusMgr getInstance() {
		return instance;
	}
	
	//예외 던지기!!!
	@Override
	public void add(Virus v) throws DuplicatedException{
		try {
			search(v.getName());
			throw new DuplicatedException(v.getName() + ": 등록된 바이러스입니다.");
		} catch (NotFoundException e) {
			//기존의 데이터와 중복되지 않은 경우에 데이터를 삽입함
			virus[index++]=v;
		}
	}
	
	@Override
	public Virus[] search() {
		//return virus;
		return Arrays.copyOf(virus, index);
	}
	
	//예외 던지기!!!
	@Override
	public Virus search(String name) throws NotFoundException{
		for(int i=0; i< index; i++) {
			if(virus[i].getName().equals(name)) return virus[i];
		}
		throw new NotFoundException(name+": 미등록 바이러스입니다.");
	}
	
	/*
	 * 데이터를 쓸때 판단하기 위해 직렬화를 사용한다.
	 * 이를 통해 관리가 될 수 있다.
	 * */
	@Override
	public void save() {
		try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("virus.dat"))){
			oos.writeObject(virus);
			oos.flush();
		} catch (IOException e) {
			System.out.println("[SYSTEM] 파일 쓰기 실패");
		}
		virus=null;
	}
	@Override
	public void load() {
		File f = new File("virus.dat");
		if(f.exists()) {
			try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(f))){
				virus=(Virus[])ois.readObject();
			} catch (IOException | ClassNotFoundException e) {
				System.out.println("[SYSTEM] 파일 읽기 실패");
			}
		}
	}
	
	
}
