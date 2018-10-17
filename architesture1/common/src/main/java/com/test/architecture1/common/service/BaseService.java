package com.test.architecture1.common.service;

import java.util.List;

import com.test.architecture1.common.dao.BaseDAO;
import com.test.architecture1.common.vo.BaseModel;
import com.test.pageutils.PageBean;

public class BaseService<M, QM extends BaseModel> implements IBaseService<M, QM> {
	private BaseDAO dao = null;

	public void setDAO(BaseDAO dao) {
		this.dao = dao;
	}

	public void create(M cm) {
		dao.create(cm);
	}

	public void update(M cm) {
		dao.update(cm);
	}

	public void delete(int uuid) {
		dao.delete(uuid);
	}

	public M getByUuid(int uuid) {
		return (M) dao.getByUuid(uuid);
	}

	public PageBean<M> getByConditionPage(QM qm) {
		List<M> list = dao.getByConditionPage(qm);
		qm.getPage().setResult(list);
		return qm.getPage();
	}

}
