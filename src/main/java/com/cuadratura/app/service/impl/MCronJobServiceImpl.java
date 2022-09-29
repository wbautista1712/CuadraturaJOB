package com.cuadratura.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuadratura.app.mysql.entity.MCronJob;
import com.cuadratura.app.mysql.repository.MCronJobRepository;
import com.cuadratura.app.service.MCronJobService;

@Service
public class MCronJobServiceImpl implements MCronJobService{

	@Autowired
	private MCronJobRepository mCronJobRepository;
	
	@Override
	public MCronJob getCronJob() {
		return mCronJobRepository.getCronJob();
	}

}
