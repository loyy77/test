package org.test.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		String op = "read!!!!!!!Ä¬ÈÏ£¡£¡";
		if (request.getParameter("op") != null) {
			op = request.getParameter("op");

		}
		System.out.println("op:" + op);
		if ("create".equals(op)) {
			this.doCreate(request, response);
		} else if ("readlist".equals(op)) {
			this.doReadList(request, response);
		} else if ("toupdate".equals(op)) {

			Integer id = new Integer(request.getParameter("id"));
			Diray d = dd.read(id);
			// request.setAttribute("title", d.getTitle());
			// request.setAttribute("centent", d.getCentent());
			// request.setAttribute("id", d.getId());
			String jsonString = new ObjectMapper().writeValueAsString(d);
			HttpSession session = request.getSession();
			session.setAttribute("d", d);
			System.out.println(jsonString);
			response.sendRedirect("diray/update.jsp");
			// request.getRequestDispatcher("diray/update.jsp");
			// PrintWriter out=response.getWriter();
			// out.print("<script type='text/javascript'>location.href='update.html?id="+id+"';alert('hehe');<script>");
			// response.setContentType("json;charset=utf-8");
			// out.print(jsonString);

			// out.print(jsonString);
			// out.close();

		} else if ("update".equals(op)) {
			this.doUpdate(request, response);
		} else if ("delete".equals(op)) {
			this.doDelete(request, response);
		}

	}

	protected void doCreate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in!!!!");
		String title = request.getParameter("title");
		String centent = request.getParameter("centent");
		PrintWriter out = response.getWriter();

		if (dd.create(new Diray(title, centent))) {

			// response.sendRedirect("index.jsp");
			out.print("<script type='text/javascript'>location.href='index.jsp'<script>");

		}
		out.close();
	}

	protected void doReadList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("json;charset=utf-8");
		java.util.List<Diray> list = dd.readList();
		String string = new ObjectMapper().writeValueAsString(list);
		PrintWriter out = response.getWriter();
		System.out.println("json:" + string);
		out.print(string);
		out.close();

	}

	protected void doUpdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer id = new Integer(request.getParameter("id"));
		String title = request.getParameter("title");
		String centent = request.getParameter("centent");
		if (dd.update(new Diray(id, title, centent))) {
			PrintWriter out = response.getWriter();
			out.print("success");
			out.close();
		}
	}

	protected void doDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer id = new Integer(request.getParameter("id"));
		if (dd.delete(id)) {
			response.sendRedirect("diray/dirylist.html");
			System.out.println("É¾³ý³É¹¦");
			PrintWriter out = response.getWriter();
			out.print("<script type='text/javascript'>location.href='frame_right.html'<script>");
			out.close();
		}
	}

}
