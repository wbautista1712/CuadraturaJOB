/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cuadratura.app.mysql.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "tbl_pmm_wms", schema = "cuadratura")

public class TblPmmWms implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tbl_pmm_wms")
    private Integer idTblPmmWms;
    @Basic(optional = false)
    @Column(name = "mat_prd_lvl_child")
    private int matPrdLvlChild;
    @Basic(optional = false)
    @Column(name = "trans_lote")
    private String transLote;
    @Column(name = "pmm_disponible")
    private Integer pmmDisponible;
    @Column(name = "pmm_en_puerta")
    private Integer pmmEnPuerta;
    @Column(name = "pmm_perdido_no_disponible")
    private Integer pmmPerdidoNoDisponible;
    @Column(name = "pmm_acondiciona_cuarentena")
    private Integer pmmAcondicionaCuarentena;
    @Column(name = "pmm_canje_mercaderia")
    private Integer pmmCanjeMercaderia;
    @Column(name = "pmm_mermas")
    private Integer pmmMermas;
    @Column(name = "pmm_bolsa_discrepancia")
    private Integer pmmBolsaDiscrepancia;
    @Column(name = "pmm_economato_disponible")
    private Integer pmmEconomatoDisponible;
    @Column(name = "pmm_economato_bloqueado")
    private Integer pmmEconomatoBloqueado;
    @Column(name = "pmm_bolsa_discrepancia_econo")
    private Integer pmmBolsaDiscrepanciaEcono;
    @Column(name = "wms_disponible")
    private Integer wmsDisponible;
    @Column(name = "wms_pu")
    private Integer wmsPu;
    @Column(name = "wms_pa_pd")
    private Integer wmsPaPd;
    @Column(name = "wms_ac_qc")
    private Integer wmsAcQc;
    @Column(name = "wms_cj")
    private Integer wmsCj;
    @Column(name = "wms_bj")
    private Integer wmsBj;
    @Column(name = "wms_ec")
    private Integer wmsEc;
    @Column(name = "wms_eb")
    private Integer wmsEb;
    @Column(name = "comentario")
    private String comentario;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    
    @Column(name = "idUsuario")
    private Integer idUsuario;
    
    @Column(name = "idCruce_pmm_wms")
    private Integer idCrucepmmwms;

 
}
