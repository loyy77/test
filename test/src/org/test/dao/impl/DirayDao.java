/**
 * 
 */
package org.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.test.dao.IDirayDao;
import org.test.entity.Diray;
import org.test.util.DB;

/**
 * @author Loyy
 * 
 */
public class DirayDao implements IDirayDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.test.dao.impl.IDirayDao#create(org.test.entity.Diray)
	 */
	@Override
	public boolean create(Diray d) {
		String sql = "insert into diray(title,centent) values(?,?)";
		con = DB.getCon();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, d.getTitle());
			pstmt.setString(2, d.getCentent());
			if(pstmt.executeUpdate()>0){
				return true;
			}
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
	 * @see org.test.dao.impl.IDirayDao#read(java.lang.Integer)
	 */
	@Override
	public Diray read(Integer id) {

		String sql = "select * from diray where id=?";
		con = DB.getCon();
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return new Diray(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeAll(con, pstmt, rs);
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.test.dao.impl.IDirayDao#readList()
	 */
	@Override
	public List<Diray> readList() {
		String sql = "select * from diray";
		con = DB.getCon();
		List<Diray> list = new ArrayList<Diray>();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new Diray(rs.getInt(1), rs.getString(2), rs
						.getString(3)));
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
	 * @see org.test.dao.impl.IDirayDao#update(org.test.entity.Diray)
	 */
	@Override
	public boolean update(Diray d) {
		String sql = "update diray set title=?, centent=? where id=?";

		try {
			con = DB.getCon();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, d.getTitle());
			pstmt.setString(2, d.getCentent());
			pstmt.setInt(3, d.getId());
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
	 * @see org.test.dao.impl.IDirayDao#delete(java.lang.Integer)
	 */
	@Override
	public boolean delete(Integer id) {
		String sql = "delete from diray where id=?";
		try {
			pstmt = DB.getCon().prepareStatement(sql);
			pstmt.setInt(1, id);
			return pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeAll(con, pstmt, rs);
		}
		return false;
	}
}
