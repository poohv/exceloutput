package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.ExcelapiService;


@Service
public class ExcelService implements ExcelapiService {
	
	@Autowired
	ExcelapiService data;

	@Override
	public String ExcelSelect() {
		return data.ExcelSelect();
	}

}
