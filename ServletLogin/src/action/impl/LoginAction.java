package action.impl;



import javax.servlet.http.HttpServletRequest;


import abstractaction.AbstractAction;

import constants.ViewConstants;




public class LoginAction extends AbstractAction {

	@Override
	public String execute(HttpServletRequest request) {
		
	return ViewConstants.LOGIN_VIEW;

}
}
