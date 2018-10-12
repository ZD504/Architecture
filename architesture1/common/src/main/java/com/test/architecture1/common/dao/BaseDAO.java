package com.test.architecture1.common.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

public interface BaseDAO<M, QM> {
	public void create(M cm);
	public void updae(M cm);
	public void delete(int uuid);
	
	public M getByUuid(int uuid);
	public List<M> getByConditionPage(QM qm);
//	public List<M> getByCondition(QM qm);
	
}
