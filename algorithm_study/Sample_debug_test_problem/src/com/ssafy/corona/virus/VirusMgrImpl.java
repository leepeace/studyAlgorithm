package com.ssafy.corona.virus;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class VirusMgrImpl implements VirusMgr {
	private Virus[] virus;
	private int index;

	//내부에서 객체 생성해주기 (private static 필수)
	private static VirusMgr instance = new VirusMgrImpl();
	
	//생성자 private 처리
	private VirusMgrImpl() {
		virus=new Virus[100];		
	}
	
	//getter 메소드 외부에 제공(public static 필수)
	public static VirusMgr getInstance() {
		return instance;
	}
	
	@Override
	public void add(Virus v) throws DuplicatedException{
		try {
			search(v.getName());
			throw new DuplicatedException(v.getName()+ ": 등록된 바이러스입니다.");
		} catch (NotFoundException e) {
			virus[index++]=v;
		}
	}
	@Override
	public Virus[] search() {
		//return virus;
		return Arrays.copyOf(virus, index);
	}
	@Override
	public Virus search(String name) throws NotFoundException{
		for(int i=0; i<index; i++) {
			if(virus[i].getName().equals(name)) return virus[i];
		}
		throw new NotFoundException(name+": 미등록 바이러스입니다.");
	}
	
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
