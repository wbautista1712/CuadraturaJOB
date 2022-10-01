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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
@Table(name = "PRDPCDEE", schema = "PMM")
public class TblStateCharge implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_STATE_CHARGE")
    private BigDecimal idStateCharge;
    @Size(max = 20)
    @Column(name = "LOAD_TABLE")
    private String loadTable;
    @Column(name = "STATE_CHARGE")
    private Object stateCharge;
    @Column(name = "STATE_SEND")
    private Object stateSend;
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
    @Size(max = 400)
    @Column(name = "ERROR_DES")
    private String errorDes;
    @Column(name = "LOAD_DATE")
    @Temporal(TemporalType.DATE)
    private Date loadDate;
    @Column(name = "INIT_LOAD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date initLoad;
    @Column(name = "END_LOAD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endLoad;
}
