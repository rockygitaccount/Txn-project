package com.txn.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.txn.dto.TxnDto;
import com.txn.entity.Txn;

@Component
public class TxnMapper {

	@Autowired
	private ModelMapper modelMapper;

	public Txn dtoToTxn(TxnDto txnDto) {
		Txn txn = modelMapper.map(txnDto, Txn.class);
		return txn;
	}

	public TxnDto txnToDto(Txn txn) {
		TxnDto txnDto = modelMapper.map(txn, TxnDto.class);
		return txnDto;
	}
}
