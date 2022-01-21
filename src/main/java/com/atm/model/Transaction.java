package com.atm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="transaction")
public class Transaction {
	
	@Id
	@GeneratedValue
	private Long id;
	private Long userId;
	private Long accountNumber;
	private String userName;
	private Double amountDebited;
	private String transactionDate;

}
