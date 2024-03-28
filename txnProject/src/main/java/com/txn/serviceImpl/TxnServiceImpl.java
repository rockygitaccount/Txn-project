package com.txn.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.txn.dto.TxnDto;
import com.txn.entity.Txn;
import com.txn.exception.InvalidTxnAmountException;
import com.txn.repository.TxnRepository;
import com.txn.service.TxnService;

@Service
public class TxnServiceImpl implements TxnService {

	@Autowired
	TxnRepository txnRepository;

	@Override
	public ResponseEntity<TxnDto> addTxn(Txn txn) {
		if (txn.getAmount() < 0) {
			throw new InvalidTxnAmountException("Transaction amount must be greater than or equal to 0");
		}
		if (txn.getGst() < 0) {
			throw new InvalidTxnAmountException("Gst amount must be greater than or equal to 0");
		}
		if (txn.getCommission() < 0) {
			throw new InvalidTxnAmountException("Commission must be greater than or equal to 0");
		}
		txnRepository.save(txn);
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<List<Txn>> getAllTxns(double initialRange, double finalRange) {
		List<Txn> txns = txnRepository.findByAmountBetween(initialRange, finalRange);
		if (txns.isEmpty()) {
			throw new InvalidTxnAmountException("No Txns are available for that provided range!");
		}
		return ResponseEntity.ok(txns);
	}

	@Override
	public ResponseEntity<List<Txn>> sortTxns() {
		List<Txn> txns = txnRepository.findAllByOrderByAmountAsc();
		return ResponseEntity.ok(txns);
	}

}
