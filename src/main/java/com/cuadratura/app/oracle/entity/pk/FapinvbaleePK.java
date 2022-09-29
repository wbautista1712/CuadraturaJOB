/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cuadratura.app.oracle.entity.pk;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author ARANGO
 */

@Getter
@Setter
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
@Embeddable
public class FapinvbaleePK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "ORG_LVL_CHILD")
    private long orgLvlChild;
	
    @Basic(optional = false)
    @Column(name = "PRD_LVL_CHILD")
    private long prdLvlChild;
    
    @Basic(optional = false)
    @Column(name = "INV_TYPE_CODE")
    private String invTypeCode;
    
    @Basic(optional = false)
    @Column(name = "TRANS_LOTE")
    private String transLote;

   
}
