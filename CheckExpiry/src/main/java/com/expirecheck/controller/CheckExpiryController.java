package com.expirecheck.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.expirarycheck.entity.ProductExpiry;
import com.expirarycheck.service.ExpiryCalculation;



@RestController
@SpringBootApplication(scanBasePackages={"com.expirarycheck"})

public class CheckExpiryController {

	@Autowired
	ExpiryCalculation ExpiryCalculation;
	 @RequestMapping(value = {"/calculateExpiry"},method = RequestMethod.POST)
	   @ResponseBody 
	   ResponseEntity<ProductExpiry> checkExpiry(@RequestParam("expiryDate") Date expiryDate) throws ParseException {
		 return ExpiryCalculation.findExpiry(expiryDate);
		
	   }
	 public static void main(String[] args) {
	      SpringApplication.run(CheckExpiryController.class, args);
	   }
	
	 @RequestMapping(value = {"/calculateExpiryWithoutExpDate1"},method = RequestMethod.POST)
	   @ResponseBody 
	   ResponseEntity<ProductExpiry> checkExpiryWithoutExpDate(@RequestParam("manufactureDate") Date manufDate,@RequestParam("expiresInDays") int expiresInDays) throws ParseException {
			ProductExpiry productExpiry = new ProductExpiry();
			SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
			Calendar c = Calendar.getInstance();
			c.setTime(manufDate); 
			c.add(Calendar.DATE, expiresInDays); 
			Date expiredDate = c.getTime();
			
			return ExpiryCalculation.findExpiry(expiredDate);
		//	System.out.println(output);
			
		/*
		 * String manufactureDate = myFormat.format(manufDate); String expriyDate =
		 * manufactureDate + expredDate; System.out.println("ExpriyDate" +expriyDate);
		 */
	 }
	 
}
