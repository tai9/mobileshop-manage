package controller;

import java.util.List;

import gui.customer.CustomerFormEvent;
import model.Customer;
import model.Database;

// Liên kết Database với customer
public class Controller {
	Database db = new Database();

	public void addCustomer(CustomerFormEvent customer) {
		// add customer vào CustomerFormEvent
		String name =  customer.getName();
		int birthYear = customer.getBirthYear();
		String sex = customer.getSex();
		String phoneNumber = customer.getPhoneNumber();
		String address = customer.getAddress();
		Customer cus = new Customer(name, birthYear, sex, phoneNumber, address);
		db.addCustomer(cus);
	}
	
	public List<Customer> getListCustomer(){
		return db.getListCustomer();
	}
}
