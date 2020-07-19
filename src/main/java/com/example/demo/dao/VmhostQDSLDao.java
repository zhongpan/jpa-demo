package com.example.demo.dao;

import com.example.demo.entity.VmhostPO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface VmhostQDSLDao extends JpaRepository<VmhostPO, String>, QuerydslPredicateExecutor<VmhostPO>, VmhostRepository {

  // 方案五：VmhostRepository使用原生的entityManager配合QueryDSL，完美解决所有问题
  // 对于单表也可以使用QuerydslPredicateExecutor，自动拥有默认实现
  
}