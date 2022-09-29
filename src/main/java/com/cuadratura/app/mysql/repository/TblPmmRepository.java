package com.cuadratura.app.mysql.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cuadratura.app.mysql.entity.TblPmm;

@Repository
public interface TblPmmRepository extends CrudRepository<TblPmm, Integer>, TblPmmRepositoryCustom {

}
