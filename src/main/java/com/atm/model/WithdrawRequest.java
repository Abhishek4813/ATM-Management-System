package com.atm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WithdrawRequest {

	private Long userId;
	private Long accountNumber;
	private Double amount;
}
