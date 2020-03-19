package actionfactory;

import abstractaction.AbstractAction;
import action.UserAccount.impl.UserAllAction;
import action.UserAccount.impl.UserLoggedAction;
import action.UserAccount.impl.UserNewAction;
import action.UserAccount.impl.UserSaveAction;
import action.impl.LoginAction;
import action.impl.LoginVerificationAction;
import action.impl.LogoutAction;


public class ActionFactory {

	public static AbstractAction createActionFactory(String path) {
		AbstractAction action = null;
		if(path.equalsIgnoreCase("/login")) {
			action = new LoginAction();
		}
		if(path.equalsIgnoreCase("/loginvalidation")) {
			action = new LoginVerificationAction();
		}
		if(path.equalsIgnoreCase("/logout")) {
			action = new LogoutAction();
		
		}

		if(path.equalsIgnoreCase("/users/add")) {
			action = new UserNewAction();
		
		}
		if(path.equalsIgnoreCase("/users/save")) {
			action = new UserSaveAction();
		
		}

		if(path.equalsIgnoreCase("/users/all")) {
			action = new UserAllAction();
		
		}
		if(path.equalsIgnoreCase("/users/login")) {
			action = new UserLoggedAction();
		
		}
		
		return action;
	}

}
