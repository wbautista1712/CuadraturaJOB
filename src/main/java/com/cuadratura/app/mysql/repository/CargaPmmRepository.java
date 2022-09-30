package com.cuadratura.app.mysql.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cuadratura.app.mysql.entity.CargaPmm;

@Repository
public interface CargaPmmRepository extends CrudRepository<CargaPmm, Integer>, CargaPmmRepositoryCustom {
	
}
