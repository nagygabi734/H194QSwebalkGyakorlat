package com.h194qs.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.h194qs.app.model.Foods;
import com.h194qs.app.repository.FoodRepository;

@Service
@Transactional
public class FoodService {

	@Autowired
	private FoodRepository frepo;
	
	public List<Foods> listAll() {
		return frepo.findAll();
	}
	
	public void save(Foods f) {
		frepo.save(f);
	}
	
	public Foods get(long id) {
		return frepo.findById(id).get();
	}
	
	public void delete(long id) {
		frepo.deleteById(id);
	}
}
