package com.example.demo.dao;

import com.example.demo.entity.VmhostWithRelationPO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VmhostSpecWithRelationDao
    extends JpaRepository<VmhostWithRelationPO, String>, JpaSpecificationExecutor<VmhostWithRelationPO> {

  // 方案二：使用Specification查询
  // 问题：实体必须配置关系，否则无法左连接；每个关联对象是单独数据库查询
}