package gui.customer;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Customer;


public class CustomerTableModel1 extends AbstractTableModel {
	
	private List<Customer> customerList;
	private String[] columnName = {"ID", "Name", "Birth Year", "Sex", "Phone Number", "Address"};
	
	public CustomerTableModel1() {
		customerList = new ArrayList<Customer>();
	}
	
	// truyá»�n dá»¯ liá»‡u 
	public void setData(List<Customer> customer) {
		this.customerList = customer;
	}
	
	@Override
	public int getRowCount() {
		return customerList.size();
	}

	@Override
	public int getColumnCount() {
		return columnName.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Customer c = customerList.get(rowIndex);
		switch(columnIndex) {
		case 0: {
			return c.getId();
		}
		case 1:{
			return c.getName();
		}
		case 2: {
			return c.getBirthYear();
		}
		case 3: {
			return c.getSex();
		}
		case 4:{
			return c.getPhoneNumber();
		}
		case 5: {
			return c.getAddress();
		}
		}
		return null;
	}

	@Override
	public String getColumnName(int column) {
		return columnName[column];
	}
	
	public Customer getCustomerAt(int row) {
		return customerList.get(row);
	}
	
}
