package com.test.architecture1.common.service;

import java.util.List;

import com.test.architecture1.common.vo.BaseModel;
import com.test.pageutils.PageBean;

public interface IBaseService<M,QM extends BaseModel> {
	public void create(M cm);
	public void updae(M cm);
	public void delete(int uuid);
	
	public M getByUuid(int uuid);
	public PageBean<M> getByConditionPage(QM qm);
}
