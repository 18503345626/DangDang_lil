package com.baizhi.inceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

@SuppressWarnings("serial")
public class FrontInceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation ai) throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User u= (User)session.getAttribute("loginUser");
		if(u==null){
			return "loginUser";
		}else if(u!=null){
			
			if(u.getCode()==null||u.getCode().equals("")){
				System.out.println("1111111111+走拦截器else的if里了");
				return "getCode";
			}
			ai.invoke();
		}
		return null;
	}

}
