/**
 * 
 */
package org.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.test.dao.IGameAccountDao;
import org.test.entity.GameAccount;
import org.test.util.DB;

/**
 * @author Loyy
 * 
 */
public class GameAccountDao implements IGameAccountDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public boolean create(GameAccount ga) {
		// TODO Auto-generated method stub

		con = DB.getCon();
		String sql = "insert into gameaccount (uid,name,loginname,loginpwd,mark) values(?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ga.getUsr().getId());
			pstmt.setString(2, ga.getName());
			pstmt.setString(3, ga.getLoginname());
			pstmt.setString(4, ga.getLoginpwd());
			pstmt.setString(5, ga.getMark());
			return pstmt.executeUpdate() > 0;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(con, pstmt, null);
		}

		return false;
	}

	@Override
	public GameAccount read(Integer id) {

		String sql = "select * from gameAccount where id=?";
		try {
			Connection con = DB.getCon();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			List<GameAccount> list = new BeanListHandler(
					new GameAccount().getClass()).handle(rs);
			return list.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(con, pstmt, rs);
		}
		return null;
	}

	@Override
	public List<GameAccount> readList(Integer uid) {
		String sql = "select * from gameaccount where uid=?";
		try {
			Connection con = DB.getCon();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			@SuppressWarnings({ "unchecked", "rawtypes" })
			List<GameAccount> list = new BeanListHandler(
					new GameAccount().getClass()).handle(rs);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(con, pstmt, rs);
		}
		return null;
	}

	@Override
	public boolean update(GameAccount ga) {
		String sql = "update gameaccount set name=?,loginname=?,loginpwd=?,mark=? where id=?";

		try {
			con = DB.getCon();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ga.getName());
			pstmt.setString(2, ga.getLoginname());
			pstmt.setString(3, ga.getLoginpwd());
			pstmt.setString(4, ga.getMark());
			pstmt.setInt(5, ga.getId());
			return pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeAll(con, pstmt, null);
		}

		return false;
	}

	@Override
	public boolean delete(Integer id) {
		String sql = "delete from gameaccount where id=?";
		con = DB.getCon();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			return pstmt.executeUpdate() > 0;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DB.closeAll(con, pstmt, null);
		}
		return false;
	}

}
