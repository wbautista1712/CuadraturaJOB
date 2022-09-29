package com.cuadratura.app.mysql.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cuadratura.app.mysql.entity.CrucePmmWms;

@Repository
public interface CrucePmmWmsRepository  extends CrudRepository<CrucePmmWms, Integer>, CrucePmmWmsRepositoryCustom{

}
