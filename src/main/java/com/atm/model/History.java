package com.atm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="History")
public class History {

	@Id
	@GeneratedValue
	private Long id;
	private Long userId;
	private Long accountNumber;
	private String userName;
	private String transactionType;
	private String transactionStatus;
	private Double remainingBalance;
	private Double amountDebited;
	private String transactionDate;
}
