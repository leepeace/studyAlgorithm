package com.ssafy.corona.virus;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class VirusMgrImpl implements VirusMgr {
	private Virus[] virus;
	private int index;
	
	public VirusMgrImpl() {
		virus=new Virus[100];		
	}
	
	@Override
	public void add(Virus v){
		try {
			search(v.getName());
		} catch (NotFoundException e) {
			virus[index++]=v;
		}
	}
	@Override
	public Virus[] search() {
		return virus;
	}
	@Override
	public Virus search(String name) throws NotFoundException{
		for(int i=0; i<virus.length; i++) {
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
		File f = null;
		if(f.exists()) {
			try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(f))){
				virus=(Virus[])ois.readObject();
			} catch (IOException | ClassNotFoundException e) {
				System.out.println("[SYSTEM] 파일 읽기 실패");
			}
		}
	}
}
