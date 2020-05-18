package code.datas;

import java.util.Calendar;

public class User {
	
	private String name;
	private int birthYear;
	private String phoneNum;
	
	
	public User(String name, int birthYear, String phoneNum) {
		super();
		this.name = name;
		this.birthYear = birthYear;
		this.phoneNum = phoneNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public int getKoreanAge() {
		//지금시점의 한국나이를 리턴
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR) - this.birthYear + 1;
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s(%d세) : %s", this.name,this.getKoreanAge(),this.phoneNum);
	}
	

}
