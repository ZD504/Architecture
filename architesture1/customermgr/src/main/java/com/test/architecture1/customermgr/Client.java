package com.test.architecture1.customermgr;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.test.architecture1.customermgr.dao.ICustomerDao;
import com.test.architecture1.customermgr.vo.CustomerModel;
import com.test.architecture1.customermgr.vo.CustomerQueryModel;

@Service
public class Client {

	@Autowired
	private ICustomerDao dao = null;
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Client tClient = (Client) ctx.getBean("client"); //此处要小写client
		
		CustomerModel cm = new CustomerModel();
		cm.setCustomerId("c1");
		cm.setShowName("c1");
		cm.setTrueName("张三");
		cm.setRegisterTime("2018-05-22");
		cm.setPwd("c1");
		tClient.dao.create(cm);
		
		List<CustomerModel> list = tClient.dao.getByCondition(new CustomerQueryModel());
		System.out.println("List=" + list);
	}
}
