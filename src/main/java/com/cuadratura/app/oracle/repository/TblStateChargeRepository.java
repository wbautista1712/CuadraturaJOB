package com.cuadratura.app.oracle.repository;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cuadratura.app.oracle.entity.TblStateCharge;

@Repository
public interface TblStateChargeRepository extends CrudRepository<TblStateCharge, BigDecimal>, TblStateChargeRepositoryCustom {

}
