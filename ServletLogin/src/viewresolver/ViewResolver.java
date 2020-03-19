package viewresolver;

import java.util.HashMap;
import java.util.Map;

import constants.PageConstants;
import constants.ViewConstants;

public class ViewResolver {
	private Map<String, String> pages;
	
	public ViewResolver() {
		pages = new HashMap<String, String>() {
			{
			put(ViewConstants.DEFAULT_ERROR_VIEW, PageConstants.DEFAULT_ERROR_PAGE);
			put(ViewConstants.LOGIN_VIEW, PageConstants.LOG_IN_PAGE);
			put(ViewConstants.HOME_VIEW, PageConstants.DEFAULT_HOME_PAGE);	
			
			
			put(ViewConstants.NEW_USERACCOUNT_VIEW, PageConstants.NEW_USERACCOUNT_PAGE);	
			put(ViewConstants.ALL_USERACCOUNT_VIEW, PageConstants.ALL_USERACCOUNT_PAGE);	
			put(ViewConstants.ALL_LOGGEDUSER_VIEW, PageConstants.ALL_LOGGEDUSER_PAGE);

			}
		};
	}
	
	public String getPage(String view) {
		if(pages.containsKey(view)) {
			return pages.get(view);
		}
		return "/";
	}
	
	
}
