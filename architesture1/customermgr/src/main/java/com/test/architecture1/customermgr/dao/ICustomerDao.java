package com.test.architecture1.customermgr.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.architecture1.customermgr.vo.CustomerModel;
import com.test.architecture1.customermgr.vo.CustomerQueryModel;

@Repository
public interface ICustomerDao {
	public void create(CustomerModel cm);
	public void updae(CustomerModel cm);
	public void delete(int uuid);
	
	public CustomerModel getByUuid(int uuid);
	public List<CustomerModel> getByCondition(CustomerQueryModel customerQueryModel);
	
}
