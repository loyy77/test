package org.test.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.test.dao.IUsrDao;
import org.test.dao.impl.UsrDao;
import org.test.entity.Usr;

/**
 * Servlet implementation class UsrServlet
 */
public class UsrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUsrDao ud = new UsrDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsrServlet() {
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

		if (request.getParameter("op") != null) {
			op = request.getParameter("op");
		}

		System.out.println("op:" + op);

		if (op.equals("read")) {
			this.doRead(request, response);
		} else if (op.equals("toupdate")) {
			this.toUpdate(request, response);
		} else if (op.equals("delete")) {
			this.doDelete(request, response);
		} else if ("update".equals(op)) {
			this.doUpdate(request, response);
		} else if ("create".equals(op)) {
			this.doCreate(request, response);
		} else if ("login".equals(op)) {
			this.doLogin(request, response);
		}

	}

	protected void doCreate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ud.createUsr(new Usr(request.getParameter("username"), request
				.getParameter("password")));
		response.sendRedirect("login.jsp");

	}

	protected void doRead(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<Usr> list = ud.read();
		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		response.sendRedirect("index.jsp");

	}

	protected void doDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer id = new Integer(request.getParameter("id"));
		ud.delete(id);
		response.sendRedirect("login.jsp");
	}

	protected void toUpdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer id = new Integer(request.getParameter("id"));

		Usr usr = ud.getById(id);
		HttpSession s = request.getSession();
		s.setAttribute("u", usr);
		response.sendRedirect("update.jsp");
	}

	protected void doUpdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Integer id = new Integer(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Usr user = new Usr(id, username, password);
		ud.update(user);
		response.sendRedirect("login.jsp");
	}

	protected void doLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (ud.Login(new Usr(username, password))) {
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}
	}

}
