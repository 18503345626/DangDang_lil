package com.baizhi.inceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

@SuppressWarnings("serial")
public class BackInceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation ai) throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Object obj = session.getAttribute("loginAdmin");
		if(obj!=null){
			ai.invoke();
		}
		return "loginAdmin";
	}

}
