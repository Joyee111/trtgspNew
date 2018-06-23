package com.sinosoft.util;

import javax.servlet.http.HttpServletRequest;

public class DisplayGetPage {

	public static String getPageParamName(String id, HttpServletRequest request) {
		String str = new org.displaytag.util.ParamEncoder(id)
				.encodeParameterName(org.displaytag.tags.TableTagParameters.PARAMETER_PAGE);

		String page = request.getParameter(str);
		if (null == page || "null".equals(page)) {
			page = "1";
		}
		return page;
	}
	
	
	public static String getPageName(String id, HttpServletRequest request) {
		String str = new org.displaytag.util.ParamEncoder(id)
				.encodeParameterName(org.displaytag.tags.TableTagParameters.PARAMETER_PAGE);

		return str;
	}

}
