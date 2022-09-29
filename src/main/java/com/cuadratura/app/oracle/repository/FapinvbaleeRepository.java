package com.cuadratura.app.oracle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cuadratura.app.oracle.entity.Fapinvbalee;
import com.cuadratura.app.oracle.entity.pk.FapinvbaleePK;

@Repository
public interface FapinvbaleeRepository extends CrudRepository<Fapinvbalee, FapinvbaleePK> , FapinvbaleeRepositoryCustom{

	@Query(value = "SELECT "
			+ "ORG_LVL_CHILD,PRD_LVL_CHILD,INV_TYPE_CODE,TRANS_LOTE,ON_HAND_QTY,ON_HAND_RETL,ON_HAND_COST,PO_ORD_QTY,PO_ORD_RETL,PO_ORD_COST, "
			+ "PO_INTRN_QTY,PO_INTRN_RETL,PO_INTRN_COST,TO_ORD_QTY,TO_ORD_RETL,TO_ORD_COST,TO_INTRN_QTY,TO_INTRN_RETL,TO_INTRN_COST,FIRST_PIS_DATE,LAST_PIS_DATE, "
			+ "LTD_QTY,LTD_RETL,LTD_COST,LAST_CHG_DATE,ON_HAND_WEIGHT,WEIGHT_UOM,PO_ORD_WEIGHT,PO_INTRN_WEIGHT,TO_ORD_WEIGHT,TO_INTRN_WEIGHT,LTD_WEIGHT,PRD_SLL_UOM, "
			+ "CURR_CODE,ON_HAND_EACHES,FIRST_SHIPPED_DATE,FIRST_SALES_DATE,ON_HAND_COST_HM,ON_HAND_RETL_HM,TO_INTRN_COST_HM,TO_INTRN_RETL_HM,TRANS_VCTO_LOTE "
			+ "FROM PMM.FAPINVBALEE  WHERE ORG_LVL_CHILD = :idCD ", nativeQuery = true)
	List<Fapinvbalee> findAllPMMFapinvbalee(Integer idCD);
	
}
