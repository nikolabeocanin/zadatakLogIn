package controller;

import javax.servlet.http.HttpServletRequest;

import abstractaction.AbstractAction;
import actionfactory.ActionFactory;
import constants.ViewConstants;

public class ApplicationController {

	
	public String processRequest(HttpServletRequest request, String path) {
		
		String view = ViewConstants.DEFAULT_ERROR_VIEW;
		AbstractAction action = ActionFactory.createActionFactory(path);
		if(action!=null) {
			view = action.execute(request);
		} else {
			request.setAttribute("error", "Action: " + path + "not mapped");
		}
		return view;
	}
	
}
