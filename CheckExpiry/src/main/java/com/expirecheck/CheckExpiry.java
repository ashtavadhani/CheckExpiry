package com.expirecheck;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@SpringBootApplication
public class CheckExpiry {

	 @RequestMapping(value = {"/calculateExpiry"},method = RequestMethod.POST)
	   @ResponseBody
	   Date checkExpiry(@RequestParam("currentDate") Date expiryDate) throws ParseException {//@RequestParam("currentDate") Date expiryDate ) {
		
		SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
		/*
		 * String exDate = myFormat.format(expiryDate); String[] exDate1 =
		 * exDate.split("/"); System.out.println("Date is" +exDate1[0]);
		 * System.out.println("month is" + exDate1[1]); System.out.println("Year is" +
		 * exDate1[2]);
		 * 
		 * System.out.println(myFormat.format(expiryDate));
		 * System.out.println(myFormat.format(System.currentTimeMillis()));
		 */


		
		String exDate = myFormat.format(expiryDate);
		String endDate = myFormat.format(System.currentTimeMillis());
		System.out.println("exDate" +exDate);

	       Date date1 = myFormat.parse(endDate);
	       Date date2 = myFormat.parse(exDate);
System.out.println("date1" +date1);
	        long getDiff = date2.getTime() - date1.getTime();
	        float daysBetween = (getDiff / (1000*60*60*24));
	        System.out.println("getDiff" +daysBetween);
		/*
		 * int date2 = Integer.parseInt(myFormat.format(System.currentTimeMillis()));
		 * int date1 = Integer.parseInt(myFormat.format(expiryDate));
		 * System.out.println("date2" +date2); System.out.println("date1" +date1);
		 * 
		 * int date3 =date1- date2; System.out.println("Date3" +date3);
		 */
		// date-expiryDate;
		
		 return expiryDate;
	   }

	 public static void main(String[] args) {
	      SpringApplication.run(CheckExpiry.class, args);
	   }
	
}
