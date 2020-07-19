package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.VmhostInfoDTO;
import com.example.demo.entity.VmhostPO;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

// JpaSpecificationExecutor的参数和JpaRepository不一样，没啥用，SimpleJpaRepository总是用的JpaRepository的参数
public interface VmhostSpecDao extends JpaRepository<VmhostPO, String>, JpaSpecificationExecutor<VmhostInfoDTO> {

  // 方案二：@Query和Specification是不能混用的，也无法改变接收结果集对象
  
  // 无法混用，总是query有效
  @Query("from VmhostPO")
  List<VmhostPO> findVmhost(Specification<VmhostPO> spec);
}