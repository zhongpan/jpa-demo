package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.example.demo.entity.AuthTenantPO;
import com.example.demo.entity.AuthUserPO;
import com.example.demo.entity.VmhostDTO;
import com.example.demo.entity.VmhostPO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VmhostCQDao {

  @Autowired
  @PersistenceContext
  private EntityManager entityManager;

  // 方案四：相对于方案三，使用了类型安全的CriteriaQuery，其实Specification也是用的CriteriaQuery，所以存在和Specification一样的限制，但是可以控制select了，比Specification灵活一点

  public List<VmhostDTO> findVmhost(String name) {
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<VmhostDTO> query = builder.createQuery(VmhostDTO.class);
    // 实体上没有配置关系，无法使用left join，只能联合查询(inner join)
    Root<VmhostPO> root = query.from(VmhostPO.class);
    Root<AuthUserPO> rootUser = query.from(AuthUserPO.class);
    Root<AuthTenantPO> rootTenant = query.from(AuthTenantPO.class);
    query.multiselect(root, rootUser, rootTenant).where(builder.equal(root.get("userid"), rootUser.get("id")),
        builder.equal(root.get("tenantid"), rootTenant.get("id")), builder.like(root.get("name"), "%" + name + "%"));

    List<VmhostDTO> list = entityManager.createQuery(query).getResultList();
    return list;
  }

}