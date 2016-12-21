package com.fwpt.utils;

import javax.servlet.http.HttpSession;



public class SessionUtils {

	public static String set(HttpSession session, Object object, String juese) {
		if(object!=null){
			session.setAttribute("user", object);
		}else {
			juese="shibai";
		}
		return juese;
	}

}
