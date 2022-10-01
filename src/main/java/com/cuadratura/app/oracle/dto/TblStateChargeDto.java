package com.cuadratura.app.oracle.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import java.util.Date;


public class TblStateChargeDto implements Serializable {

    private static final long serialVersionUID = 1L;
   
    private BigDecimal idStateCharge; 
    private String loadTable;
    private String stateCharge;
    private String stateSend;  
    private Integer initCountSource; 
    private BigDecimal initSumSource;
    
    private Integer endCountTarget;    
    private Integer endCountSource;    
    private BigDecimal endSumTarget;
   
    private String errorDes; 
    private Date loadDate;   
    private Date initLoad;
   
    private Date endLoad;  
    private Long orgLvlChild;
    
    public TblStateChargeDto() {
		// TODO Auto-generated constructor stub
	}
    
    

	public TblStateChargeDto(BigDecimal idStateCharge, String loadTable, String stateCharge, String stateSend,
			Integer initCountSource, BigDecimal initSumSource, Integer endCountTarget, Integer endCountSource,
			BigDecimal endSumTarget, String errorDes, Date loadDate, Date initLoad, Date endLoad, Long orgLvlChild) {
		super();
		this.idStateCharge = idStateCharge;
		this.loadTable = loadTable;
		this.stateCharge = stateCharge;
		this.stateSend = stateSend;
		this.initCountSource = initCountSource;
		this.initSumSource = initSumSource;
		this.endCountTarget = endCountTarget;
		this.endCountSource = endCountSource;
		this.endSumTarget = endSumTarget;
		this.errorDes = errorDes;
		this.loadDate = loadDate;
		this.initLoad = initLoad;
		this.endLoad = endLoad;
		this.orgLvlChild = orgLvlChild;
	}



	public BigDecimal getIdStateCharge() {
		return idStateCharge;
	}

	public void setIdStateCharge(BigDecimal idStateCharge) {
		this.idStateCharge = idStateCharge;
	}

	public String getLoadTable() {
		return loadTable;
	}

	public void setLoadTable(String loadTable) {
		this.loadTable = loadTable;
	}

	public Object getStateCharge() {
		return stateCharge;
	}

	public void setStateCharge(String stateCharge) {
		this.stateCharge = stateCharge;
	}

	public String getStateSend() {
		return stateSend;
	}

	public void setStateSend(String stateSend) {
		this.stateSend = stateSend;
	}

	public Integer getInitCountSource() {
		return initCountSource;
	}

	public void setInitCountSource(Integer initCountSource) {
		this.initCountSource = initCountSource;
	}

	public BigDecimal getInitSumSource() {
		return initSumSource;
	}

	public void setInitSumSource(BigDecimal initSumSource) {
		this.initSumSource = initSumSource;
	}

	public Integer getEndCountTarget() {
		return endCountTarget;
	}

	public void setEndCountTarget(Integer endCountTarget) {
		this.endCountTarget = endCountTarget;
	}

	public Integer getEndCountSource() {
		return endCountSource;
	}

	public void setEndCountSource(Integer endCountSource) {
		this.endCountSource = endCountSource;
	}

	public BigDecimal getEndSumTarget() {
		return endSumTarget;
	}

	public void setEndSumTarget(BigDecimal endSumTarget) {
		this.endSumTarget = endSumTarget;
	}

	public String getErrorDes() {
		return errorDes;
	}

	public void setErrorDes(String errorDes) {
		this.errorDes = errorDes;
	}

	public Date getLoadDate() {
		return loadDate;
	}

	public void setLoadDate(Date loadDate) {
		this.loadDate = loadDate;
	}

	public Date getInitLoad() {
		return initLoad;
	}

	public void setInitLoad(Date initLoad) {
		this.initLoad = initLoad;
	}

	public Date getEndLoad() {
		return endLoad;
	}

	public void setEndLoad(Date endLoad) {
		this.endLoad = endLoad;
	}

	public Long getOrgLvlChild() {
		return orgLvlChild;
	}

	public void setOrgLvlChild(Long orgLvlChild) {
		this.orgLvlChild = orgLvlChild;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	} 
    
 
}
