package com.lawencon.penjualantiket.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.lawencon.penjualantiket.model.Tiket;
import com.lawencon.penjualantiket.model.TransactionDetail;
import com.lawencon.penjualantiket.service.TransactionService;

@RestController
@RequestMapping("/tiket")
public class TransactionController extends BaseController<Tiket[]> {

	@Autowired
	protected TransactionService t_service;

	@PostMapping("/checkinJpa")
	public ResponseEntity<?> insertJpa(@RequestParam("pocer") String pocer, @RequestBody String content,
			@RequestHeader("Authorization") String user) {
		List<TransactionDetail> listTransaction = new ArrayList<>();
		try {
			String[] auth = authUser(user).split(":");
			List<Tiket> listTiket = Arrays.asList(readValue(content, Tiket[].class));
			listTransaction = t_service.insertTiketJpa(pocer,auth[0],auth[1],listTiket);
			return new ResponseEntity<>(listTransaction, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(listTransaction, HttpStatus.BAD_REQUEST);
		}

	}
	
	@PostMapping("/checkinHiber")
	public ResponseEntity<?> insertHiber(@RequestParam("pocer") String pocer, @RequestBody String content,
			@RequestHeader("Authorization") String user) {
		List<TransactionDetail> listTransaction = new ArrayList<>();
		try {
			String[] auth = authUser(user).split(":");
			List<Tiket> listTiket = Arrays.asList(readValue(content, Tiket[].class));
			listTransaction = t_service.insertTiketHiber(pocer,auth[0],auth[1],listTiket);
			return new ResponseEntity<>(listTransaction, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(listTransaction, HttpStatus.BAD_REQUEST);
		}

	}

}
