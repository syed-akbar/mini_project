package login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.service.DAOService;
import login.service.DAOServiceImp;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		DAOService dao = new DAOServiceImp();
		dao.connectdb();
		
		boolean status = dao.verifylogin(email, password);
	    if (status==true) {
	    	HttpSession session = request.getSession(true);
	    	session.setAttribute("email", email);
	    	request.setAttribute("msg", "Welcom");
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/create.jsp");
			rd.forward(request, response);
			
		} else {
			request.setAttribute("error", "Invalid email/password");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			
	
			


		}
		
		
	}

}
