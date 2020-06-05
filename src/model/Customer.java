package model;

import java.util.Date;

public class Customer {
	private static int count = 1;
	private int id;
	private String name;
	private int birthYear;
	private String sex , phoneNumber, address;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public Customer(int id,String name,int birthYear, String sex, String phoneNumber, String address ) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.sex = sex;
		this.birthYear = birthYear;
	}

	public Customer(String name, int birthYear, String sex, String phoneNumber, String address) {
		super();
		this.name = name;
		this.birthYear = birthYear;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.id = count;
		count++;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	@Override
	public String toString() {
		return this.name + " " + this.id;
	}
}
