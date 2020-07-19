package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auth_tenant")
public class AuthTenantPO {
  @Id
  private Integer id;
  private String tenantId;
  private String name;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;

  @Column(name = "description")
  private String desc;
  private long isFromOpenstack;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getTenantId() {
    return tenantId;
  }

  public void setTenantId(String tenantId) {
    this.tenantId = tenantId;
  }


  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public java.sql.Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(java.sql.Timestamp updateTime) {
    this.updateTime = updateTime;
  }


  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }


  public long getIsFromOpenstack() {
    return isFromOpenstack;
  }

  public void setIsFromOpenstack(long isFromOpenstack) {
    this.isFromOpenstack = isFromOpenstack;
  }


}
