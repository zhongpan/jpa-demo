package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.VmhostDTO;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Predicate;

import org.springframework.data.domain.Pageable;

public interface VmhostRepository {

  public List<VmhostDTO> findVmhost(Predicate predicate);

  public QueryResults<VmhostDTO> findVmhostByPage(Predicate predicate, Pageable pageable);

}