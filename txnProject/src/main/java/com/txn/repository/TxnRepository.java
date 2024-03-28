package com.txn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.txn.entity.Txn;

public interface TxnRepository extends JpaRepository<Txn, Long> {

	List<Txn> findByAmountBetween(double initialRange, double finalRange);

	List<Txn> findAllByOrderByAmountAsc();

}
