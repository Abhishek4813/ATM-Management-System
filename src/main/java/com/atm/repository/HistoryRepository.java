package com.atm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.atm.model.History;

public interface HistoryRepository extends CrudRepository<History,Long>{

	public List<History> findByUserId(Long id);
}
