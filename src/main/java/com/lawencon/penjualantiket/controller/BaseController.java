package com.lawencon.penjualantiket.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Base64;
import java.util.Map;

import org.springframework.asm.TypeReference;
/*
 * @author I KADEK ARYA YOGIMIYAANTARA
 * 
 */
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.penjualantiket.model.Tiket;
import com.lawencon.penjualantiket.service.HargaTiketService;
import com.lawencon.penjualantiket.service.TransactionService;
import com.lawencon.penjualantiket.service.TypeService;
import com.lawencon.penjualantiket.service.UserService;
import com.lawencon.penjualantiket.service.VoucherTiketService;

abstract class BaseController<T> {

	T model;
	
	String authUser(String user) throws Exception {
		byte[] decodedBytes = Base64.getDecoder().decode(user);
		String decodedString = new String(decodedBytes);
		return decodedString;
	}

	public T readValue(String jsonString, Class<T> classType)
			throws JsonMappingException, JsonMappingException, IOException {
		return new ObjectMapper().readValue(jsonString, classType);
	}
}
