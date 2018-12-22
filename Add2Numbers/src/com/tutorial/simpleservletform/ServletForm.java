
/*
    File that take data from index.html
    Counting the result
*/


package com.tutorial.simpleservletform;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletForm
 */

@WebServlet("/ServletForm")
public class ServletForm extends HttpServlet implements IReceiver {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletForm() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstNumber = request.getParameter("firstNumber");
		String secondNumber = request.getParameter("secondNumber");
		MyBigNumber mbn = new MyBigNumber(this);
		String direction = mbn.sum(firstNumber, secondNumber);
		
		response.setContentType("text/plaine");
		PrintWriter out = response.getWriter();
			/*out.println("<!DOCTYPE html>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<html>");
			out.println("<head>");
			out.println("<title> Example </title>");
			out.println("</head>");
			out.println("<body>");*/
			out.println(firstNumber + " + " +  secondNumber );
			//out.println("<br>");
			out.println(step);
			out.println(direction);
			
			//out.println("</body>");
			//out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	String step = "";
	@Override
	public void sendMessage(String message) {
		step += message;
	}

}
