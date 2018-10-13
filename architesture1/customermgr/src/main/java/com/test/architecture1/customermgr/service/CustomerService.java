package com.test.architecture1.customermgr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.architecture1.common.service.BaseService;
import com.test.architecture1.customermgr.dao.ICustomerDao;
import com.test.architecture1.customermgr.vo.CustomerModel;
import com.test.architecture1.customermgr.vo.CustomerQueryModel;



@Service
@Transactional
public class CustomerService extends BaseService<CustomerModel, CustomerQueryModel> 
				implements ICustomerService{
	private ICustomerDao dao = null;
	@Autowired
	private void setDao(ICustomerDao dao) {
		this.dao = dao;
		super.setDAO(dao);
	}
}
