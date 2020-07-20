package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import com.example.demo.dao.VmhostCQDao;
import com.example.demo.dao.VmhostDao;
import com.example.demo.dao.VmhostEMDao;
import com.example.demo.dao.VmhostQDSLDao;
import com.example.demo.dao.VmhostSpecDao;
import com.example.demo.dao.VmhostSpecWithRelationDao;
import com.example.demo.entity.AuthTenantPO;
import com.example.demo.entity.AuthUserPO;
import com.example.demo.entity.QVmhostPO;
import com.example.demo.entity.VmhostDTO;
import com.example.demo.entity.VmhostInfoByProjection;
import com.example.demo.entity.VmhostInfoDTO;
import com.example.demo.entity.VmhostPO;
import com.example.demo.entity.VmhostWithRelationPO;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class VmhostService {

  @Autowired
  VmhostDao vmhostDao;

  @Autowired
  VmhostSpecDao vmhostSpecDao;

  @Autowired
  VmhostSpecWithRelationDao vmhostSpecWithRelationDao;

  @Autowired
  VmhostEMDao vmhostEMDao;

  @Autowired
  VmhostCQDao vmhostCQDao;

  @Autowired
  VmhostQDSLDao vmhostQDSLDao;

  public List<VmhostDTO> listVmhost(String name) {
    return vmhostDao.findVmhost(name);
  }

  public List<VmhostInfoDTO> listVmhostInfo(String name) {
    return vmhostDao.findVmhostInfo(name);
  }

  public List<VmhostInfoByProjection> listVmhostInfoByProjection() {
    return vmhostDao.findVmhostInfoByProjection();
  }

  public Page<VmhostInfoDTO> listVmhostInfoByPage(String name) {
    Pageable pageable = PageRequest.of(0, 5);
    return vmhostDao.findVmhostInfoByPage(name, pageable);
  }

  public List<VmhostDTO> listVmhostEM(String name) {
    return vmhostEMDao.findVmhost(name);
  }

  public List<VmhostInfoByProjection> listVmhostInfoByProjectionEM() {
    return vmhostEMDao.findVmhostInfoByProjection();
  }

  public List<VmhostDTO> listVmhostCQ(String name) {
    return vmhostCQDao.findVmhost(name);
  }

  public List<VmhostDTO> listVmhostQDSL(String name) {
    Predicate predicate = QVmhostPO.vmhostPO.name.like("%" + name + "%");
    return vmhostQDSLDao.findVmhost(predicate);
  }

  public QueryResults<VmhostDTO> listVmhostByPageQDSL(String name) {
    Predicate predicate = QVmhostPO.vmhostPO.name.like("%" + name + "%");
    PageRequest pageRequest = PageRequest.of(0, 10);
    return vmhostQDSLDao.findVmhostByPage(predicate, pageRequest);
  }

  public Iterable<VmhostPO> listVmhostPOQDSL(String name) {
    Predicate predicate = QVmhostPO.vmhostPO.name.like("%" + name + "%");
    return vmhostQDSLDao.findAll(predicate);
  }

  public List<VmhostInfoDTO> listVmhostInfoSpecAndQuery(String name) {
    Specification<VmhostInfoDTO> spec = (root, cq, cb) -> {
      return cb.like(root.get("name"), "%" + name + "%");

    };
    // spec没有用，总是@Query有效
    return vmhostSpecDao.findAll(spec);
  }

  public List<VmhostPO> listVmhostSpecAndQuery(String name) {
    Specification<VmhostPO> spec = (root, cq, cb) -> {
      return cb.like(root.get("name"), "%" + name + "%");
    };
    // spec没有用，总是@Query有效
    return vmhostSpecDao.findVmhost(spec);
  }

    // 这样写没有用，生成如下sql
    // select vmhostpo0_.id as id1_2_, vmhostpo0_.addresses as addresse2_2_, vmhostpo0_.availablezone as availabl3_2_, vmhostpo0_.baremetal as baremeta4_2_, vmhostpo0_.cpucore as cpucore5_2_, vmhostpo0_.createtime as createti6_2_, vmhostpo0_.disksize as disksize7_2_, vmhostpo0_.floatip as floatip8_2_, vmhostpo0_.hostname as hostname9_2_, vmhostpo0_.locked as locked10_2_, vmhostpo0_.metadata as metadat11_2_, vmhostpo0_.name as name12_2_, vmhostpo0_.privatenetworkid as private13_2_, vmhostpo0_.ramsize as ramsize14_2_, vmhostpo0_.tenantid as tenanti15_2_, vmhostpo0_.tenantname as tenantn16_2_, vmhostpo0_.type as type17_2_, vmhostpo0_.userid as userid18_2_, vmhostpo0_.username as usernam19_2_, vmhostpo0_.vmstatus as vmstatu20_2_ from vmhost vmhostpo0_ cross join auth_user authuserpo1_ cross join auth_tenant authtenant2_ where vmhostpo0_.userid=authuserpo1_.id and vmhostpo0_.tenantid=authtenant2_.id and (vmhostpo0_.name like ?)
  public Optional<VmhostInfoDTO> listVmhostSpec(String name) {
    Specification<VmhostInfoDTO> spec = (root, cq, cb) -> {
      // 只能cross join，要left join需要在实体上建立关系
      Root<AuthUserPO> user = cq.from(AuthUserPO.class);
      Root<AuthTenantPO> tenant = cq.from(AuthTenantPO.class);
      // 这里执行select没有用，这个函数只能返回查询条件，外层会覆盖select
      cq.multiselect(root.get("id"), root.get("name"), user.get("username"), tenant.get("name"));
      return cb.and(cb.equal(root.get("userid"), user.get("id")), cb.equal(root.get("tenantid"), tenant.get("id")),
          cb.like(root.get("name"), "%" + name + "%"));

    };
    return vmhostSpecDao.findOne(spec);
  }



  public List<VmhostWithRelationPO> listVmhostSpecWithRelation(String name) {
    Specification<VmhostWithRelationPO> spec = (root, cq, cb) -> {
      root.join("user", JoinType.LEFT);
      root.join("tenant", JoinType.LEFT);
      return cb.like(root.get("name"), "%" + name + "%");
    };
    List<VmhostWithRelationPO> list = vmhostSpecWithRelationDao.findAll(spec);
    return list;
  }

}
