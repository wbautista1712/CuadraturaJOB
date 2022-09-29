package com.cuadratura.app.oracle.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cuadratura.app.oracle.entity.pk.FapprdloteePK;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Arango
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@Data
@ToString
@RequiredArgsConstructor
@Table(name = "FAPPRDLOTEE", schema = "PMM")
public class Fapprdlotee implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FapprdloteePK fapprdloteePK;
    @Column(name = "LOT_FECHA_VCTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lotFechaVcto;

    
    
}
