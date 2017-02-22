package com.tal.util.page;

import java.io.Serializable;
import java.util.List;

public class PageObject <T> implements Serializable {
	private static final long serialVersionUID = 1L;

	private long total = 0;

	private List<T> rows = null;
	
	public PageObject() {
		super();
	}

	public PageObject(long total, List<T> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
