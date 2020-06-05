package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// nơi chứa dữ liệu customer
public class Database {
	private List<Customer> customerList;
	
	public Database() {
		customerList = new ArrayList<Customer>();
	}
	
	public void addCustomer(Customer customer) {
		customerList.add(customer);
//		System.out.println(customer);
	}
	
	public List<Customer> getListCustomer(){
		return Collections.unmodifiableList(customerList);
	}
}
