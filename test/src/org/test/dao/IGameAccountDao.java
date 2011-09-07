/**
 * 
 */
package org.test.dao;

import java.util.List;

import org.test.entity.GameAccount;



/**
 * @author Loyy
 *
 */
public interface IGameAccountDao {
	public boolean create(GameAccount ga);
	public GameAccount read(Integer id);
	public List<GameAccount> readList(Integer uid);
	public boolean update(GameAccount ga);
	public boolean delete(Integer id);
}
