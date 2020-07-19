package com.example.demo.dao;

import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@NoRepositoryBean
public class BaseRepository {

  @PersistenceContext
  protected EntityManager em;

}