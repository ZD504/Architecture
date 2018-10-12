package com.test.architecture1.customermgr.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.architecture1.common.dao.BaseDAO;
import com.test.architecture1.customermgr.vo.CustomerModel;
import com.test.architecture1.customermgr.vo.CustomerQueryModel;

@Repository
public interface ICustomerDao extends BaseDAO<CustomerModel, CustomerQueryModel> {

}
