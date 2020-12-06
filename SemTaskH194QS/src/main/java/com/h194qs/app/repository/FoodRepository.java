package com.h194qs.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.h194qs.app.model.Foods;

public interface FoodRepository extends JpaRepository<Foods, Long> {

}
