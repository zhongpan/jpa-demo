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

  // 无法混用，总是query有效，spec参数压根就不会理会
  @Query("from VmhostPO")
  List<VmhostPO> findVmhost(Specification<VmhostPO> spec);

  // 覆盖JpaSpecificationExecutor的方法可以吗？一样的，根本不会走到findAll的默认实现 
  @Override
  @Query("select new com.example.demo.entity.VmhostInfoDTO(v.id, v.name, u.username, t.name) from VmhostPO v left join AuthUserPO u on v.userid = u.id left join AuthTenantPO t on v.tenantid = t.id")
  List<VmhostInfoDTO> findAll(Specification<VmhostInfoDTO> spec);
}