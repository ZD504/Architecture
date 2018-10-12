package com.test.pageutils;

import java.util.Collections;
import java.util.List;

public class Page<E> {
	private int pageShow = 2;
	private int totalPage;
	private int totalCount;
	private int start;
	private int nowPage;
	private List<E> result = Collections.emptyList();
	
	private int getStart() {
		start = (getNowPage() -1)*getPageShow();
		if (start <0) {
			start = 0;
		}
		return start;
	}

	public int getPageShow() {
		return pageShow;
	}

	public void setPageShow(int pageShow) {
		this.pageShow = pageShow;
	}

	public int getTotalPage() {
		return (int)Math.ceil(totalCount*1.0/pageShow);
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getNowPage() {
		if(nowPage<=0) {
			nowPage = 1;
		}
		if (nowPage>getTotalPage()) {
			nowPage = getTotalPage();
		}
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public List<E> getResult() {
		return result;
	}

	public void setResult(List<E> result) {
		this.result = result;
	}

	public void setStart(int start) {
		this.start = start;
	}

	@Override
	public String toString() {
		return "Page [pageShow=" + pageShow + ", totalPage=" + totalPage + ", totalCount=" + totalCount + ", start="
				+ start + ", nowPage=" + nowPage + ", result=" + result + "]";
	}
	
	
}
