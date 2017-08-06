package edu.mum.cs.cs544.attendance.dao;

import java.io.Serializable;

public interface BaseDAO<T> {

	public T add(T t);

	public T update(T t);

	public boolean delete(Serializable id);

	public T get(Serializable id);

	
}
