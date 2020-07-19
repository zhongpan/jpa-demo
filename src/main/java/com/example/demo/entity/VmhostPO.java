package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vmhost")
public class VmhostPO {

  @Id
  private String id;
  private String name;
  private String availablezone;
  private String type;
  private Long cpucore;
  private Long ramsize;
  private String disksize;
  private String privatenetworkid;
  private java.sql.Timestamp createtime;
  private String vmstatus;
  private String metadata;
  private String addresses;
  private String hostname;
  private String floatip;
  private String tenantid;
  private String userid;
  private String username;
  private String tenantname;
  private int baremetal;
  private String locked;

  public String getLocked() {
    return locked;
  }

  public void setLocked(String locked) {
    this.locked = locked;
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

  public String getAvailablezone() {
    return availablezone;
  }

  public void setAvailablezone(String availablezone) {
    this.availablezone = availablezone;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Long getCpucore() {
    return cpucore;
  }

  public void setCpucore(Long cpucore) {
    this.cpucore = cpucore;
  }

  public Long getRamsize() {
    return ramsize;
  }

  public void setRamsize(Long ramsize) {
    this.ramsize = ramsize;
  }

  public String getDisksize() {
    return disksize;
  }

  public void setDisksize(String disksize) {
    this.disksize = disksize;
  }

  public String getPrivatenetworkid() {
    return privatenetworkid;
  }

  public void setPrivatenetworkid(String privatenetworkid) {
    this.privatenetworkid = privatenetworkid;
  }

  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }

  public String getVmstatus() {
    return vmstatus;
  }

  public void setVmstatus(String vmstatus) {
    this.vmstatus = vmstatus;
  }

  public String getMetadata() {
    return metadata;
  }

  public void setMetadata(String metadata) {
    this.metadata = metadata;
  }

  public String getAddresses() {
    return addresses;
  }

  public void setAddresses(String addresses) {
    this.addresses = addresses;
  }

  public String getHostname() {
    return hostname;
  }

  public void setHostname(String hostname) {
    this.hostname = hostname;
  }

  public String getFloatip() {
    return floatip;
  }

  public void setFloatip(String floatip) {
    this.floatip = floatip;
  }

  public String getTenantid() {
    return tenantid;
  }

  public void setTenantid(String tenantid) {
    this.tenantid = tenantid;
  }

  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getTenantname() {
    return tenantname;
  }

  public void setTenantname(String tenantname) {
    this.tenantname = tenantname;
  }

  public int getBaremetal() {
    return baremetal;
  }

  public void setBaremetal(int baremetal) {
    this.baremetal = baremetal;
  }

}
