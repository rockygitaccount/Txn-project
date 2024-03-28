package com.txn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.txn.dto.TxnDto;
import com.txn.entity.Txn;
import com.txn.mapper.TxnMapper;
import com.txn.service.TxnService;

@RestController
@RequestMapping("/txn")
public class TxnController {

	@Autowired
	TxnMapper txnMapper;
	@Autowired
	private TxnService txnService;

	@PostMapping("/add")
	public ResponseEntity<TxnDto> addTxn(@RequestBody TxnDto txnDto) {
		return txnService.addTxn(txnMapper.dtoToTxn(txnDto));
	}

	@GetMapping("/amount/{initialRange}/{finalRange}")
	public ResponseEntity<List<Txn>> getTxnsByAmountRange(@PathVariable double initialRange,
			@PathVariable double finalRange) {

		return txnService.getAllTxns(initialRange, finalRange);
	}

	@GetMapping("/sort/amount")
	public ResponseEntity<List<Txn>> sortTxnsByAmount() {
		return txnService.sortTxns();

	}
}
