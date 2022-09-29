package com.cuadratura.app.mysql.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cuadratura.app.mysql.entity.MCronJob;

@Repository
public interface MCronJobRepository extends CrudRepository<MCronJob, Integer>{
	@Query(value = "SELECT idm_cron_job, segundo, minuto, hora, diaMes, mes, diaSemana, estado"
			+ "FROM cuadratura.m_cron_job j where estado=1;", nativeQuery = true)
	MCronJob getCronJob();
}
