package com.example.demo.entity;

import org.springframework.beans.factory.annotation.Value;

public interface VmhostInfoByProjection {

  public String getId();

  public String getName();

  public String getUserName();

  @Value("#{target.tname}") // 当别名与该getXXX名称不一致时，可以使用该注解调整
  public String getTenantName();

}