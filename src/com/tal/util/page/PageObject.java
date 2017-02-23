package com.tal.util.page;

import java.io.Serializable;
import java.util.List;

public class PageObject <T> implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long recordsFiltered = 0;
    
	private long recordsTotal = 0;


	public long getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	private List<T> data = null;
	
	public PageObject() {
		super();
	} 

	public PageObject(long recordsTotal, List<T> data) {
		super();
		this.recordsTotal = recordsTotal;
		this.data = data;
		this.recordsFiltered = recordsTotal;
	}

}
