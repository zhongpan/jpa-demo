package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.demo.entity.VmhostDTO;
import com.example.demo.entity.VmhostInfoByProjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VmhostEMDao {

  @Autowired
  @PersistenceContext
  private EntityManager entityManager;

  // 方案三：使用原生的entityManager，解决@Query的SQL无法动态拼接问题
  // 此时分页就需要自己封装了，也没有了JPA自动实现的接口
  // 注意这里like后面要引号

  @SuppressWarnings("unchecked")
  public List<VmhostDTO> findVmhost(String name) {
    List<VmhostDTO> list = entityManager.createQuery(
        "select new com.example.demo.entity.VmhostDTO(v, u, t) from VmhostPO v left join AuthUserPO u on v.userid = u.id left join AuthTenantPO t on v.tenantid = t.id where v.name like '%"
            + name + "%'")
        .getResultList();
    return list;
  }

  @SuppressWarnings("unchecked")
  public List<VmhostInfoByProjection> findVmhostInfoByProjection() {
    // 此时总是Object[]，不支持投影
    List<VmhostInfoByProjection> list = entityManager.createQuery(
        "select v.id as id, v.name as name, u.username as userName, t.name as tname from VmhostPO v left join AuthUserPO u on v.userid = u.id left join AuthTenantPO t on v.tenantid = t.id")
        .getResultList();
    return list;
  }

}