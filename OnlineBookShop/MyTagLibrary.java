package day14_Activities;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Servlet implementation class MyTagLibrary
 */
@WebServlet("/MyTagLibrary")
public class MyTagLibrary extends TagSupport {
private static final long serialVersionUID = 1L;
	String mainStr;
	
	public void setMainStr(String mainStr) {
		this.mainStr = mainStr;
	}
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		String subStr = null;
		try {
			
			subStr = mainStr.substring(5);
			out.print(subStr);
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		
		return SKIP_BODY;
	}

}
