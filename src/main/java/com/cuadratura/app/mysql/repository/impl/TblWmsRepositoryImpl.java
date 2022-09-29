package com.cuadratura.app.mysql.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cuadratura.app.mysql.entity.TblWms;
import com.cuadratura.app.mysql.repository.TblWmsRepositoryCustom;
import com.cuadratura.app.oracle.dto.WmsCinsDto;

@Repository
public class TblWmsRepositoryImpl implements TblWmsRepositoryCustom {

	private static final Logger LOGGER = LogManager.getLogger(TblPmmRepositoryImpl.class);

	@Autowired
	@Qualifier("jdbctemplateTwo")
	private JdbcTemplate jdbcTemplate;

	@Override
	public void saveTblWms(WmsCinsDto obj, int idCargaWMS) throws SQLException {
		// TODO Auto-generated method stub

		// El Prepared Statement para los insert

		String sql = "INSERT INTO cuadratura.tbl_wms "
				+ "(nro_carga, create_date, facility_code, company_code, item_alternate, item_part_a, item_part_b, "
				+ "item_part_c, item_part_d, item_part_e, item_part_f, hierarchy1_code, hierarchy2_code, hierarchy3_code, "
				+ "hierarchy4_code, hierarchy5_code, batch_nbr, pre_pack_code, tbl_wmscol, pre_pack_ratio, pre_pack_units,  "
				+ "oblpn_total, active_total, active_allocated, active_allocated_lockcode, active_available, active_lockcode,  "
				+ "iblpn_total, iblpn_allocated, iblpn_allocated_lockcode, iblpn_available, iblpn_notverified, iblpn_lockcode,  "
				+ "iblpn_lost, total_allocated, total_available, total_inventory, four_wall_inventory, open_order_qty, lock_code_1,  "
				+ "lock_code_qty_1, lock_code_2, lock_code_qty_2, lock_code_3, lock_code_qty_3, lock_code_4, lock_code_qty_4, lock_code_5, "
				+ "lock_code_qty_5, lock_code_6, lock_code_qty_6, lock_code_7, lock_code_qty_7, lock_code_8, lock_code_qty_8, lock_code_9,  "
				+ "lock_code_qty_9, lock_code_10, lock_code_qty_10, download_date1, error_code, observacion_error, flg_tipo, idCarga_WMS) "
				+ "VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
				+ " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
				+ " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,  ?, ?, ?,?)";

		int insertCount = jdbcTemplate.update(sql,

				obj.getNroCarga(), obj.getCreateDate(), obj.getFacilityCode(), obj.getCompanyCode(),
				obj.getItemAlternate(), obj.getItemPartA(),

				obj.getItemPartB(), obj.getItemPartC(), obj.getItemPartD(), obj.getItemPartE(), obj.getItemPartF(),
				obj.getHierarchy1Code(),

				obj.getHierarchy2Code(), obj.getHierarchy3Code(), obj.getHierarchy4Code(), obj.getHierarchy5Code(),
				obj.getBatchNbr(),

				obj.getPrePackCode(), obj.getTblWmscol(), obj.getPrePackRatio(), obj.getPrePackUnits(),
				obj.getOblpnTotal(), obj.getActiveTotal(),

				obj.getActiveAllocated(), obj.getActiveAllocatedLockcode(), obj.getActiveAvailable(),
				obj.getActiveLockcode(), obj.getIblpnTotal(),

				obj.getIblpnAllocated(), obj.getIblpnAllocatedLockcode(), obj.getIblpnAvailable(),
				obj.getIblpnNotverified(), obj.getIblpnLockcode(),

				obj.getIblpnLost(), obj.getTotalAllocated(), obj.getTotalAvailable(), obj.getTotalInventory(),
				obj.getFourWallInventory(), obj.getOpenOrderQty(),

				obj.getLockCode1(), obj.getLockCodeQty1(), obj.getLockCode2(), obj.getLockCodeQty2(),
				obj.getLockCode3(), obj.getLockCodeQty3(), obj.getLockCode4(),

				obj.getLockCodeQty4(), obj.getLockCode5(), obj.getLockCodeQty5(), obj.getLockCode6(),
				obj.getLockCodeQty6(), obj.getLockCode7(), obj.getLockCodeQty7(),

				obj.getLockCode8(), obj.getLockCodeQty8(), obj.getLockCode9(), obj.getLockCodeQty9(),
				obj.getLockCode10(), obj.getLockCodeQty10(),

				obj.getDownloadDate1(),

				obj.getErrorCode(), obj.getObservacionError(),

				obj.getFlgTipo(),

				idCargaWMS);
		LOGGER.info("> insercion correcta " + insertCount);

	}
	
	@Override
	public void uploadTblWms(TblWms tblWms) throws SQLException {
		String sql = "INSERT INTO cuadratura.tbl_wms "
				+ "( create_date,  idCarga_WMS )"
			
				+ "VALUES( ?, ?) ";

		int insertCount = jdbcTemplate.update(sql,

				tblWms.getCreateDate(), tblWms.getIdCargaWMS());
		LOGGER.info("> insercion correcta " + insertCount);
	}

	@Override
	public void saveTblWmsBatch(List<WmsCinsDto> listaTblPmmForm, int numeroLotes, int idCargaWMS) throws SQLException {
		// TODO Auto-generated method stub
		DataSource ds = jdbcTemplate.getDataSource();
		Connection connection = ds.getConnection();
		PreparedStatement statement = null;
		final int batchSize = listaTblPmmForm.size();
		int count = 0;// contador de lotes
		int batch = numeroLotes;// numero de lotes
		if (connection != null) {
			try {
				connection.setAutoCommit(false);
				// El Prepared Statement para los insert

				String sql = "INSERT INTO cuadratura.tbl_wms "
						+ "(nro_carga, create_date, facility_code, company_code, item_alternate, item_part_a, item_part_b, "
						+ "item_part_c, item_part_d, item_part_e, item_part_f, hierarchy1_code, hierarchy2_code, hierarchy3_code, "
						+ "hierarchy4_code, hierarchy5_code, batch_nbr, pre_pack_code, tbl_wmscol, pre_pack_ratio, pre_pack_units,  "
						+ "oblpn_total, active_total, active_allocated, active_allocated_lockcode, active_available, active_lockcode,  "
						+ "iblpn_total, iblpn_allocated, iblpn_allocated_lockcode, iblpn_available, iblpn_notverified, iblpn_lockcode,  "
						+ "iblpn_lost, total_allocated, total_available, total_inventory, four_wall_inventory, open_order_qty, lock_code_1,  "
						+ "lock_code_qty_1, lock_code_2, lock_code_qty_2, lock_code_3, lock_code_qty_3, lock_code_4, lock_code_qty_4, lock_code_5, "
						+ "lock_code_qty_5, lock_code_6, lock_code_qty_6, lock_code_7, lock_code_qty_7, lock_code_8, lock_code_qty_8, lock_code_9,  "
						+ "lock_code_qty_9, lock_code_10, lock_code_qty_10, download_date1, error_code, observacion_error, flg_tipo, idCarga_WMS) "
						+ "VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
						+ " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
						+ " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,  ?, ?, ?,?)";

				statement = connection.prepareStatement(sql);

				// Se añaden los datos al batch
				for (WmsCinsDto obj : listaTblPmmForm) {

					// nro_carga, create_date, facility_code, company_code, item_alternate,
					// item_part_a,
					statement.setInt(1, obj.getNroCarga().intValue());
					statement.setString(2, obj.getCreateDate());
					statement.setString(3, obj.getFacilityCode());
					statement.setString(4, obj.getCompanyCode());
					statement.setString(5, obj.getItemAlternate());
					statement.setString(6, obj.getItemPartA());

					// item_part_b, item_part_c, item_part_d, item_part_e, item_part_f,
					// hierarchy1_code,
					statement.setString(7, obj.getItemPartB());
					statement.setString(8, obj.getItemPartC());
					statement.setString(9, obj.getItemPartD());
					statement.setString(10, obj.getItemPartE());
					statement.setString(11, obj.getItemPartF());
					statement.setString(12, obj.getHierarchy1Code());

					// hierarchy2_code, hierarchy3_code, hierarchy4_code, hierarchy5_code,
					// batch_nbr,
					statement.setString(13, obj.getHierarchy2Code());
					statement.setString(14, obj.getHierarchy3Code());
					statement.setString(15, obj.getHierarchy4Code());
					statement.setString(16, obj.getHierarchy5Code());
					statement.setString(17, obj.getBatchNbr());

					// pre_pack_code, tbl_wmscol, pre_pack_ratio, pre_pack_units, oblpn_total,
					// active_total,
					statement.setString(18, obj.getPrePackCode());
					statement.setString(19, obj.getTblWmscol());
					statement.setInt(20, obj.getPrePackRatio());
					statement.setInt(21, obj.getPrePackUnits());
					statement.setInt(22, obj.getOblpnTotal());
					statement.setInt(23, obj.getActiveTotal());

					// active_allocated, active_allocated_lockcode, active_available,
					// active_lockcode, iblpn_total,
					statement.setInt(24, obj.getActiveAllocated());
					statement.setInt(25, obj.getActiveAllocatedLockcode());
					statement.setInt(26, obj.getActiveAvailable());
					statement.setInt(27, obj.getActiveLockcode());
					statement.setInt(28, obj.getIblpnTotal());

					// iblpn_allocated, iblpn_allocated_lockcode, iblpn_available,
					// iblpn_notverified, iblpn_lockcode,
					statement.setInt(29, obj.getIblpnAllocated());
					statement.setInt(30, obj.getIblpnAllocatedLockcode());
					statement.setInt(31, obj.getIblpnAvailable());
					statement.setInt(32, obj.getIblpnNotverified());
					statement.setInt(33, obj.getIblpnLockcode());

					// iblpn_lost, total_allocated, total_available, total_inventory,
					// four_wall_inventory, open_order_qty,
					statement.setInt(34, obj.getIblpnLost());
					statement.setInt(35, obj.getTotalAllocated());
					statement.setInt(36, obj.getTotalAvailable());
					statement.setInt(37, obj.getTotalInventory());
					statement.setInt(38, obj.getFourWallInventory());
					statement.setInt(39, obj.getOpenOrderQty());

					// lock_code_1, lock_code_qty_1, lock_code_2, lock_code_qty_2, lock_code_3,
					// lock_code_qty_3, lock_code_4,
					statement.setString(40, obj.getLockCode1());
					statement.setInt(41, obj.getLockCodeQty1());
					statement.setString(42, obj.getLockCode2());
					statement.setInt(43, obj.getLockCodeQty2());
					statement.setString(44, obj.getLockCode3());
					statement.setInt(45, obj.getLockCodeQty3());
					statement.setString(46, obj.getLockCode4());

					// lock_code_qty_4, lock_code_5, lock_code_qty_5, lock_code_6, lock_code_qty_6,
					// lock_code_7, lock_code_qty_7,
					statement.setInt(47, obj.getLockCodeQty4());
					statement.setString(48, obj.getLockCode5());
					statement.setInt(49, obj.getLockCodeQty5());
					statement.setString(50, obj.getLockCode6());
					statement.setInt(51, obj.getLockCodeQty6());
					statement.setString(52, obj.getLockCode7());
					statement.setInt(53, obj.getLockCodeQty7());

					// lock_code_8, lock_code_qty_8, lock_code_9, lock_code_qty_9, lock_code_10,
					// lock_code_qty_10, download_date1,
					statement.setString(54, obj.getLockCode8());
					statement.setInt(55, obj.getLockCodeQty8());
					statement.setString(56, obj.getLockCode9());
					statement.setInt(57, obj.getLockCodeQty9());
					statement.setString(58, obj.getLockCode10());
					statement.setInt(59, obj.getLockCodeQty10());

					if (obj.getDownloadDate1() != null) {
						Date downloadDate1 = new java.sql.Date(obj.getDownloadDate1().getTime());
						statement.setDate(60, (java.sql.Date) downloadDate1);
					} else {
						statement.setDate(60, null);
					}

					/*
					 * error_code, observacion_error, flg_tipo, idCarga_WMS)
					 * 
					 */
					statement.setInt(61, obj.getErrorCode());
					statement.setString(62, obj.getObservacionError());

					if (obj.getFlgTipo() != null) {
						statement.setInt(63, obj.getFlgTipo().intValue());
					} else {
						statement.setInt(63, 0);
					}

					statement.setInt(64, idCargaWMS);// reecupera id
					LOGGER.info("> wwwwwwwwwwwwwwwwwwwww");
					LOGGER.info("> Registro ( %s | %s ) agregado al lote #%s\n", obj.getActiveAllocated(),
							obj.getActiveTotal(), batch);
					statement.addBatch();
					LOGGER.info("> ppppppppppppppppp");
					// Se van diviendo los lotes segun un limite establecido
					if (++count % batchSize == 0) {
						// se ejecuta lote #N
						statement.executeBatch();
						LOGGER.info("> Ejecutando lote #%s\n", batch);
						batch++;
					}
					LOGGER.info("> kkkkkkkkkkkkkkkkkkkkk");
				}

				// Se ejecuta el lote restante
				if (listaTblPmmForm.size() % batchSize != 0) {
					LOGGER.info("> Ejecutando lote #%s\n", batch);
					statement.executeBatch();
				}
				LOGGER.info("> aaaaaaaaaaaaaaaaaaaaaaaaa");
				// confirma transacción
				connection.commit();
				LOGGER.info("> TOTAL: [ %s ] foto registrados\n", listaTblPmmForm.size());
				LOGGER.info("> Programa terminado");
			} catch (SQLException ex) {// si se produce algun error
				LOGGER.error(ex.getMessage());
				try {
					LOGGER.error("> Transacción abortada");
					LOGGER.error("> Valores restaurados");
					LOGGER.error("> Programa terminado");
					connection.rollback();
				} catch (SQLException ex1) {
					LOGGER.error(ex1.getMessage());
				}
			} finally {
				if (statement != null) {
					statement.close();
				}
			}
		}
	}

}
