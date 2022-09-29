/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cuadratura.app.mysql.entity;

import java.io.Serializable;
import java.math.BigInteger;
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
@Builder@Data
@ToString
@RequiredArgsConstructor
@Table(name = "tbl_wms", schema = "cuadratura")

public class TblWms implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTbl_WMS")
    private Integer idTblWMS;
    @Column(name = "nro_carga")
    private Integer nroCarga;
    @Column(name = "create_date")
    private String createDate;
    @Column(name = "facility_code")
    private String facilityCode;
    @Column(name = "company_code")
    private String companyCode;
    @Column(name = "item_alternate")
    private String itemAlternate;
    @Column(name = "item_part_a")
    private String itemPartA;
    @Column(name = "item_part_b")
    private String itemPartB;
    @Column(name = "item_part_c")
    private String itemPartC;
    @Column(name = "item_part_d")
    private String itemPartD;
    @Column(name = "item_part_e")
    private String itemPartE;
    @Column(name = "item_part_f")
    private String itemPartF;
    @Column(name = "hierarchy1_code")
    private String hierarchy1Code;
    @Column(name = "hierarchy2_code")
    private String hierarchy2Code;
    @Column(name = "hierarchy3_code")
    private String hierarchy3Code;
    @Column(name = "hierarchy4_code")
    private String hierarchy4Code;
    @Column(name = "hierarchy5_code")
    private String hierarchy5Code;
    @Column(name = "batch_nbr")
    private String batchNbr;
    @Column(name = "pre_pack_code")
    private String prePackCode;
    @Column(name = "pre_pack_ratio")
    private Integer prePackRatio;
    @Column(name = "pre_pack_units")
    private Integer prePackUnits;
    @Column(name = "oblpn_total")
    private Integer oblpnTotal;
    @Column(name = "active_total")
    private Integer activeTotal;
    @Column(name = "active_allocated")
    private Integer activeAllocated;
    @Column(name = "active_allocated_lockcode")
    private Integer activeAllocatedLockcode;
    @Column(name = "active_available")
    private Integer activeAvailable;
    @Column(name = "active_lockcode")
    private Integer activeLockcode;
    @Column(name = "iblpn_total")
    private Integer iblpnTotal;
    @Column(name = "iblpn_allocated")
    private Integer iblpnAllocated;
    @Column(name = "iblpn_allocated_lockcode")
    private Integer iblpnAllocatedLockcode;
    @Column(name = "iblpn_available")
    private Integer iblpnAvailable;
    @Column(name = "iblpn_notverified")
    private Integer iblpnNotverified;
    @Column(name = "iblpn_lockcode")
    private Integer iblpnLockcode;
    @Column(name = "iblpn_lost")
    private Integer iblpnLost;
    @Column(name = "total_allocated")
    private Integer totalAllocated;
    @Column(name = "total_available")
    private Integer totalAvailable;
    @Column(name = "total_inventory")
    private Integer totalInventory;
    @Column(name = "four_wall_inventory")
    private Integer fourWallInventory;
    @Column(name = "open_order_qty")
    private Integer openOrderQty;
    @Column(name = "lock_code_1")
    private String lockCode1;
    @Column(name = "lock_code_qty_1")
    private Integer lockCodeQty1;
    @Column(name = "lock_code_2")
    private String lockCode2;
    @Column(name = "lock_code_qty_2")
    private Integer lockCodeQty2;
    @Column(name = "lock_code_3")
    private String lockCode3;
    @Column(name = "lock_code_qty_3")
    private Integer lockCodeQty3;
    @Column(name = "lock_code_4")
    private String lockCode4;
    @Column(name = "lock_code_qty_4")
    private Integer lockCodeQty4;
    @Column(name = "lock_code_5")
    private String lockCode5;
    @Column(name = "lock_code_qty_5")
    private Integer lockCodeQty5;
    @Column(name = "lock_code_6")
    private String lockCode6;
    @Column(name = "lock_code_qty_6")
    private Integer lockCodeQty6;
    @Column(name = "lock_code_7")
    private String lockCode7;
    @Column(name = "lock_code_qty_7")
    private Integer lockCodeQty7;
    @Column(name = "lock_code_8")
    private String lockCode8;
    @Column(name = "lock_code_qty_8")
    private Integer lockCodeQty8;
    @Column(name = "lock_code_9")
    private String lockCode9;
    @Column(name = "lock_code_qty_9")
    private Integer lockCodeQty9;
    @Column(name = "lock_code_10")
    private String lockCode10;
    @Column(name = "lock_code_qty_10")
    private Integer lockCodeQty10;
    @Column(name = "download_date1")
    @Temporal(TemporalType.DATE)
    private Date downloadDate1;
    @Column(name = "error_code")
    private Integer errorCode;
    @Column(name = "observacion_error")
    private String observacionError;
    @Column(name = "flg_tipo")
    private Integer flgTipo;
    @Column(name = "idCarga_WMS")   
    private Integer idCargaWMS;

  
}
