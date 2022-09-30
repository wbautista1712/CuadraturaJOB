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
@Table(name = "carga_wms", schema = "cuadratura")

public class CargaWms implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCarga_WMS")
    private Integer idCargaWMS;
    @Basic(optional = false)
    @Column(name = "fechaCarga")
    @Temporal(TemporalType.DATE)
    private Date fechaCarga;
    @Basic(optional = false)
    @Column(name = "horaCarga")
    private String horaCarga;
    @Basic(optional = false)
    @Column(name = "num_registros")
    private int numRegistros;
    @Basic(optional = false)
    @Column(name = "usuario_carga")
    private String usuarioCarga;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    
    @Column(name = "org_name_short")
    private String orgNameShort;
    
    @Column(name = "id_m_TipoImportacion")
    private Integer idmTipoImportacion;
    
    @Column(name = "id_m_estadoCuadratura")
    private Integer idmestadoCuadratura;
    /*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCargaWMS")
    private Collection<TblPmmWms> tblPmmWmsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCargaWMS")
    private Collection<TblWms> tblWmsCollection;
*/
    @Column(name = "nombreArchivo")
    private String nombreArchivo;
    
}
