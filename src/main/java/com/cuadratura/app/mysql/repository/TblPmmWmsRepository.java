package com.cuadratura.app.mysql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cuadratura.app.mysql.entity.TblPmmWms;
import com.cuadratura.app.oracle.dto.ConsolidadoPmmWmsDto;

@Repository
public interface TblPmmWmsRepository extends CrudRepository<TblPmmWms, Integer> , TblPmmWmsRepositoryCustom{
	
	@Query(value = "	SELECT  		"+
			"	T_WMS.idCarga_WMS,		"+
			"	T_PMM.idCarga_PMM,		"+
			"	date_format(DATE(NOW()), '%d/%m/%Y') AS FECHA,		"+
			"	TIME(NOW()) AS HORA,		"+
			"	T_WMS.CENTRO, T_WMS.COD_MATERIAL,T_WMS.MATERIAL, T_WMS.LOTE, 		"+
			"	T_WMS.DISPONIBLE_ASIGNADO_RESERVADO_WMS, T_WMS.PU, T_WMS.PA, T_WMS.AC, T_WMS.QC, T_WMS.CJ, T_WMS.BJ, T_WMS.EC, T_WMS.EB,		"+
			"	T_PMM.DISPONIBLE_ASIGNADO_RESERVADO_PMM, T_PMM.EN_PUERTA_NO_DISPONIBLE, T_PMM.PERDIDO_NO_DISPONIBLE, T_PMM.ACONDICIONAMIENTO_EN_CUARENTENA, 		"+
			"	T_PMM.CANJE_MERCADERIA, T_PMM.MERMAS, T_PMM.BOLSA_DISCREPANCIA,     	"+
			"	T_PMM.ECONOMATO_DISPONIBLE, T_PMM.ECONOMATO_BLOQUEADO, T_PMM.BOLA_DISCREPANCIA_ECONOMATO,		"+
			"	(T_PMM.DISPONIBLE_ASIGNADO_RESERVADO_PMM - T_WMS.DISPONIBLE_ASIGNADO_RESERVADO_WMS) AS DISPONIBLE_ASIGNADO_RESERVADO,		"+
			"	(T_PMM.EN_PUERTA_NO_DISPONIBLE - T_WMS.PU) as EN_PUERTA_NO_DISPONIBLE_PU,		"+
			"	(T_PMM.PERDIDO_NO_DISPONIBLE - T_WMS.PA) as PERDIDO_NO_DISPONIBLE_PA,		"+
			"	(T_PMM.ACONDICIONAMIENTO_EN_CUARENTENA - T_WMS.AC) as ACONDICIONAMIENTO_EN_CUARENTENA_AC,		"+
			"	(T_PMM.CANJE_MERCADERIA - T_WMS.QC) as CANJE_MERCADERIA_QC,		"+
			"	(T_PMM.MERMAS - T_WMS.CJ) as MERMAS_CJ,		"+
			"	(T_PMM.BOLSA_DISCREPANCIA - T_WMS.BJ) as BOLSA_DISCREPANCIA_BJ,		"+
			"	(T_PMM.ECONOMATO_DISPONIBLE - T_WMS.EC) as ECONOMATO_DISPONIBLE_EC		"+
			"	FROM		"+
			"	(		"+
			"		SELECT C.idCarga_PMM, ORG_NAME_SHORT AS CENTRO, cuadratura.PRD_LVL_CHILD as COD_MATERIAL, P.prd_name_full AS MATERIAL, cuadratura.trans_lote AS LOTE,	"+
			"		CASE WHEN cuadratura.INV_TYPE_CODE IN ('01','02','03') THEN SUM(IFNULL(ON_HAND_QTY,0)) END AS DISPONIBLE_ASIGNADO_RESERVADO_PMM,	"+
			"		CASE WHEN cuadratura.INV_TYPE_CODE IN ('04') THEN SUM(IFNULL(PMM.ON_HAND_QTY,0)) END AS EN_PUERTA_NO_DISPONIBLE, 	"+
			"		CASE WHEN cuadratura.INV_TYPE_CODE IN ('05') THEN SUM(IFNULL(PMM.ON_HAND_QTY,0)) END AS PERDIDO_NO_DISPONIBLE, 	"+
			"		CASE WHEN cuadratura.INV_TYPE_CODE IN ('06') THEN SUM(IFNULL(PMM.ON_HAND_QTY,0)) END AS ACONDICIONAMIENTO_EN_CUARENTENA, 	"+
			"		CASE WHEN cuadratura.INV_TYPE_CODE IN ('07') THEN SUM(IFNULL(PMM.ON_HAND_QTY,0)) END AS CANJE_MERCADERIA, 	"+
			"		CASE WHEN cuadratura.INV_TYPE_CODE IN ('08') THEN SUM(IFNULL(PMM.ON_HAND_QTY,0)) END AS MERMAS,	"+
			"		CASE WHEN cuadratura.INV_TYPE_CODE IN ('09') THEN SUM(IFNULL(PMM.ON_HAND_QTY,0)) END AS BOLSA_DISCREPANCIA,     	"+
			"		CASE WHEN cuadratura.INV_TYPE_CODE IN ('12') THEN SUM(IFNULL(PMM.ON_HAND_QTY,0)) END AS ECONOMATO_DISPONIBLE,	"+
			"		CASE WHEN cuadratura.INV_TYPE_CODE IN ('13') THEN SUM(IFNULL(PMM.ON_HAND_QTY,0)) END AS ECONOMATO_BLOQUEADO,	"+
			"		CASE WHEN cuadratura.INV_TYPE_CODE IN ('14') THEN SUM(IFNULL(PMM.ON_HAND_QTY,0)) END AS BOLA_DISCREPANCIA_ECONOMATO	"+
			"		FROM cuadratura.tbl_pmm PMM 	"+
			"		INNER JOIN cuadratura.m_orgmstee CD ON cuadratura.org_lvl_child=CD.org_lvl_child	"+
			"		INNER JOIN cuadratura.m_prdmstee P ON cuadratura.prd_lvl_child=P.prd_lvl_child	"+
			"		INNER JOIN cuadratura.carga_pmm C ON cuadratura.idCarga_PMM=C.idCarga_PMM	"+
			"		WHERE C.idCarga_PMM=:idCargaPmm AND CD.org_name_short=:idCD	"+
			"		GROUP BY C.idCarga_PMM, CD.ORG_NAME_SHORT, cuadratura.PRD_LVL_CHILD, P.prd_name_full, cuadratura.trans_lote, cuadratura.INV_TYPE_CODE	"+
			"	)T_PMM  INNER  join 		"+
			"	(		"+
			"		SELECT C.idCarga_WMS, WMS.FACILITY_CODE AS CENTRO, P.prd_lvl_child as COD_MATERIAL, P.prd_name_full AS MATERIAL, WMS.BATCH_NBR AS LOTE, 	"+
			"		SUM(IFNULL(WMS.oblpn_total, 0) + IFNULL(WMS.total_allocated, 0) + IFNULL(WMS.total_available, 0)) AS DISPONIBLE_ASIGNADO_RESERVADO_WMS,	"+
			"	    SUM(CASE WHEN WMS.lock_code_5='PU' THEN IFNULL(WMS.lock_code_qty_5,0) ELSE 0 END) AS PU,		"+
			"	    SUM(CASE WHEN WMS.lock_code_4='PA' THEN IFNULL(WMS.lock_code_qty_4,0) ELSE 0 END) AS PA,		"+
			"	    SUM(CASE WHEN WMS.lock_code_1='AC' THEN IFNULL(WMS.lock_code_qty_1,0) ELSE 0 END) AS AC,		"+
			"	    SUM(CASE WHEN WMS.lock_code_6='QC' THEN IFNULL(WMS.lock_code_qty_6,0) ELSE 0 END) AS QC,		"+
			"	    SUM(CASE WHEN WMS.lock_code_3='CJ' THEN IFNULL(WMS.lock_code_qty_3,0) ELSE 0 END) AS CJ,		"+
			"	    SUM(CASE WHEN WMS.lock_code_2='BJ' THEN IFNULL(WMS.lock_code_qty_2,0) ELSE 0 END) AS BJ,		"+
			"	    SUM(CASE WHEN WMS.lock_code_7='EC' THEN IFNULL(WMS.lock_code_qty_7,0) ELSE 0 END) AS EC,		"+
			"	    SUM(CASE WHEN WMS.lock_code_8='EB' THEN IFNULL(WMS.lock_code_qty_8,0) ELSE 0 END) AS EB		"+
			"		FROM cuadratura.carga_wms C	"+
			"		INNER JOIN cuadratura.tbl_wms WMS ON C.idCarga_WMS=WMS.idCarga_WMS	"+
			"		INNER JOIN cuadratura.m_prdmstee P ON WMS.item_alternate=P.prd_lvl_number	"+
			"		WHERE C.idCarga_WMS=:idCargaWms AND WMS.FACILITY_CODE=:idCD	"+
			"		GROUP BY C.idCarga_WMS, WMS.FACILITY_CODE, P.prd_lvl_child, P.prd_name_full, WMS.BATCH_NBR	"+
			"	)T_WMS ON T_PMM.CENTRO =T_WMS.CENTRO AND T_PMM.LOTE =T_WMS.LOTE AND T_PMM.COD_MATERIAL =T_WMS.COD_MATERIAL		"+
			"	ORDER  BY T_WMS.MATERIAL, T_WMS.LOTE	", nativeQuery = true)
	List<ConsolidadoPmmWmsDto> getAllConsolidadoPmmWms( Integer idCargaWms,	Integer idCargaPmm, String idCD);
	

}
