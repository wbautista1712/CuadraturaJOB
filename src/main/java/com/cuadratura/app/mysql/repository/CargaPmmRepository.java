package com.cuadratura.app.mysql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cuadratura.app.mysql.entity.CargaPmm;
import com.cuadratura.app.oracle.dto.FotoPmmDto;

@Repository
public interface CargaPmmRepository extends CrudRepository<CargaPmm, Integer>, CargaPmmRepositoryCustom {
	
}
