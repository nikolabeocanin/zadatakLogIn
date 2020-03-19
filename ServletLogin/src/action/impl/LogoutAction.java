package action.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;

import abstractaction.AbstractAction;
import constants.ViewConstants;
import domain.User;

public class LogoutAction  extends AbstractAction{

	@Override
	public String execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		User user = (User) request.getSession().getAttribute("user");
		List<User> loggedUsers = (List<User>) request.getServletContext().getAttribute("loggedUsers");
		if(user != null) {
			loggedUsers.remove(user);
		}
		request.getServletContext().setAttribute("loggedUsers", loggedUsers);
		request.getSession().invalidate();
		return ViewConstants.LOGIN_VIEW;
	}

	
	
}
