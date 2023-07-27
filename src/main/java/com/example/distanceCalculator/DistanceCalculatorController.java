package com.example.distanceCalculator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DistanceCalculatorController {

	 @GetMapping("/")
	    public String showHomePage() {
	        return "Please insert according to url /calculate/{value1}/{unit1}/{value2}/{unit2}/{unit3} or send JSON to /calculate/json/";
	    }

	 @GetMapping("/calculate/{value1}/{unit1}/{value2}/{unit2}/{unit3}")
	public ResponseEntity calculateValue(
			@PathVariable double value1,
			@PathVariable String unit1,
			@PathVariable double value2,
			@PathVariable String unit2,
			@PathVariable String unit3) {

		double answer=0;
		

		Calculator calc=new Calculator();
		
		calc.setFirstVal(value1);
		calc.setFirstUnit(unit1);
		calc.setSecondVal(value2);
		calc.setSecondUnit(unit2);
		calc.setAnswerUnit(unit3);

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

					return new ResponseEntity<>("The answer is " + calc.getAnswer() + " yards.", HttpStatus.OK);
				
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
					
					return new ResponseEntity<>("The answer is " + calc.getAnswer() + " meters.", HttpStatus.OK);

				}
				
				else {

					return new ResponseEntity<>("Please insert according to url /calculate/1st Value in integer/Unit for value 1 either 'y' for yard or 'm' for meter/2nd Value in integer/Unit for 2nd value either 'y' for yard or 'm' for meter/Unit for answer 'y' for yard or 'm' for meter", HttpStatus.BAD_REQUEST);
				}


			}
			
		} catch (Exception ex) {

			return new ResponseEntity<>("Please insert according to url /calculate/1st Value in integer/Unit for value 1 either 'y' for yard or 'm' for meter/2nd Value in integer/Unit for 2nd value either 'y' for yard or 'm' for meter/Unit for answer 'y' for yard or 'm' for meter", HttpStatus.BAD_REQUEST);
			
		}
		
		return new ResponseEntity<>("Please insert according to url /calculate/1st Value in integer/Unit for value 1 either 'y' for yard or 'm' for meter/2nd Value in integer/Unit for 2nd value either 'y' for yard or 'm' for meter/Unit for answer 'y' for yard or 'm' for meter", HttpStatus.BAD_REQUEST);
		
	}

}
