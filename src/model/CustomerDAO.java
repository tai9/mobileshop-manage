package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.jdi.connect.spi.Connection;

import DAO.DAO;
//import demo.user.DBConnection;
//import demo.user.User;

public class CustomerDAO implements DAO<Customer, Integer> {
	DBConnection db = new DBConnection();

	@Override
	public List<Customer> getAll() {
		
		
		return null;
	}

	@Override
	public Customer get(Integer k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Customer t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Customer t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Customer t) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
