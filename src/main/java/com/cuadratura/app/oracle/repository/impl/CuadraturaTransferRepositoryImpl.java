package com.cuadratura.app.oracle.repository.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.cuadratura.app.oracle.entity.CuadraturaTransfer;
import com.cuadratura.app.oracle.repository.CuadraturaTransferRepository;
import com.cuadratura.app.oracle.repository.CuadraturaTransferRepositoryCustom;

@Repository
@Transactional
public class CuadraturaTransferRepositoryImpl implements CuadraturaTransferRepositoryCustom {
	private static final Logger LOGGER = LogManager.getLogger(CuadraturaTransferRepository.class);

	@Autowired
	@Qualifier("jdbctemplateOne")
	private JdbcTemplate jdbcTemplate;

	public Long getSequence() {
		Long seq;
		String sql = "SELECT integracion.wms_seq_fapinvtrhee.NEXTVAL FROM DUAL";
		seq = jdbcTemplate.queryForObject(sql, new Object[] {}, Long.class);
		LOGGER.info("seq " + seq);
		return seq;
	}

	public void saveCuadraturaTransfer(CuadraturaTransfer cuadraturaTransfer) throws SQLException {
		LOGGER.info("getIdCuadraturaTransfer " + cuadraturaTransfer.getIdCuadraturaTransfer());
		LOGGER.info("getTransSession " + cuadraturaTransfer.getTransSession());
		LOGGER.info("getTransUser " + cuadraturaTransfer.getTransUser());

		String INSERT_QUERY = " insert into CUADRATURAWYP.CUADRATURA_TRANSFER " + "    ( "
				+ "      id_cuadratura_transfer        , " + "      trans_session               , "
				+ "     trans_user                 , " + "    trans_batch_date             , "
				+ "     trans_source                , " + "     trans_audited                , "
				+ "     trans_sequence             , " + "    trans_trn_code            , "
				+ "    trans_type_code             , " + "    trans_date                 , "
				+ "    inv_mrpt_code               , " + "     inv_drpt_code               , "
				+ "    trans_curr_code              , " + "     trans_org_lvl_number        , "
				+ "     trans_prd_lvl_number        , " + "      proc_source                   , "
				+ "     trans_qty                  , " + "    inner_pack_id             , "
				+ "     trans_inners                 , " + "    trans_lote                  , "
				+ "     trans_vcto_lote             "
				+ "       ) values ( CUADRATURAWYP.CUADRATURA_TRANSFER_seq.nextval,? ,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ) ";

		LOGGER.info(" saveCuadraturaTransfer fin getTransSession " + cuadraturaTransfer.getTransSession());
		LOGGER.info(" saveCuadraturaTransfer fin getTransUser " + cuadraturaTransfer.getTransUser());
		LOGGER.info(" saveCuadraturaTransfer fin getTransBatchDate " + cuadraturaTransfer.getTransBatchDate());
		LOGGER.info(" saveCuadraturaTransfer fin getTransSource " + cuadraturaTransfer.getTransSource());
		LOGGER.info(" saveCuadraturaTransfer fin getTransAudited " + cuadraturaTransfer.getTransAudited());
		LOGGER.info(" saveCuadraturaTransfer fin getTransSequence " + cuadraturaTransfer.getTransSequence());
		LOGGER.info(" saveCuadraturaTransfer fin getTransTrnCode " + cuadraturaTransfer.getTransTrnCode());
		LOGGER.info(" saveCuadraturaTransfer fin getTransTypeCode " + cuadraturaTransfer.getTransTypeCode());
		LOGGER.info(" saveCuadraturaTransfer fin getTransDate " + cuadraturaTransfer.getTransDate());
		LOGGER.info(" saveCuadraturaTransfer fin getInvMrptCode " + cuadraturaTransfer.getInvMrptCode());
		LOGGER.info(" saveCuadraturaTransfer fin getInvDrptCode " + cuadraturaTransfer.getInvDrptCode());
		LOGGER.info(" saveCuadraturaTransfer fin getTransCurrCode " + cuadraturaTransfer.getTransCurrCode());
		LOGGER.info(" saveCuadraturaTransfer fin getTransOrgLvlNumber " + cuadraturaTransfer.getTransOrgLvlNumber());
		LOGGER.info(" saveCuadraturaTransfer fin getTransPrdLvlNumber " + cuadraturaTransfer.getTransPrdLvlNumber());
		LOGGER.info(" saveCuadraturaTransfer fin getProcSource " + cuadraturaTransfer.getProcSource());
		LOGGER.info(" saveCuadraturaTransfer fin getTransQty " + cuadraturaTransfer.getTransQty());
		LOGGER.info(" saveCuadraturaTransfer fin getInnerPackId " + cuadraturaTransfer.getInnerPackId());
		LOGGER.info(" saveCuadraturaTransfer fin getTransInners " + cuadraturaTransfer.getTransInners());
		LOGGER.info(" saveCuadraturaTransfer fin getTransLote " + cuadraturaTransfer.getTransLote());

		LOGGER.info(" saveCuadraturaTransfer fin getTransVctoLote " + cuadraturaTransfer.getTransVctoLote());

		LOGGER.info(" saveCuadraturaTransfer fin INSERT_QUERY " + INSERT_QUERY);

		/*jdbcTemplate.update(INSERT_QUERY, cuadraturaTransfer.getTransSession(), cuadraturaTransfer.getTransUser(),
				cuadraturaTransfer.getTransBatchDate(), cuadraturaTransfer.getTransSource(),
				cuadraturaTransfer.getTransAudited(), cuadraturaTransfer.getTransSequence(),
				cuadraturaTransfer.getTransTrnCode(), cuadraturaTransfer.getTransTypeCode(),
				cuadraturaTransfer.getTransDate(), cuadraturaTransfer.getInvMrptCode(),
				cuadraturaTransfer.getInvDrptCode(), cuadraturaTransfer.getTransCurrCode(),
				cuadraturaTransfer.getTransOrgLvlNumber(), cuadraturaTransfer.getTransPrdLvlNumber(),
				cuadraturaTransfer.getProcSource(), cuadraturaTransfer.getTransQty(),
				cuadraturaTransfer.getInnerPackId(), cuadraturaTransfer.getTransInners(),
				cuadraturaTransfer.getTransLote(), cuadraturaTransfer.getTransVctoLote());
		*/
/*
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);

				ps.setInt(1, cuadraturaTransfer.getTransSession().intValue());
				ps.setString(2, cuadraturaTransfer.getTransUser());
				
				java.util.Date utilDate = cuadraturaTransfer.getTransBatchDate();
				java.sql.Date sqlDateTransBatchDate = new java.sql.Date(utilDate.getTime());
				    
				ps.setDate(3, sqlDateTransBatchDate);
				ps.setString(4, cuadraturaTransfer.getTransSource());
				ps.setString(5, cuadraturaTransfer.getTransAudited());
				ps.setInt(6, cuadraturaTransfer.getTransSequence().intValue());
				ps.setString(7, cuadraturaTransfer.getTransTrnCode());
				ps.setString(8, cuadraturaTransfer.getTransTypeCode());
				
				java.util.Date utilDateCuadraturaTransfer = cuadraturaTransfer.getTransDate();
				java.sql.Date sqlDateCuadraturaTransfer = new java.sql.Date(utilDateCuadraturaTransfer.getTime());
				ps.setDate(9, sqlDateCuadraturaTransfer);
				ps.setString(10, cuadraturaTransfer.getInvMrptCode());
				ps.setString(11, cuadraturaTransfer.getInvDrptCode());
				ps.setString(12, cuadraturaTransfer.getTransCurrCode());
				ps.setInt(13, cuadraturaTransfer.getTransOrgLvlNumber().intValue());
				ps.setString(14, cuadraturaTransfer.getTransPrdLvlNumber());
				ps.setString(15, cuadraturaTransfer.getProcSource());
				ps.setInt(16, cuadraturaTransfer.getTransQty().intValue());
				ps.setInt(17, cuadraturaTransfer.getInnerPackId().intValue());
				ps.setInt(18, cuadraturaTransfer.getTransInners().intValue());
				ps.setString(19, cuadraturaTransfer.getTransLote());
				
				java.util.Date utilDateTransVctoLote =  cuadraturaTransfer.getTransVctoLote();
				java.sql.Date sqlDateTransVctoLote = new java.sql.Date(utilDateTransVctoLote.getTime());
				ps.setDate(20,sqlDateTransVctoLote);

				return ps;
			}
		});
*/
		
		   
		DataSource ds = jdbcTemplate.getDataSource();
		Connection conn = null;
		CallableStatement ps = null;
        try{ 
        	LOGGER.info("-- 1cd enviarCierreCancelacionFormatoFinacieroAlCliente " );
        	conn = ds.getConnection();
        	ps = conn.prepareCall("{call cuadraturawyp.pkg_cuadratura.insert_cuadratura_transfer(? ,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
         
             
             ps.setInt(1, cuadraturaTransfer.getTransSession().intValue());
				ps.setString(2, cuadraturaTransfer.getTransUser());
				
				java.util.Date utilDate = cuadraturaTransfer.getTransBatchDate();
				java.sql.Date sqlDateTransBatchDate = new java.sql.Date(utilDate.getTime());
				    
				ps.setDate(3, sqlDateTransBatchDate);
				ps.setString(4, cuadraturaTransfer.getTransSource());
				ps.setString(5, cuadraturaTransfer.getTransAudited());
				ps.setInt(6, cuadraturaTransfer.getTransSequence().intValue());
				ps.setString(7, cuadraturaTransfer.getTransTrnCode());
				ps.setString(8, cuadraturaTransfer.getTransTypeCode());
				
				java.util.Date utilDateCuadraturaTransfer = cuadraturaTransfer.getTransDate();
				java.sql.Date sqlDateCuadraturaTransfer = new java.sql.Date(utilDateCuadraturaTransfer.getTime());
				ps.setDate(9, sqlDateCuadraturaTransfer);
				ps.setString(10, cuadraturaTransfer.getInvMrptCode());
				ps.setString(11, cuadraturaTransfer.getInvDrptCode());
				ps.setString(12, cuadraturaTransfer.getTransCurrCode());
				ps.setInt(13, cuadraturaTransfer.getTransOrgLvlNumber().intValue());
				ps.setString(14, cuadraturaTransfer.getTransPrdLvlNumber());
				ps.setString(15, cuadraturaTransfer.getProcSource());
				ps.setInt(16, cuadraturaTransfer.getTransQty().intValue());
				ps.setInt(17, cuadraturaTransfer.getInnerPackId().intValue());
				ps.setInt(18, cuadraturaTransfer.getTransInners().intValue());
				ps.setString(19, cuadraturaTransfer.getTransLote());
				
				java.util.Date utilDateTransVctoLote =  cuadraturaTransfer.getTransVctoLote();
				java.sql.Date sqlDateTransVctoLote = new java.sql.Date(utilDateTransVctoLote.getTime());
				ps.setDate(20,sqlDateTransVctoLote);
             
				ps.execute();
            
         }catch(Exception ex){
        	 LOGGER.error("Error en saveCuadraturaTransfer=",ex);
               
         }finally {        
        	 if (ps != null) {
        		 ps.close();
 			}
 			if (conn != null) {
 				conn.close();
 			}
         }
        LOGGER.info("-- 0cd saveCuadraturaTransfer - res :  " );

		
		
	}

	public void spCuadraturaTransfer(int idSesion) throws SQLException {
		LOGGER.info("idSesion " + idSesion);

		DataSource ds = jdbcTemplate.getDataSource();
		Connection conn = null;
		CallableStatement csmt = null;

		try {
			conn = ds.getConnection();
			csmt = conn.prepareCall("{call cuadraturawyp.pkg_cuadratura.pr_cuadratura_transfer(?)}");

			csmt.setInt(1, idSesion);

			csmt.execute();

		} catch (Exception ex) {
			LOGGER.error("Error en spCuadraturaTransfer()", ex);
		} finally {
			if (csmt != null) {
				csmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

	}
}
