package com.cuadratura.app.oracle.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@Data
@ToString
@RequiredArgsConstructor
@Table(name = "TBL_STATE_CHARGE", schema = "CUADRATURAWYP")

public class TblStateCharge implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_STATE_CHARGE")
    private BigDecimal idStateCharge;
    @Column(name = "LOAD_TABLE")
    private String loadTable;
    @Column(name = "STATE_CHARGE")
    private String stateCharge;
    @Column(name = "STATE_SEND")
    private String stateSend;
    @Column(name = "INIT_COUNT_SOURCE")
    private BigInteger initCountSource;
    @Column(name = "INIT_SUM_SOURCE")
    private BigDecimal initSumSource;
    @Column(name = "END_COUNT_TARGET")
    private BigInteger endCountTarget;
    @Column(name = "END_COUNT_SOURCE")
    private BigInteger endCountSource;
    @Column(name = "END_SUM_TARGET")
    private BigDecimal endSumTarget;
    @Column(name = "ERROR_DES")
    private String errorDes;
    @Column(name = "LOAD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date loadDate;
    @Column(name = "INIT_LOAD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date initLoad;
    @Column(name = "END_LOAD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endLoad;

    
}
