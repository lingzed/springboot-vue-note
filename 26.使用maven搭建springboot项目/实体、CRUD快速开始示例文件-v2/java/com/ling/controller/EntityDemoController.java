package com.ling.controller;

import com.ling.entity.dto.EntityDemoDto;
import com.ling.entity.dto.EntityDemoQuery;
import com.ling.entity.po.EntityDemo;
import com.ling.entity.vo.EntityDemoVo;
import com.ling.entity.vo.PageBean;
import com.ling.entity.vo.Result;
import com.ling.service.EntityDemoService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RequestMapping("/entity")
@RestController
public class EntityDemoController {

    @Resource
    private EntityDemoService entityDemoService;

    @GetMapping("/vo")
    public Result<PageBean<EntityDemoVo>> getEntityDemoVo(@RequestParam(defaultValue = "1") Integer page,
                                                          @RequestParam(defaultValue = "10") Integer pageSize,
                                                          String stringField,
                                                          Integer intField,
                                                          @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                          @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        EntityDemoQuery entityDemoQuery = new EntityDemoQuery();
        entityDemoQuery.setPage(page);
        entityDemoQuery.setPageSize(pageSize);
        entityDemoQuery.setStringField(stringField);
        entityDemoQuery.setIntField(intField);
        entityDemoQuery.setStartDate(startDate);
        entityDemoQuery.setEndDate(endDate);
        PageBean<EntityDemoVo> voListByCondition = entityDemoService.findVoListByCondition(entityDemoQuery);
        return Result.success(voListByCondition);
    }

    @GetMapping("/po")
    public Result<PageBean<EntityDemo>> getEntityDemoPo(@RequestParam(defaultValue = "1") Integer page,
                                                        @RequestParam(defaultValue = "10") Integer pageSize,
                                                        String stringField,
                                                        Integer intField,
                                                        @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                        @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        EntityDemoQuery entityDemoQuery = new EntityDemoQuery();
        entityDemoQuery.setPage(page);
        entityDemoQuery.setPageSize(pageSize);
        entityDemoQuery.setStringField(stringField);
        entityDemoQuery.setIntField(intField);
        entityDemoQuery.setStartDate(startDate);
        entityDemoQuery.setEndDate(endDate);
        PageBean<EntityDemo> entityDemoPageBean = entityDemoService.findByCondition(entityDemoQuery);
        return Result.success(entityDemoPageBean);
    }

    @GetMapping("/all")
    public Result<List<EntityDemo>> getAll() {
        List<EntityDemo> all = entityDemoService.findAll();
        return Result.success(all);
    }

    @GetMapping("/{id}")
    public Result<EntityDemo> getItem(@PathVariable String id) {
        return Result.success(entityDemoService.findById(id));
    }

    @GetMapping("/vo/{id}")
    public Result<EntityDemoVo> getItemVo(@PathVariable String id) {
        return Result.success(entityDemoService.findVoById(id));
    }

    @PostMapping
    public Result add(@RequestBody EntityDemo entityDemo) {
        entityDemoService.add(entityDemo);
        return Result.success();
    }

    @PostMapping("/batch")
    public Result adds(@RequestBody List<EntityDemo> entityDemos) {
        entityDemoService.batchAdd(entityDemos);
        return Result.success();
    }

    @PostMapping("/dto")
    public Result adddto(@RequestBody EntityDemoDto entityDemoDto) {
        entityDemoService.dto4Add(entityDemoDto);
        return Result.success();
    }

    @PostMapping("/batch/dto")
    public Result adddtos(@RequestBody List<EntityDemoDto> entityDemoDtos) {
        entityDemoService.dto4BatchAdd(entityDemoDtos);
        return Result.success();
    }

    @PutMapping
    public Result edit(@RequestBody EntityDemo entityDemo) {
        entityDemoService.edit(entityDemo);
        return Result.success();
    }

    @PutMapping("/batch")
    public Result edits(@RequestBody List<EntityDemo> entityDemos) {
        entityDemoService.batchEdit(entityDemos);
        return Result.success();
    }

    @PutMapping("dto")
    public Result editdto(@RequestBody EntityDemoDto entityDemoDto) {
        System.out.println("dto执行");
        entityDemoService.dto4Edit(entityDemoDto);
        return Result.success();
    }

    @PutMapping("/batch/dto")
    public Result editdtos(@RequestBody List<EntityDemoDto> entityDemoDtos) {
        System.out.println("dto执行");
        entityDemoService.dto4BatchEdit(entityDemoDtos);
        return Result.success();
    }

    @DeleteMapping("/{ids}")
    public Result del(@PathVariable List<String> ids) {
        entityDemoService.delete(ids);
        return Result.success();
    }
}
