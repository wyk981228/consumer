package com.zb.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient("SERVICE-PROVIDER")
public interface FeignService {

    @RequestMapping("/list")
    public List findAll(@RequestParam Map map);

    @RequestMapping("/del/{id}")
    public Integer delete(@PathVariable("id")String id);

    @RequestMapping("/get")
    public Map get(@RequestParam(value = "id") String id);

    @RequestMapping("/roles")
    public List getAllRoles();

    @RequestMapping("/set/{id}")
    public Integer update(@RequestParam("id")String id);
}
