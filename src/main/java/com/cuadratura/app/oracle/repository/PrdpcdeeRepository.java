package com.cuadratura.app.oracle.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cuadratura.app.oracle.entity.Prdpcdee;

@Repository
public interface PrdpcdeeRepository extends CrudRepository<Prdpcdee, Long>,  PrdpcdeeRepositoryCustom{

}
