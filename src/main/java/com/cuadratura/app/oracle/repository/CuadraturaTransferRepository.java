package com.cuadratura.app.oracle.repository;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cuadratura.app.oracle.entity.CuadraturaTransfer;


@Repository
public interface CuadraturaTransferRepository extends CrudRepository<CuadraturaTransfer, BigDecimal>, CuadraturaTransferRepositoryCustom{	


}
