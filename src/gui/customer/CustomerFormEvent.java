package gui.customer;

import java.util.EventObject;

public class CustomerFormEvent extends EventObject{
	private int id;
	private String name; 
	private int birthYear;
	private String sex ;
	private String phoneNumber, address;
	
	public CustomerFormEvent(Object source) {
		super(source);
	}

	public CustomerFormEvent(Object source, int id, String name, int birthYear, String sex, String phoneNumber,
			String address) {
		super(source);
		this.id = id;
		this.name = name;
		this.birthYear = birthYear;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public CustomerFormEvent(Object source, String name, int birthYear, String sex, String phoneNumber,
			String address) {
		super(source);
		this.name = name;
		this.birthYear = birthYear;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	
	
}
