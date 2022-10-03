package com.cuadratura.app;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cuadratura.app.mysql.entity.CargaPmm;
import com.cuadratura.app.mysql.entity.CargaWms;
import com.cuadratura.app.mysql.entity.MCronJob;
import com.cuadratura.app.oracle.dto.TblHstFtFapinvbaleeDto;
import com.cuadratura.app.oracle.dto.TblStateChargeDto;
import com.cuadratura.app.oracle.dto.WmsCinsCDDto;
import com.cuadratura.app.oracle.dto.WmsCinsDto;
import com.cuadratura.app.service.CargaPmmService;
import com.cuadratura.app.service.CargaWmsService;
import com.cuadratura.app.service.MCronJobService;
import com.cuadratura.app.service.TblHstFtFapinvbaleeService;
import com.cuadratura.app.service.TblPmmService;
import com.cuadratura.app.service.TblStateChargeService;
import com.cuadratura.app.service.TblWmsService;
import com.cuadratura.app.service.WmsCinsService;
import com.cuadratura.app.util.Constantes;

/**
 * Created by wilber bautista on 02/08/2022.
 */
@Component
public class ScheduledTasks {

	private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	// Agregado por wilber

	//produccion
	//private static final String cronExpressionWms = "0 30 0,3,6,9,12,18 ? * * ";
	//private static final String cronExpressionPmm = "0 40 0,3,6,9,12,18 ? * * ";
	
	//local
	private static final String cronExpressionWms = "0 30 11 ? * 0 ";
	private static final String cronExpressionPmm = "0 13 17 ? * 0 ";


	private static final String TIME_ZONE = "America/Lima";


	@Autowired
	private TblPmmService tblPmmService;

	@Autowired
	private CargaPmmService cargaPmmService;

	@Autowired
	private WmsCinsService wmsCinsService;

	@Autowired
	private TblWmsService tblWmsService;

	@Autowired
	private CargaWmsService cargaWmsService;

	@Autowired
	private MCronJobService mCronJobService;
	
	@Autowired
	private TblStateChargeService tblStateChargeService;
	
	@Autowired
	private TblHstFtFapinvbaleeService  tblHstFtFapinvbaleeService;

	//@Bean
	public String getCronValue() {
		String job = "";

		MCronJob mCronJob = mCronJobService.getCronJob();

		job = mCronJob.getSegundo() + " " + mCronJob.getMinuto() + " " + mCronJob.getHora() + " " + mCronJob.getDiaMes()
				+ " " + mCronJob.getMes() + " " + mCronJob.getDiaSemana();
		logger.info("Cron Expression:: "+job);

		return job;
	}

	/*
	@Scheduled(cron = cronExpressionPmm, zone = TIME_ZONE)
	public void scheduleTaskWithFixedRate() throws SQLException {
		logger.info("Fixed Rate Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));

		List<FapinvbaleeDto> lista = fapinvbaleeService.getLoteFotoPmm();
		logger.info(".:::oracle  tamaño lote :::. " + lista.size());

		for (int i = 0; i < lista.size(); i++) {
			logger.info(".::: obj.getLoteFotoPmm() :::. " + lista.size());
			logger.info(".::: insert idCD:::. " + lista.get(i).getIdCD());
			List<Fapinvbalee> listaTblPmmForm = this.fapinvbaleeService.findAllPMMFapinvbalee(lista.get(i).getIdCD());
		
			logger.info(".::: oracle tamaño de importacion :::. " + listaTblPmmForm.size());
			CargaPmm cargaPmm = new CargaPmm();

			cargaPmm.setFechaFoto(new Date());
			cargaPmm.setHoraFoto(dateTimeFormatter.format(LocalDateTime.now()));
			cargaPmm.setNumRegistros(listaTblPmmForm.size());
			cargaPmm.setUsuarioCarga(Constantes.USUARIO_CARGA_AUTOMATICO);

			cargaPmm.setEstado(true);
			cargaPmm.setIdmTipoImportacion(Constantes.TIPO_IMPORTACION);
			cargaPmm.setIdmestadoCuadratura(Constantes.ESTADO_CUADRATURA);
			cargaPmm.setOrgLvlChild(lista.get(i).getIdCD()); 
			Integer id = this.cargaPmmService.saveCargaPmm(cargaPmm).intValue();
			this.tblPmmService.saveTblPmm(listaTblPmmForm,  id);
		}
	}
	*/
	
	@Scheduled(cron = cronExpressionPmm, zone = TIME_ZONE)
	public void scheduleTaskWithFixedRate() throws SQLException {
		logger.info("Fixed Rate Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
		
		List<TblStateChargeDto> lista =tblStateChargeService.getFindAllTblStateCharge();

	//	List<FapinvbaleeDto> lista = fapinvbaleeService.getLoteFotoPmm();
		logger.info(".:::oracle  tamaño lote :::. " + lista.size());

		for (int i = 0; i < lista.size(); i++) {
			logger.info(".::: obj.getLoteFotoPmm() :::. " + lista.size());
			logger.info(".::: insert getOrgLvlChild:::. " + lista.get(i).getOrgLvlChild());
			logger.info(".::: insert getIdStateCharge:::. " + lista.get(i).getIdStateCharge());
			
			List<TblHstFtFapinvbaleeDto> listaTblPmmForm = this.tblHstFtFapinvbaleeService.listTblHstFtFapinvbalee(lista.get(i).getIdStateCharge().intValue());
		
			logger.info(".::: oracle tamaño de importacion :::. " + listaTblPmmForm.size());
			CargaPmm cargaPmm = new CargaPmm();

			cargaPmm.setFechaFoto(new Date());
			cargaPmm.setHoraFoto(dateTimeFormatter.format(LocalDateTime.now()));
			cargaPmm.setNumRegistros(listaTblPmmForm.size());
			cargaPmm.setUsuarioCarga(Constantes.USUARIO_CARGA_AUTOMATICO);

			cargaPmm.setEstado(true);
			cargaPmm.setIdmTipoImportacion(Constantes.TIPO_IMPORTACION);
			cargaPmm.setIdmestadoCuadratura(Constantes.ESTADO_CUADRATURA);
			cargaPmm.setOrgLvlChild(lista.get(i).getOrgLvlChild().intValue()); 
			Integer id = this.cargaPmmService.saveCargaPmm(cargaPmm).intValue();
			this.tblPmmService.saveTblPmmJob(listaTblPmmForm,  id);
			logger.info(".::: fin proceso id_estado actualiza :::. ");
			this.tblStateChargeService.updateTblStateCharge(lista.get(i).getIdStateCharge().intValue());
		}
	}

	
	@Scheduled(cron = cronExpressionWms, zone = TIME_ZONE) 
	public void scheduleTaskWithCronExpression() throws Exception {

		logger.info("Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
		
		String codigosEstado = tblWmsService.nroCargaTblWmsByFoto();
		
		logger.info("Cron Task :: codigosEstado Time - {}", codigosEstado);
		//List<WmsCinsCDDto> listaCDxFH = wmsCinsService.getCDXFechaHoraFotoWms();
		List<WmsCinsCDDto> listaCDxFH = wmsCinsService.getCDXNroCargaFotoWms(codigosEstado);
		logger.info(".:::oracle  tamaño lote listaCDxFH :::. " + listaCDxFH.size());

		for (int i = 0; i < listaCDxFH.size(); i++) 
		{
			logger.info(".::: obj.getLoteFotoPmm() :::. " + listaCDxFH.size());

			logger.info(".::: insert idCD:::. " + listaCDxFH.get(i).getIdCD());

			logger.info(".:::oracle  listaFH.get(j).getNroCarga() :::. " + listaCDxFH.get(i).getNroCarga());
		//	List<WmsCinsDto> listaTblWmsForm = this.wmsCinsService.findAllWMSWmsCins(listaCDxFH.get(i).getFechaHora());
			List<WmsCinsDto> listaTblWmsForm = this.wmsCinsService.findAllxNroCargaWMSWmsCins(listaCDxFH.get(i).getNroCarga());
			// TblPmm tblPmm = null;
			logger.info(".::: oracle tamaño WMS de importacion :::. " + listaTblWmsForm.size());

			// codigo de carga carga_pmm

			CargaWms cargaWms = new CargaWms();
			cargaWms.setFechaCarga(new Date());
			cargaWms.setHoraCarga(dateTimeFormatter.format(LocalDateTime.now()));
			cargaWms.setEstado(true);
			cargaWms.setNumRegistros(listaTblWmsForm.size());
			cargaWms.setIdmTipoImportacion(Constantes.TIPO_IMPORTACION);
			cargaWms.setIdmestadoCuadratura(Constantes.ESTADO_CUADRATURA);
			cargaWms.setUsuarioCarga(Constantes.USUARIO_CARGA_AUTOMATICO);
			cargaWms.setOrgNameShort(listaCDxFH.get(i).getIdCD()); // traer toda la datos de los CDS
		//	cargaWms.setNroCarga(listaCDxFH.get(i).getNroCarga());
			Integer id = this.cargaWmsService.saveCargaWms(cargaWms).intValue();
			logger.info("id ==> " + id);
			this.tblWmsService.saveTblWms(listaTblWmsForm,  id);
			logger.info("i ==> " + i);
		}

	}

}