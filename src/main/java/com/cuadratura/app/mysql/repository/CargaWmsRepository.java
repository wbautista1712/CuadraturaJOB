package com.cuadratura.app.mysql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cuadratura.app.mysql.entity.CargaWms;
import com.cuadratura.app.oracle.dto.FotoWmsDto;

@Repository
public interface CargaWmsRepository extends CrudRepository<CargaWms, Integer>, CargaWmsRepositoryCustom {
			
	@Query(value = "SELECT DISTINCT WMS.org_name_short FROM cuadratura.cruce_pmm_wms C "
			+ "                INNER JOIN cuadratura.carga_wms WMS on C.idCarga_WMS=WMS.idCarga_WMS "
			+ "                WHERE C.idCruce_pmm_wms=:idCrucePmmWms", nativeQuery = true)
	String getCDCrucePmmWms( int  idCrucePmmWms);
	

}
