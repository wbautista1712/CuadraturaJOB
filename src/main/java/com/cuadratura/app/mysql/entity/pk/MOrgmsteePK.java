package com.cuadratura.app.mysql.entity.pk;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author ARANGO
 */
@Embeddable
public class MOrgmsteePK implements Serializable {

	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "org_lvl_child")
	private int orgLvlChild;
	@Basic(optional = false)
	@Column(name = "org_name_short")
	private String orgNameShort;
}
