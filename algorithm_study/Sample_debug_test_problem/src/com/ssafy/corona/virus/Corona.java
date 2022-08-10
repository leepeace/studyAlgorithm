package com.ssafy.corona.virus;

/*
 * public String toString()가 원형
 * */
public class Corona extends Virus{
	public int spreadSpeed;

	public Corona(String name, int level, int spreadSpeed) {
		super(name, level);
		setSpreadSpeed(spreadSpeed);
	}
	
	public int getSpreadSpeed() {
		return spreadSpeed;
	}
	public void setSpreadSpeed(int spreadSpeed) {
		this.spreadSpeed = spreadSpeed;
	}	
	
	//virus의 toString()을 상속받음
	//public String toString();
	//오버라이딩인지 오버로딩하고 있는지 확인하기
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(super.toString()).append("\t")
		  .append(getSpreadSpeed());
		return sb.toString();
	}
}