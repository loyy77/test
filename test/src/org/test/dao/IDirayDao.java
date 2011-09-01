package org.test.dao;

import java.util.List;

import org.test.entity.Diray;

public interface IDirayDao {

	public abstract boolean create(Diray d);

	public abstract Diray read(Integer id);

	public abstract List<Diray> readList();

	public abstract boolean update(Diray d);

	public abstract boolean delete(Integer id);

}