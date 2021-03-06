package com.test.front.architecture1;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.architecture1.customermgr.service.ICustomerService;
import com.test.architecture1.customermgr.vo.CustomerModel;


@Controller
@RequestMapping("/")
public class LoginController {
	@Autowired
	private ICustomerService ics = null;
	
	@Autowired
	private SecurityManager sm = null;
	
	@RequestMapping(value="/toLogin",method=RequestMethod.GET)
	public String toLogin(){
		return "login";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam("customerId")String customerId
			,@RequestParam("pwd")String pwd,HttpServletResponse response){
		
		if(customerId==null || customerId.trim().length()==0){
			return "login";
		}
		ics.getByUuid(1);
		CustomerModel cm = ics.getByCustomerId(customerId);
		
		if(cm==null || cm.getUuid()<=0){
			return "login";
		}
		
		//单点登录功能
		SecurityUtils.setSecurityManager(sm);
		Subject currentUser = SecurityUtils.getSubject();
		
		currentUser.getSession().setAttribute("Login_Customer", cm);

		System.out.println("cm===="+cm);
		
		Cookie c = new Cookie("MyLogin",cm.getUuid()+","+System.currentTimeMillis());
		response.addCookie(c);
		
		return "redirect:/toIndex";
	}
}
