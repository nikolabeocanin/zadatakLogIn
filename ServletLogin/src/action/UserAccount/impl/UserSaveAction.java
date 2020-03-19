package action.UserAccount.impl;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import abstractaction.AbstractAction;
import constants.ViewConstants;


import domain.User;



public class UserSaveAction extends AbstractAction{

	@Override
	public String execute(HttpServletRequest request) {
	
		// TODO Auto-generated method stub
		String view = ViewConstants.NEW_USERACCOUNT_VIEW;
		boolean signal = true;

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		if(name.isEmpty()) {
			signal = false;
			request.setAttribute("nameError", "Name cannot be empty");
		}
		if(password.isEmpty()) {
			signal = false;
			request.setAttribute("passwordError", "Password cannot be empty");
		}
		if(firstname.isEmpty()) {
			signal = false;
			request.setAttribute("firstnameError", "First name cannot be empty");
		}
		if(lastname.isEmpty()) {
			signal = false;
			request.setAttribute("lastnameError", "Last name cannot be empty");
		}
		
		User user = new User(name, password, firstname, lastname);
		List<User> users = (List<User>) request.getServletContext().getAttribute("users");
	
		
		if(signal) {
			
			if(users.contains(user)) {
				request.setAttribute("userExistsError", "Account already exists!");
				request.setAttribute("name", request.getParameter("name"));
			}
			else {
				users.add(user);
				request.getServletContext().setAttribute("users",  users);
				view = ViewConstants.ALL_USERACCOUNT_VIEW;
				
				
			}
		} else {
			request.setAttribute("name", request.getParameter("name"));
		}
		
		
		return view;
		
	}

}
