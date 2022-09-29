package com.cuadratura.app.oracle.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cuadratura.app.oracle.entity.Fapprdlotee;
import com.cuadratura.app.oracle.entity.pk.FapprdloteePK;

@Repository
public interface FapprdloteeRepository extends CrudRepository<Fapprdlotee, FapprdloteePK>, FapprdloteeRepositoryCustom {

}
