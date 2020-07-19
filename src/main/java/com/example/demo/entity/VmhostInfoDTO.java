package com.example.demo.entity;

public class VmhostInfoDTO {

  private String id;
  private String name;
  private String userName;
  private String tenantName;

  public VmhostInfoDTO(String id, String name, String userName, String tenantName) {
    this.id = id;
    this.name = name;
    this.userName = userName;
    this.tenantName = tenantName;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getTenantName() {
    return tenantName;
  }

  public void setTenantName(String tenantName) {
    this.tenantName = tenantName;
  }

}