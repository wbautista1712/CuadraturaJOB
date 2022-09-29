package com.cuadratura.app.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.cuadratura.app.oracle.entity.Fapprdlotee;
import com.cuadratura.app.oracle.entity.pk.FapprdloteePK;
import com.cuadratura.app.oracle.repository.FapprdloteeRepository;
import com.cuadratura.app.service.FapprdloteeService;

@Service
public class FapprdloteeServiceImpl extends GenericServiceImpl<Fapprdlotee, FapprdloteePK> implements FapprdloteeService{

	private static final Logger LOGGER = LogManager.getLogger(MTipoInventarioServiceImpl.class);

	@Autowired
	private FapprdloteeRepository fapprdloteeRepository;

	@Override
	public CrudRepository<Fapprdlotee, FapprdloteePK> getDao() {
		// TODO Auto-generated method stub
		LOGGER.info("fapprdloteeRepository");
		return fapprdloteeRepository;
	}

	@Override
	public String findFapprdlotee(Integer cd, String numeroLote)  throws Exception {
		// TODO Auto-generated method stub
		
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		//List<Fapprdlotee> listaClasificadores = new ArrayList<Fapprdlotee>();
		String lista = fapprdloteeRepository.findFapprdlotee(cd, numeroLote);
		LOGGER.info("get getLotFechaVcto " + lista);
		/*Fapprdlotee fotoWms;
		FapprdloteePK id;
		Date date  = null;
		for (Object[] filaObj : lista) {
			fotoWms = new Fapprdlotee();
			id=new FapprdloteePK();
		
			id.setPrdLvlChild(filaObj[0] == null ? BigInteger.ZERO :new BigInteger(filaObj[0].toString()) );
			id.setPrdNlote(filaObj[1] == null ? "" :  filaObj[1].toString());
			fotoWms.setFapprdloteePK(id);
			
			if (filaObj[2] != null) {
				 date = formatter.parse( filaObj[2].toString());
			}			
			fotoWms.setLotFechaVcto(date);
			listaClasificadores.add(fotoWms);
		}*/
		return lista;
	}

}
