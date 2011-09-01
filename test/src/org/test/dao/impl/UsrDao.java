package org.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.test.dao.IUsrDao;
import org.test.entity.Usr;
import org.test.util.DB;

public class UsrDao implements IUsrDao {

	Connection con = null;
	PreparedStatement pstmt = null;;
	ResultSet rs = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.test.dao.IUsrDao#createUsr(org.test.entity.Usr)
	 */
	@Override
	public boolean createUsr(Usr usr) {

		try {
			con = DB.getCon();
			DB.getStatement(con, "set names utf8;").execute();
			String sql = " insert into usr(`username`,`password`) values(?,?);";
			pstmt = DB.getStatement(con, sql);
			pstmt.setString(1, usr.getUsrname());
			pstmt.setString(2, usr.getPassword());
			return pstmt.execute();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			DB.closeAll(con, pstmt, null);
		}

		return false;
	}

	@Override
	public boolean Login(Usr usr) {
		String sql = "select id from usr where username=? and password=?";
		Connection con = DB.getCon();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, usr.getUsrname());
			pstmt.setString(2, usr.getPassword());
			return pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.test.dao.IUsrDao#read()
	 */
	@Override
	public List<Usr> read() {
		String sql = "select id,username,password from usr";
		List<Usr> list = new ArrayList<Usr>();
		Connection con = DB.getCon();

		try {
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Usr(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeAll(con, pstmt, rs);
		}

		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.test.dao.IUsrDao#update(org.test.entity.Usr)
	 */
	@Override
	public boolean update(Usr usr) {
		String sql = "update usr set username=?,password=? where id=?";

		try {
			pstmt = DB.getStatement(DB.getCon(), sql);
			pstmt.setString(1, usr.getUsrname());
			pstmt.setString(2, usr.getPassword());
			pstmt.setInt(3, usr.getId());
			if (pstmt.executeUpdate() > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeAll(con, pstmt, rs);
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.test.dao.IUsrDao#delete(java.lang.Integer)
	 */
	@Override
	public boolean delete(Integer id) {
		String sql = "delete from usr where id=?";
		pstmt = DB.getStatement(DB.getCon(), sql);
		try {
			pstmt.setInt(1, id);
			return pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeAll(con, pstmt, rs);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.test.dao.IUsrDao#getById(java.lang.Integer)
	 */
	@Override
	public Usr getById(Integer id) {
		String sql = "select id,username,password from usr where id=?";
		Connection con = DB.getCon();
		Usr usr = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				usr = new Usr(rs.getInt("id"), rs.getString("username"),
						rs.getString("password"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeAll(con, pstmt, rs);
		}
		return usr;
	}

}
