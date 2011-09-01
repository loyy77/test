package org.test.Test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.test.dao.IUsrDao;
import org.test.dao.impl.UsrDao;
import org.test.entity.Usr;

public class UsrDaoTest {


	/**
	 * 
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testCreateUsr() {
		IUsrDao ud=new UsrDao();
		for(int i=0;i<47;i++){
		
				ud.createUsr(new Usr("loyy"+new Date().getSeconds(),"123"));
		
		}
		
	}

	/**
	 * 
	 */
	@Test
	public void testRead() {
		IUsrDao ud=new UsrDao();
		List<Usr> list=ud.read();
		for(int i=0;i<list.size();i++){
			Usr u=(Usr)list.get(i);
			System.out.println(u.getUsrname());
		}
	}

	/**
	 * 
	 */
	@Test
	public void testUpdate() {
		IUsrDao ud=new UsrDao();
		for(int i=1;i<10;i++){
			ud.update(new Usr(i,"new_loyy","321"));
		}
		
	}

	/**
	 * 
	 */
	@Test
	public void testDelete() {
		IUsrDao ud=new UsrDao();
		for(int i=1;i<10;i++){
			ud.delete(i);
		}
	}

}
