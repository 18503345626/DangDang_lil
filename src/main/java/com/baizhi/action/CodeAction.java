package com.baizhi.action;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.util.SecurityCode;
import com.baizhi.util.SecurityImage;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class CodeAction extends ActionSupport{
	   public String getCode(){
	    	String code=SecurityCode.getSecurityCode();
	    	HttpServletRequest req = ServletActionContext.getRequest();
	    	HttpSession session=req.getSession();
	    	session.setAttribute("code", code);
	    	BufferedImage img=SecurityImage.createImage(code);
	    	ServletOutputStream stream=null;
	    	try {
				stream=ServletActionContext.getResponse().getOutputStream();
				ImageIO.write(img, "png", stream);
			} catch (Exception e) {
				
			}
	    	return null;
	    }

}
