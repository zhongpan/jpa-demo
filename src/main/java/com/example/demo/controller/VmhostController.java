package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.VmhostDTO;
import com.example.demo.entity.VmhostInfoByProjection;
import com.example.demo.entity.VmhostInfoDTO;
import com.example.demo.entity.VmhostPO;
import com.example.demo.entity.VmhostWithRelationPO;
import com.example.demo.service.VmhostService;
import com.querydsl.core.QueryResults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VmhostController {

  @Autowired
  VmhostService vmhostService;

  @GetMapping("/query/vmhostdto")
  public List<VmhostDTO> listVmhost(@RequestParam String name) {
    return vmhostService.listVmhost(name);
  }

  @GetMapping("/query/vmhostinfodto")
  public List<VmhostInfoDTO> listVmhostInfo(@RequestParam String name) {
    return vmhostService.listVmhostInfo(name);
  }

  @GetMapping("/query/vmhostinfobyprojection")
  public List<VmhostInfoByProjection> listVmhostInfoByProjection() {
    return vmhostService.listVmhostInfoByProjection();
  }

  @GetMapping("/query/vmhostinfodto_by_page")
  public Page<VmhostInfoDTO> listVmhostInfoByPage(@RequestParam String name) {
    return vmhostService.listVmhostInfoByPage(name);
  }

  @GetMapping("/em/vmhostdto")
  public List<VmhostDTO> listVmhostEM(@RequestParam String name) {
    return vmhostService.listVmhostEM(name);
  }

  @GetMapping("/em/vmhostinfobyprojection")
  public List<VmhostInfoByProjection> listVmhostInfoByProjectionEM() {
    return vmhostService.listVmhostInfoByProjectionEM();
  }

  @GetMapping("/cq/vmhostdto")
  public List<VmhostDTO> listVmhostCQ(@RequestParam String name) {
    return vmhostService.listVmhostCQ(name);
  }

  @GetMapping("/qdsl/vmhostdto")
  public List<VmhostDTO> listVmhostQDSL(@RequestParam String name) {
    return vmhostService.listVmhostQDSL(name);
  }

  @GetMapping("/qdsl/vmhostdto_by_page")
  public QueryResults<VmhostDTO> listVmhostByPageQDSL(@RequestParam String name) {
    return vmhostService.listVmhostByPageQDSL(name);
  }

  @GetMapping("/qdsl/vmhostpo")
  public Iterable<VmhostPO> listVmhostPOQDSL(@RequestParam String name) {
    return vmhostService.listVmhostPOQDSL(name);
  }

  @GetMapping("/spec_and_query/vmhostinfodto")
  public List<VmhostInfoDTO> listVmhostInfoSpecAndQuery(@RequestParam String name) {
    return vmhostService.listVmhostInfoSpecAndQuery(name);
  }

  @GetMapping("/spec_and_query/vmhostpo")
  public List<VmhostPO> listVmhostSpecAndQuery(@RequestParam String name) {
    return vmhostService.listVmhostSpecAndQuery(name);
  }

  @GetMapping("/spec/vmhostinfodto")
  public Optional<VmhostInfoDTO> getVmhost(@RequestParam String name) {
    return vmhostService.listVmhostSpec(name);
  }

  @GetMapping("/spec/vmhostwithrelationpo")
  public List<VmhostWithRelationPO> listVmhostSpecWithRelation(@RequestParam String name) {
    return vmhostService.listVmhostSpecWithRelation(name);
  }

  @GetMapping("/spec/vmhostwithrelationpo_by_page")
  public Page<VmhostWithRelationPO> listVmhostSpecWithRelationByPage(@RequestParam String name) {
    return vmhostService.listVmhostSpecWithRelationByPage(name);
  }
}