package com.sheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sheet.model.MetalDetail;

//@Repository
public interface MetalDetailRepository extends JpaRepository<MetalDetail, Integer> {

}
