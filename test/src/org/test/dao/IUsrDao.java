package org.test.dao;

import java.util.List;

import org.test.entity.Usr;

public interface IUsrDao {

	public abstract boolean createUsr(Usr usr);

	public abstract List<Usr> read();

	public abstract boolean update(Usr usr);

	public abstract boolean delete(Integer id);

	public abstract Usr getById(Integer id);
	
	public abstract Integer Login(Usr usr);

}