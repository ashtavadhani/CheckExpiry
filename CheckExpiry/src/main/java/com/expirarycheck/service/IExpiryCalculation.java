package com.expirarycheck.service;

import java.text.ParseException;
import java.util.Date;

import org.springframework.http.ResponseEntity;

import com.expirarycheck.entity.ProductExpiry;

public interface IExpiryCalculation {

	public ResponseEntity<ProductExpiry> findExpiry(Date expiryDate) throws ParseException;
}
