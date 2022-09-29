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
public class InvbaleePK implements Serializable {
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

   
}
