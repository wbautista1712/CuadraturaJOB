package com.cuadratura.app.response;

import java.io.Serializable;
import java.util.List;

import com.cuadratura.app.util.Constantes;





public class ListResponse implements Serializable {
	
	/**
	 * 
	 */
    private static final long serialVersionUID = -2709815798677347114L;
	private Integer page;
	private Integer total;
	private Integer records;
	private List rows;
	
	public ListResponse() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public ListResponse(Integer page, Integer total, Integer records, List rows) {
		super();
		this.page = page;
		this.total = total;
		this.records = records;
		this.rows = rows;
	}
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getRecords() {
		return records;
	}
	public void setRecords(Integer records) {
		this.records = records;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	
	
	public Integer getStart(Integer page, Integer rows) {
		if(page == null) {
			page = 1;
		}
		rows = (rows == null) ? Constantes.NUMBER_ROWS_BY_PAGE : rows;
		Integer start = (rows * (page - 1));
		return start;
	}

	public ListResponse getPaginador(Integer page, Integer rows,
			Integer records, List result) {
		if(page == null) {
			page = 1;
		}
		rows = (rows == null) ? Constantes.NUMBER_ROWS_BY_PAGE : rows;
		int totalPage = records / rows;
		int mod = records % rows;
		totalPage = (mod > 0) ? (totalPage + 1) : totalPage;
		return new ListResponse(page, totalPage, records, result);
	}
	
	
}
