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
@Table(name="users")
public class Users {
	
	@Id
	@GeneratedValue
	private Long id;
	private String firstname;
	private String lastname;
	private Integer pin;
}
