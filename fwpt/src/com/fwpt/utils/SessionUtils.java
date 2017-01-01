package com.fwpt.utils;

import javax.servlet.http.HttpSession;



public class SessionUtils {

	public static String set(HttpSession session, Object object, String juese) {
		if(object!=null){
			session.setAttribute(juese, object);
		}else {
			juese="shibai";
		}
		return juese;
	}

	public static Object getSession(HttpSession session, String string) {
		Object object=session.getAttribute(string);
		return object;
	}

}
