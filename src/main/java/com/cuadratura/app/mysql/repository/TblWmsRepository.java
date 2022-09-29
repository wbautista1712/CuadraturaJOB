package com.cuadratura.app.mysql.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cuadratura.app.mysql.entity.TblWms;
@Repository
public interface TblWmsRepository extends CrudRepository<TblWms, Integer>, TblWmsRepositoryCustom {

}
