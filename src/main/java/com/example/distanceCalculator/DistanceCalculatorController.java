package com.example.distanceCalculator;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import javax.script.ScriptException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DistanceCalculatorController {

	 @GetMapping("/")
	    public String showHomePage() {
	        return "Please insert according to url /calculate/{value1}/{unit1}/{value2}/{unit2}/{unit3}";
	    }
	
	@RequestMapping("/calculate/{value1}/{unit1}/{value2}/{unit2}/{unit3}")
	public ResponseEntity calculateValue(
			@PathVariable int value1, 
			@PathVariable String unit1,
			@PathVariable int value2, 
			@PathVariable String unit2,
			@PathVariable String unit3) {
		
	
		return new ResponseEntity<>("Please insert according to url /calculate/{value1}/{unit1}/{value2}/{unit2}/{unit3}",HttpStatus.BAD_REQUEST);
	}
	
	
}
