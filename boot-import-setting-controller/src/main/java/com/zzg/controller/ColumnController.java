package com.zzg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zzg.service.ColumnService;

@Controller
@RequestMapping("/api/column")
public class ColumnController {
	@Autowired
	private ColumnService service;

}
