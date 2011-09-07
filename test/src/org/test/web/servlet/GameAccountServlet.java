package org.test.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.test.dao.IGameAccountDao;
import org.test.dao.impl.GameAccountDao;
import org.test.entity.GameAccount;
import org.test.entity.Usr;

import com.sun.corba.se.impl.orbutil.ObjectWriter;

/**
 * Servlet implementation class GameAccountServlet
 */
public class GameAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IGameAccountDao gd = new GameAccountDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GameAccountServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String op = "read";
		String o = request.getParameter("op");

		if (o != null) {
			op = o;
		}

		if ("create".equals(op)) {
			this.doCreate(request, response);
		} else if ("readlist".equals(op)) {
			this.doReadList(request, response);
		}
	}

	protected void doCreate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("创建。。");
		String gamename = request.getParameter("gamename");
		String loginname = request.getParameter("loginname");
		String loginpwd = request.getParameter("loginpwd");
		String mark = request.getParameter("mark");

		HttpSession session = request.getSession();
		Usr usr = (Usr) session.getAttribute("usr");
		GameAccount ga = new GameAccount(usr, gamename, loginname, loginpwd,
				mark);
		PrintWriter out = response.getWriter();
		if (gd.create(ga)) {
			out.print("<script type=\"text/javascript\">alert('添加成功！');</script>");
		} else {
			// out.print("fail");
			out.print("<script type=\"text/javascript\">alert('添加失败！');</script>");
		}

	}

	protected void doReadList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doReadList..");
		response.setContentType("json;charset=utf-8");
		Integer uid=-1;
		HttpSession session = request.getSession();
		Usr usr = (Usr) session.getAttribute("usr");
		if(usr!=null)
		uid=usr.getId();
		List<GameAccount> list = gd.readList(uid);
		String result_json = new ObjectMapper().writeValueAsString(list);
		System.out.println("json:" + result_json);
		PrintWriter out = response.getWriter();
		out.print(result_json);
		
		

	}
}
