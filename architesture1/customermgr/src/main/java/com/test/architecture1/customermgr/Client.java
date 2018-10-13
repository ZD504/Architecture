package com.test.architecture1.customermgr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.test.architecture1.customermgr.service.ICustomerService;
import com.test.architecture1.customermgr.vo.CustomerModel;
import com.test.architecture1.customermgr.vo.CustomerQueryModel;
import com.test.pageutils.PageBean;

@Service
public class Client {

	@Autowired
//	private ICustomerDao dao = null;
	private ICustomerService s = null;
	
	public ICustomerService getS() {
		return s;
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Client tClient = (Client) ctx.getBean("client"); //此处要小写client
		
		CustomerModel cm = new CustomerModel();
		cm.setCustomerId("c1");
		cm.setShowName("c1");
		cm.setTrueName("张三");
		cm.setRegisterTime("2018-05-22");
		cm.setPwd("c1");
//		tClient.dao.create(cm);
		
		CustomerQueryModel cqm = new CustomerQueryModel();
		cqm.getPage().setPage(1);
		
		
//		List<CustomerModel> list = tClient.dao.getByConditionPage(cqm);
//		PageBean<CustomerModel> p = tClient.s.getByConditionPage(cqm);
		PageBean<CustomerModel> p = tClient.getS().getByConditionPage(cqm);
		System.out.println("page==" + cqm.getPage());
//		System.out.println("List=" + list);
		System.out.println("CM=" + tClient.toString());
	}
}
