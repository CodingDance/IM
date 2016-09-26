package com.yiting.imbiz.repository;

import java.io.Serializable;

/**
 * Created by hzyiting on 2016/9/23.
 */
public interface CrudRepository<T, ID extends Serializable> extends Repository<T, ID> {
	<S extends T> S save(S var1);

	<S extends T> Iterable<S> save(Iterable<S> var1);

	T findOne(ID var1);

	boolean exists(ID var1);

	Iterable<T> findAll();

	Iterable<T> findAll(Iterable<ID> var1);

	long count();

	void delete(ID var1);

	void delete(T var1);

	void delete(Iterable<? extends T> var1);

	void deleteAll();
}