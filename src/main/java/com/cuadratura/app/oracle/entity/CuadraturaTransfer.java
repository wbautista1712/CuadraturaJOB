package com.cuadratura.app.oracle.entity;


import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
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
@Table(name = "CUADRATURA_TRANSFER", schema = "CUADRATURAWYP")
public class CuadraturaTransfer implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CUADRATURA_TRANSFER")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUADRATURA_TRANSFER_generator")
	@SequenceGenerator(sequenceName = "CUADRATURA_TRANSFER_seq", schema = "CUADRATURAWYP" , allocationSize = 1,  name = "CUADRATURA_TRANSFER_generator")
    private BigDecimal idCuadraturaTransfer;    
    
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANS_SESSION")
    private BigInteger transSession;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "TRANS_USER")
    private String transUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANS_BATCH_DATE")
    @Temporal(TemporalType.DATE)
    private Date transBatchDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "TRANS_SOURCE")
    private String transSource;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANS_AUDITED")
    private String transAudited;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANS_SEQUENCE")
    private BigInteger transSequence;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "TRANS_TRN_CODE")
    private String transTrnCode;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "TRANS_TYPE_CODE")
    private String transTypeCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANS_DATE")
    @Temporal(TemporalType.DATE)
    private Date transDate;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "INV_MRPT_CODE")
    private String invMrptCode;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "INV_DRPT_CODE")
    private String invDrptCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "TRANS_CURR_CODE")
    private String transCurrCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANS_ORG_LVL_NUMBER")
    private BigInteger transOrgLvlNumber;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "TRANS_PRD_LVL_NUMBER")
    private String transPrdLvlNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "PROC_SOURCE")
    private String procSource;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANS_QTY")
    private BigInteger transQty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INNER_PACK_ID")
    private BigInteger innerPackId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANS_INNERS")
    private BigInteger transInners;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TRANS_LOTE")
    private String transLote;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANS_VCTO_LOTE")
    @Temporal(TemporalType.DATE)
    private Date transVctoLote;
    
}
