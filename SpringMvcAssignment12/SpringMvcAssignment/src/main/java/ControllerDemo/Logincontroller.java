package ControllerDemo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import webapp.LoginServlet;


@Controller
public class Logincontroller {
	
	String accHolderName= "amithkumar";
	String accID ="1";
	String withdrawAmount;
    double balance=10000;


	/*@RequestMapping("/login")
	public String sayHello() {
		return "login";
	}*/	
	@RequestMapping(path="/btnSubmitClick", method =RequestMethod.POST)
	
		/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			 
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}*/
	

		protected void  doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			
			accHolderName= request.getParameter("name");
			accID = request.getParameter("id");
			withdrawAmount = request.getParameter("amt");
			
			if(accHolderName.equals("shivani") && accID.equals("1")) {
				request.setAttribute("validmsg", "Account is Authenticated and Valid");
				request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
			}else {
				request.setAttribute("invalidmsg", "Account is not valid...Try Again");
				request.getRequestDispatcher("/WEB-INF/views/error_page.jsp").forward(request, response);
			}
				
			
			
			if(Integer.parseInt(withdrawAmount)> balance) {
				/*request.setAttribute("name", name);
				request.setAttribute("password", password);*/
				request.setAttribute("msg", "Insufficient Balance");
				request.getRequestDispatcher("/WEB-INF/views/error_page.jsp").forward(request, response);
	
			}else {
				
				request.setAttribute("balance", "Rupees" +withdrawAmount);
				request.setAttribute("print", "Transaction Successful");
				
				request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
			}
		}
	
		
	    @ExceptionHandler(value=Exception.class)
		public String lowBalanceException(Model m) {
		    m.addAttribute("msg" , "Insufficient Balance" );
		    return "error_page";
		}
	    
	    @ExceptionHandler(value=Exception.class)
	    public String AccountNotFoundException(Model e) {
	    	e.addAttribute("accmsg", "Account is Not Valid");
	    	return "error_page";
	    }

	}

