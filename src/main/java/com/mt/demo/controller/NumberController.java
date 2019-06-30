package com.mt.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mt.demo.service.NumberService;

@RestController
@RequestMapping("/number")
public class NumberController {
	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private NumberService numberService;

	@GetMapping(path = "/square/{number}")
	public String getSquare(@PathVariable Long number) {
		log.info("call numberService to square {}", number);
		return String.format("{\"square\": %s}", numberService.square(number));
	}

}
