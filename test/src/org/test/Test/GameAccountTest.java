package org.test.Test;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.test.dao.impl.GameAccountDao;
import org.test.entity.GameAccount;
import org.test.entity.Usr;

public class GameAccountTest {
	GameAccountDao d = new GameAccountDao();

	@Test
	public void testCreate() {
		d.create(new GameAccount(new Usr(1), "魔兽世界", "loyy7@gmail.com",
				"12345", "二区-血羽"));
	}

	@Test
	public void testRead() {
		System.out.println("登录名：" + d.read(1).getLoginname());
	}

	@Test
	public void testReadList() {
		List<GameAccount> list = d.readList(10);
		
		for (GameAccount ga : list) {
			System.out.println("list:"+ga.getName());
		}
	}

	@Test
	public void testUpdate() {
		boolean dd=d.update(new GameAccount(1,new Usr(2),"wow","loyy","pwd","mo"));
		System.out.println(dd==true?"success":"shibai");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
