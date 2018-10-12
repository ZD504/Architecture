package com.test.architecture1.customermgr.vo;

import com.test.pageutils.Page;
import com.test.pageutils.PageBean;

public class CustomerQueryModel extends CustomerModel {
	private PageBean<CustomerModel> page = new PageBean<CustomerModel>();

	public PageBean<CustomerModel> getPage() {
		return page;
	}

	public void setPage(PageBean<CustomerModel> page) {
		this.page = page;
	}
	
}
