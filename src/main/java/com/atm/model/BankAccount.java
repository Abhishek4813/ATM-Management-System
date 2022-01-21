package com.atm.model;

import javax.persistence.Column;
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
@Table(name="bankaccount")
public class BankAccount {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="account_number")
	private Long accountNumber;
	
	@Column(name="available_balance")
	private Double availableBalance;
}
