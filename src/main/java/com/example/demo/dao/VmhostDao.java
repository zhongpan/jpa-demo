package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.VmhostDTO;
import com.example.demo.entity.VmhostInfoDTO;
import com.example.demo.entity.VmhostInfoByProjection;
import com.example.demo.entity.VmhostPO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VmhostDao extends JpaRepository<VmhostPO, String> {

  // 方法一：使用@Query注解，可以自定义接收对象
  // 问题：查询条件要嵌入SQL语句内，一些复杂的情形不好处理，例如某个字段模糊检索，字段是动态的；分页查询countQuery把查询语句重复了一遍

  @Query("select new com.example.demo.entity.VmhostDTO(v, u, t) from VmhostPO v left join AuthUserPO u on v.userid = u.id left join AuthTenantPO t on v.tenantid = t.id where v.name like %?1%")
  List<VmhostDTO> findVmhost(String name);

  @Query("select new com.example.demo.entity.VmhostInfoDTO(v.id, v.name, u.username, t.name) from VmhostPO v left join AuthUserPO u on v.userid = u.id left join AuthTenantPO t on v.tenantid = t.id where v.name like %:name%")
  List<VmhostInfoDTO> findVmhostInfo(String name);

  @Query("select v.id as id, v.name as name, u.username as userName, t.name as tname from VmhostPO v left join AuthUserPO u on v.userid = u.id left join AuthTenantPO t on v.tenantid = t.id")
  List<VmhostInfoByProjection> findVmhostInfoByProjection();

  @Query(value = "select new com.example.demo.entity.VmhostInfoDTO(v.id, v.name, u.username, t.name) from VmhostPO v left join AuthUserPO u on v.userid = u.id left join AuthTenantPO t on v.tenantid = t.id where v.name like %:name%", countQuery = "select count(*) from VmhostPO v left join AuthUserPO u on v.userid = u.id left join AuthTenantPO t on v.tenantid = t.id where v.name like %:name%")
  Page<VmhostInfoDTO> findVmhostInfoByPage(String name, Pageable pageable);

}
