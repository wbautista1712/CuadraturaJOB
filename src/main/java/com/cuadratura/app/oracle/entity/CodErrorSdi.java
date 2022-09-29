package com.cuadratura.app.oracle.entity;


import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Table(name = "COD_ERROR_SDI", schema = "CUADRATURAWYP")
public class CodErrorSdi implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_COD_ERROR_SDI")
    private BigDecimal idCodErrorSdi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SESSION_NUMBER")
    private BigInteger sessionNumber;
    @Column(name = "TECH_KEY")
    private BigInteger techKey;
    @Size(max = 6)
    @Column(name = "TYPE_TRANSACTION")
    private String typeTransaction;
    @Column(name = "REJ_CODE")
    private BigInteger rejCode;
    @Size(max = 160)
    @Column(name = "REJ_DESC")
    private String rejDesc;

    
}
