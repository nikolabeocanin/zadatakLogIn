package action.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;

import abstractaction.AbstractAction;
import constants.ViewConstants;
import domain.User;
import exception.IllegalObjectException;
import exception.PasswordNotValidException;
import exception.UsernameNotValidException;
import validator.impl.UserValidator;

public class LoginVerificationAction extends AbstractAction {

	@Override
	public String execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String view = ViewConstants.LOGIN_VIEW;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
				
		User user = new User(username,password);
		
		UserValidator userValidator = new UserValidator();
		boolean signal = false;
		try {
			userValidator.test(user);
		} catch (IllegalObjectException e) {
			request.setAttribute("illegal", e.getMessage());
		} catch (UsernameNotValidException e) {
			// TODO Auto-generated catch block
			request.setAttribute("errorUsername", e.getMessage());
			signal = true;
		} catch (PasswordNotValidException e) {
			// TODO Auto-generated catch block
		
			request.setAttribute("errorPassword", e.getMessage());
			signal = true;
		} catch (IllegalArgumentException e){
			request.setAttribute("errorUsername", "Username  cannot be empty");
			request.setAttribute("errorPassword", "Password  cannot be empty");
			signal = true;
		}
		
	List<User> users = (List<User>) request.getServletContext().getAttribute("users");
	List<User> loggedUsers = (List<User>) request.getServletContext().getAttribute("loggedUsers");
	
	if(loggedUsers.contains(user)) {
		request.setAttribute("loginError", "User already logged in");
		signal = true;
	}
	
	if(!signal) {
		if(request.getSession().getAttribute("user") == null) {
		for(User u: users) {
			if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
				List<User> loggedList = (List<User>) request.getServletContext().getAttribute("loggedUsers");
				if(!loggedList.contains(u)) {
				loggedList.add(u);
				}		
				request.getSession().setAttribute("user", u);
				view =  ViewConstants.HOME_VIEW;
				signal = true;
			}
			
		}
		} else {
			signal = true;
			request.setAttribute("loginError", "User already logged in");
		}
		if(!signal) {
			request.setAttribute("loginError", "Wrong username / password");
		}
	}
		
	
		
		return view;
	}
	}


