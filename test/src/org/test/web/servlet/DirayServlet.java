package org.test.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.test.dao.IDirayDao;
import org.test.dao.impl.DirayDao;
import org.test.entity.Diray;

/**
 * Servlet implementation class DirayServlet
 */
public class DirayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IDirayDao dd = new DirayDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DirayServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String op = "read";
		if (request.getParameter("op") != null) {
			op = request.getParameter("op");

		}
		System.out.println("op:" + op);
		if ("create".equals(op)) {
			this.doCreate(request, response);
		}else if("readlist".equals(op)){
			this.doReadList(request, response);
		}

	}

	protected void doCreate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in!!!!");
		String title = request.getParameter("title");
		String centent = request.getParameter("centent");
		PrintWriter out = response.getWriter();

		if (dd.create(new Diray(title, centent))) {
			// out.print("success");
			response.sendRedirect("index.jsp");
			out.print("<script type='text/javascript'>location.href='index.jsp'<script>");
			// request.setAttribute("res", "发表成功！");
		}
		out.close();
	}

	protected void doReadList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		java.util.List<Diray> list = dd.readList();
		String string=new ObjectMapper().writeValueAsString(list);
		PrintWriter out=response.getWriter();
		System.out.println(string);
		out.print(string);
		out.close();
		
	}

}
