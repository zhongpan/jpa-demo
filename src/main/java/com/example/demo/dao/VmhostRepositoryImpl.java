package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.QAuthTenantPO;
import com.example.demo.entity.QAuthUserPO;
import com.example.demo.entity.QVmhostPO;
import com.example.demo.entity.VmhostDTO;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class VmhostRepositoryImpl extends BaseRepository implements VmhostRepository {

  // 多表左连接

  @Override
  public List<VmhostDTO> findVmhost(Predicate predicate) {
    JPAQueryFactory queryFactory = new JPAQueryFactory(em);
    JPAQuery<VmhostDTO> jpaQuery = queryFactory
        .select(Projections.constructor(VmhostDTO.class, QVmhostPO.vmhostPO, QAuthUserPO.authUserPO,
            QAuthTenantPO.authTenantPO))
        .from(QVmhostPO.vmhostPO).leftJoin(QAuthUserPO.authUserPO)
        .on(QVmhostPO.vmhostPO.userid.stringValue().eq(QAuthUserPO.authUserPO.id.stringValue()))
        .leftJoin(QAuthTenantPO.authTenantPO)
        .on(QVmhostPO.vmhostPO.tenantid.stringValue().eq(QAuthTenantPO.authTenantPO.id.stringValue()));
    jpaQuery.where(predicate);
    return jpaQuery.fetch();
  }

  @Override
  public QueryResults<VmhostDTO> findVmhostByPage(Predicate predicate, Pageable pageable) {
    JPAQueryFactory queryFactory = new JPAQueryFactory(em);
    JPAQuery<VmhostDTO> jpaQuery = queryFactory
        .select(Projections.constructor(VmhostDTO.class, QVmhostPO.vmhostPO, QAuthUserPO.authUserPO,
            QAuthTenantPO.authTenantPO))
        .from(QVmhostPO.vmhostPO).leftJoin(QAuthUserPO.authUserPO)
        .on(QVmhostPO.vmhostPO.userid.stringValue().eq(QAuthUserPO.authUserPO.id.stringValue()))
        .leftJoin(QAuthTenantPO.authTenantPO)
        .on(QVmhostPO.vmhostPO.tenantid.stringValue().eq(QAuthTenantPO.authTenantPO.id.stringValue()))
        .offset(pageable.getOffset()).limit(pageable.getPageSize());
    jpaQuery.where(predicate);
    return jpaQuery.fetchResults();
  }

}