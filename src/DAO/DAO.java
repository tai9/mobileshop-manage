package DAO;

import java.util.List;

import model.Customer;

public interface DAO<T, K>{
	
	public List<T> getAll();

	public T get(K k);

	public boolean add(T t);

	public boolean update(T t);

	public boolean delete(T t);

}
