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
	        return "Please insert according to url /calculate/{value1}/{unit1}/{value2}/{unit2}/{unit3}";
	    }

	 @GetMapping("/calculate/{value1}/{unit1}/{value2}/{unit2}/{unit3}")
	public ResponseEntity calculateValue(
			@PathVariable double value1,
			@PathVariable String unit1,
			@PathVariable double value2,
			@PathVariable String unit2,
			@PathVariable String unit3) {

		double answer=0;


		try {
			if (!(value1==0) && !unit1.equals("") && !(value2==0) && !unit2.equals("") && !unit3.equals("") ) {

				if(unit3.toLowerCase().equals("y"))
				{
					if(unit1.toLowerCase().equals("y")) {
						value1=value1 * 0.9144;
					}

					if(unit2.toLowerCase().equals("y")) {
						value2=value2 * 0.9144;
					}

					answer=(value1+value2)/0.9144;

					return new ResponseEntity<>("The answer is " + answer + " yards.", HttpStatus.OK);

				}

				else if(unit3.toLowerCase().equals("m"))
				{
					if(unit1.toLowerCase().equals("y")) {
						value1=value1 * 0.9144;
					}

					if(unit2.toLowerCase().equals("y")) {
						value2=value2 * 0.9144;
					}

					answer=value1+value2;

					return new ResponseEntity<>("The answer is " + answer + " meters.", HttpStatus.OK);
				}

				else {

					return new ResponseEntity<>("Please insert according to url /calculate/1st Value in integer/Unit for value 1 either 'y' for yard or 'm' for meter/2nd Value in integer/Unit for 2nd value either 'y' for yard or 'm' for meter/Unit for answer 'y' for yard or 'm' for meter", HttpStatus.BAD_REQUEST);
				}


			} else {

				return new ResponseEntity<>("Please insert according to url /calculate/1st Value in integer/Unit for value 1 either 'y' for yard or 'm' for meter/2nd Value in integer/Unit for 2nd value either 'y' for yard or 'm' for meter/Unit for answer 'y' for yard or 'm' for meter", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception ex) {
			System.out.print(ex);
			return new ResponseEntity<>("Please insert according to url /calculate/1st Value in integer/Unit for value 1 either 'y' for yard or 'm' for meter/2nd Value in integer/Unit for 2nd value either 'y' for yard or 'm' for meter/Unit for answer 'y' for yard or 'm' for meter",HttpStatus.BAD_REQUEST);
		}

	}

}
