package com.atm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.atm.model.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {
	
	Users findByPin(Integer pin);

}
