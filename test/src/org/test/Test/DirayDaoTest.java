package org.test.Test;

import java.util.Date;
import java.util.Iterator;

import org.junit.BeforeClass;
import org.junit.Test;
import org.test.dao.IDirayDao;
import org.test.dao.impl.DirayDao;
import org.test.entity.Diray;
import org.test.entity.Usr;

public class DirayDaoTest {
	IDirayDao dd = new DirayDao();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@SuppressWarnings("deprecation")
	@Test
	public void testCreate() {
		for (int i = 1; i < 37; i++) {
			dd.create(new Diray("diray" + i, (new Date().toLocaleString()),new Usr(123),new Diray().getPublishtime()));
		}
	}

	@Test
	public void testRead() {
		for (int i = 1; i < 37; i++) {
			if (dd.read(i) != null) {
				System.out.println(dd.read(i).getTitle());
			}
		}

	}

	@Test
	public void testReadList() {
		Iterator<Diray> it = dd.readList(0).iterator();
		while (it.hasNext()) {
			System.out.println(it.next().getTitle());
		}
	}

	@Test
	public void testUpdate() {

		dd.update(new Diray(1, "hhh", "cccc"));
	}

	@Test
	public void testDelete() {
		dd.delete(2);
	}

}
