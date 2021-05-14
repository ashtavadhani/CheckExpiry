package com.expirarycheck.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.expirarycheck.entity.ProductExpiry;

@Service
@Component
public class ExpiryCalculation implements IExpiryCalculation {

	public ResponseEntity<ProductExpiry> findExpiry(Date expiryDate) throws ParseException {
		ProductExpiry productExpiry = new ProductExpiry();
		SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");

		String exDate = myFormat.format(expiryDate);
		String currentDate = myFormat.format(System.currentTimeMillis());
		Date current = myFormat.parse(currentDate);
		Date date2 = myFormat.parse(exDate);

		long getDiff = date2.getTime() - current.getTime();
		float daysBetween = (getDiff / (1000 * 60 * 60 * 24));
		System.out.println("getDiff" + daysBetween);

		productExpiry.setProductName(" Test Product");
		if (daysBetween > 0)
			productExpiry.setExpired(false);
		else
			productExpiry.setExpired(true);

		if (!productExpiry.isExpired())
			productExpiry.setExpiretime(daysBetween);
		
		return new ResponseEntity<ProductExpiry>(productExpiry, HttpStatus.OK);
	}

}
