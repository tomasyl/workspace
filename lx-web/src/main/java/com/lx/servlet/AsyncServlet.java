package com.lx.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AsyncServlet", urlPatterns = { "/AsyncServlet" }, asyncSupported = true)
public class AsyncServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2110918387083530819L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("====页面开始====<hr />");
		AsyncContext actx = request.startAsync();
		actx.setTimeout(30 * 3000);
		actx.start(new MyThread(actx));
		out.println("====页面结束====<hr />");
		out.println("</body>");
		out.println("</html>");
		out.flush();
	}
}

class MyThread implements Runnable {
	private AsyncContext actx;

	public MyThread(AsyncContext actx) {
		this.actx = actx;
	}

	public void run() {
		try {
			Thread.sleep(5 * 1000); // 消耗5秒
			actx.dispatch("/async.jsp");
		} catch (Exception e) {
		}
	}
}
