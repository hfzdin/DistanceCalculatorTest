package com.example.distanceCalculator;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class DistanceCalculatorJsonController {
	

	@PostMapping(
			  value = "/json", consumes = "application/json", produces = "application/json")
			public Calculator createPerson(@RequestBody Calculator calc) {
		
		
		calc.setFirstUnit(calc.getFirstUnit().toLowerCase());
		calc.setSecondUnit(calc.getSecondUnit().toLowerCase());
		calc.setAnswerUnit(calc.getAnswerUnit().toLowerCase());
		
				
		try {
			if (!(calc.getFirstVal() ==0) && (calc.getFirstUnit().equals("y") || calc.getFirstUnit().equals("m"))
					&& !(calc.getSecondVal()==0) && (calc.getSecondUnit().equals("y") || calc.getSecondUnit().equals("m"))
					&& (!calc.getAnswerUnit().equals("y") ||!calc.getAnswerUnit().equals("m") )) {

				if(calc.getAnswerUnit().equals("y"))
				{
					if(calc.getFirstUnit().equals("y")) {
						calc.setFirstVal(calc.getFirstVal() * 0.9144);
					}

					if(calc.getSecondUnit().equals("y")) {
						calc.setSecondVal(calc.getSecondVal()* 0.9144);
					}
					
					calc.setAnswer((calc.getFirstVal()  + calc.getSecondVal())/0.9144);

				return calc;
				
				}

				else if(calc.getAnswerUnit().toLowerCase().equals("m"))
				{
					if(calc.getFirstUnit().equals("y")) {
						calc.setFirstVal(calc.getFirstVal() * 0.9144);
					}

					if(calc.getSecondUnit().equals("y")) {
						calc.setSecondVal(calc.getSecondVal()* 0.9144);
					}

					calc.setAnswer(calc.getFirstVal()  + calc.getSecondVal());
					
					return calc;

				}
				
			}
			
		} catch (Exception ex) {

		}
		return calc;
		
	}
}
