package com.cuadratura.app.oracle.entity.pk;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
@Embeddable
public class FapprdloteePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "PRD_LVL_CHILD")
    private BigInteger prdLvlChild;
    @Basic(optional = false)
    @Column(name = "PRD_NLOTE")
    private String prdNlote;

  
}
