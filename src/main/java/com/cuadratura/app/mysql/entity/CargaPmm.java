/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cuadratura.app.mysql.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

/**
 *
 * @author ARANGO
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@Data
@ToString
@RequiredArgsConstructor
@Table(name = "carga_pmm", schema = "cuadratura")

public class CargaPmm implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCarga_PMM")
    private Integer idCargaPMM;
    @Basic(optional = false)
    @Column(name = "fechaFoto")
    @Temporal(TemporalType.DATE)
    private Date fechaFoto;
    @Basic(optional = false)
    @Column(name = "horaFoto")
    private String horaFoto;
    @Basic(optional = false)
    @Column(name = "numRegistros")
    private int numRegistros;
    @Basic(optional = false)
    @Column(name = "usuarioCarga")
    private String usuarioCarga;
    @Column(name = "nombreArchivo")
    private String nombreArchivo;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    
    @Column(name = "id_m_TipoImportacion")    
    private Integer idmTipoImportacion;
    
    @Column(name = "id_m_estadoCuadratura")   
    private Integer idmestadoCuadratura;
    
    @Column(name = "org_lvl_child")   
    private Integer orgLvlChild;
    
    /*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCargaPMM")
    private Collection<TblPmm> tblPmmCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCargaPMM")
    private Collection<TblPmmWms> tblPmmWmsCollection;
    */

    
}
