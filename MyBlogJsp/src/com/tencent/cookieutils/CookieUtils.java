package com.tencent.cookieutils;

import javax.servlet.http.Cookie;

public class CookieUtils {
	public static Cookie getCookieByName(String name, Cookie[] c) {
		if(c != null) {
			for (Cookie cookie : c) {
				if(cookie.getName().equals(name)) {
					return cookie;
				}
			}
		} 
		return null;
	}
}
