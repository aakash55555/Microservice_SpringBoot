package com.eden.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.annotations.ApiIgnore;

/**
 * The Class HomeController.
 */
@Controller
@ApiIgnore
public class HomeController {

	/**
	 * Home.
	 *
	 * @return the string
	 */
	@RequestMapping("/swagger")
	public String home() {
		return "redirect:/swagger-ui.html";
	}

}
