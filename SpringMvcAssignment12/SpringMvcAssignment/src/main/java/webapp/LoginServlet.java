package webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

	String accHolderName;
	String accID;
	String withdrawAmount;
    double balance=1000;
    
    @Controller
    public class Logincontroller {

    	@RequestMapping("/login")
    	public String sayHello() {
    		return "login";
    	}	
    	@RequestMapping(path="/btnSubmitClick", method =RequestMethod.POST)

    	 public String registerButton(@ModelAttribute LoginServlet ls, Model model)

    	 {
             return "error_page";
    }
    	
    }
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		 
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
	
	@Override
	protected void  doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		accHolderName= request.getParameter("name");
		accID = request.getParameter("id");
		withdrawAmount = request.getParameter("amt");
		
		if(Integer.parseInt(withdrawAmount)> balance) {
			/*request.setAttribute("name", name);
			request.setAttribute("password", password);*/
			request.setAttribute("print", "Insufficient Balance");
			request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
		}else {
			
			request.setAttribute("balance", balance);
			request.setAttribute("print", "Transaction Successful");
			
			request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
		}
	}

	
    @ExceptionHandler(value=Exception.class)
	public String exceptionhandlerOutOfBound(Model m) {
	    m.addAttribute("msg" , "Out Of Bound Exception" );
	    return "error_page";
	}

}
