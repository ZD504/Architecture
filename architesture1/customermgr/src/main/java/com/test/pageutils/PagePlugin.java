package com.test.pageutils;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.Properties;
import java.lang.reflect.Field;

import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;

public class PagePlugin implements Interceptor {
	private static String dialect = "";
	private static String pageSqlId = "";
	
	public Object intercept(Invocation ivk) throws Throwable {
		if (ivk.getTarget() instanceof RoutingStatementHandler) {
			RoutingStatementHandler statementHandler = (RoutingStatementHandler) ivk.getTarget();
//			BaseStatementHandler delegate = (BaseStatementHandler) ReflectHelper.getValueByFieldName(statementHandler);
		}
		return null;
	}

	public Object plugin(Object target) {

		return null;
	}

	public void setProperties(Properties properties) {

	}

}
