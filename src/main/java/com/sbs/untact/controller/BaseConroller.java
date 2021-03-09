package com.sbs.untact.controller;

import javax.servlet.http.HttpServletRequest;

public class BaseConroller {
	protected String msgAndBack(HttpServletRequest req, String msg) {
		req.setAttribute("historyBack", true);
		req.setAttribute("msg", msg);
		return "common/redirect";
	}
}
