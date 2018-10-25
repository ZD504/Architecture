package com.test.architecture1.customermgr.service;

import com.test.architecture1.common.service.IBaseService;
import com.test.architecture1.customermgr.vo.CustomerModel;
import com.test.architecture1.customermgr.vo.CustomerQueryModel;

public interface ICustomerService extends IBaseService<CustomerModel, CustomerQueryModel>{

	CustomerModel getByCustomerId(String customerId);

}
