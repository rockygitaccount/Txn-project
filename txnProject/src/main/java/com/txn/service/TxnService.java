package com.txn.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.txn.dto.TxnDto;
import com.txn.entity.Txn;

public interface TxnService {

	ResponseEntity<List<Txn>> getAllTxns(double initialRange, double finalRange);

	ResponseEntity<List<Txn>> sortTxns();

	ResponseEntity<TxnDto> addTxn(Txn txn);

}
