package action.UserAccount.impl;

import javax.servlet.http.HttpServletRequest;

import abstractaction.AbstractAction;
import constants.ViewConstants;
import domain.User;

public class UserNewAction extends AbstractAction {

	@Override
	public String execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String view = ViewConstants.NEW_USERACCOUNT_VIEW;
		User user = (User) request.getSession().getAttribute("user");
		if(user == null) {
			request.setAttribute("loggedError", "Action not allowed! Need to login!");
			view = ViewConstants.HOME_VIEW;
		}
		return view;
	}

}
