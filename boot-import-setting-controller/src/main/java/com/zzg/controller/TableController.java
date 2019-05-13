package com.zzg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zzg.service.TableService;

@Controller
@RequestMapping("/api/table")
public class TableController {
	@Autowired
	private TableService service;

}
