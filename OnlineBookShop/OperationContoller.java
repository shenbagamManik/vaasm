package day14_Activities;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class OperationContoller
 */
@WebServlet("/OperationContoller")
public class OperationContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String opration = 	request.getParameter("add");
	ArithmaticBean bean = new ArithmaticBean();
	HttpSession session = request.getSession();
	
	bean.setNum1(Integer.parseInt(request.getParameter("num1")));
	bean.setNum2(Integer.parseInt(request.getParameter("num2")));
	
		switch(opration) {
		case "Add": int result = bean.add();
					session.setAttribute("num1", request.getParameter("num1"));
					session.setAttribute("result", result);
					response.sendRedirect("index.jsp");
					break;
		case "Subtract":break;
		case "Multiply":break;
		case "Divid":break;
		
		}
	
	}

}
