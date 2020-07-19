package com.example.demo.entity;

public class VmhostDTO {

  private VmhostPO vmhost;
  private AuthUserPO authUser;
  private AuthTenantPO authTenant;

  public VmhostDTO(VmhostPO vmhost, AuthUserPO authUser, AuthTenantPO authTenant) {
    this.vmhost = vmhost;
    this.authUser = authUser;
    this.authTenant = authTenant;
  }

  public VmhostPO getVmhost() {
    return vmhost;
  }

  public void setVmhost(VmhostPO vmhost) {
    this.vmhost = vmhost;
  }

  public AuthUserPO getAuthUser() {
    return authUser;
  }

  public void setAuthUser(AuthUserPO authUser) {
    this.authUser = authUser;
  }

  public AuthTenantPO getAuthTenant() {
    return authTenant;
  }

  public void setAuthTenant(AuthTenantPO authTenant) {
    this.authTenant = authTenant;
  }

  
  
}