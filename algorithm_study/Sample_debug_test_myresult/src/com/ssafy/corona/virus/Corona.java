package com.ssafy.corona.virus;

public class Corona extends Virus implements Comparable<Virus>{
	public int spreadSpeed;

	//생성자
	//리턴타입 없음!!
	public Corona(String name, int level, int spreadSpeed) {
		super(name, level);
		//super.setLevel(level);
		setSpreadSpeed(spreadSpeed);
	}
	
	public int getSpreadSpeed() {
		return spreadSpeed;
	}
	public void setSpreadSpeed(int spreadSpeed) {
		this.spreadSpeed = spreadSpeed;
	}	
	
	//toString()에 매개변수가 있어서 오버라이딩이 않됨(오버로딩으로 됨)
	/*
	 * public String toString()가 원형
	 * */
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(super.toString()).append("\t")
		  .append(getSpreadSpeed());
		return sb.toString();
	}

	@Override
	public int compareTo(Virus o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}