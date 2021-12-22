package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.ExcelService;

@Controller
public class ExcelController {
	
	@Autowired
	ExcelService data;

	@RequestMapping("/excel")
	public void api() {
		
		System.out.println(data.ExcelSelect());
	}
}
