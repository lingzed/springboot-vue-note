package com.ling.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ling.entity.vo.PageBean;
import com.ling.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class :@@ {
	private Logger log = LoggerFactory.getLogger(:@@.class);

	@Resource
	private ^^ ^-^;

	/** 
	 * 
	 * 条件查询
	 * @param  
	 * */
	@Override
	public PageBean<#-#> findByCondition(>:-::- %%) {
		PageHelper.startPage(%%.getPage(), %%.getPageSize());
		List<#-#> list = ^-^.selectByCondition(%%).stream().map(e -> {
			#-# ## = new #-#();
			BeanUtils.copyProperties(e, ##);
			return ##;
		}).collect(Collectors.toList());
		Page<#-#> p = (Page<#-#>) list;
		return PageBean.of(p.getTotal(), %%.getPage(), p.getPageSize(), p.getPages(), p.getResult());
	};

	/** 
	 * 
	 * 查询所有
	 * */
	@Override
	public List<#-#> findAll() {
		List<#-#> list = ^-^.selectAll().stream().map(e -> {
			#-# ## = new #-#();
			BeanUtils.copyProperties(e, ##)
			return ##;
		}.collect(Collectors.toList());
		return list;
	}

	/** 
	 * 
	 * 通过id查询
	 * @param
	 * */
	@Override
	public #-# findById(String id) {
		return ^-^.selectById(id);
	};

	/** 
	 * 
	 * 通过id查询
	 * @param
	 * */
	@Override
	public #-# findById(Integer id) {
		return ^-^.selectById(id);
	};

	/** 
	 * 
	 * 添加
	 * @param
	 * */
	@Override
	public void add(&& &-&) {
		#-# ## = new #-#();
		BeanUtils.copyProperties(&-&, ##);
		Date date = new Date();
		##.setCreateTime(date);
		##.setUpdateTime(date);
		^-^.insert(##);
	};

	/** 
	 * 
	 * 批量添加
	 * @param
	 * */
	@Override
	public void batchAdd(List<&&> list) {
		List<#-#> ##s = list.stream().map(e -> {
			#-# ## = new #-#();
			BeanUtils.copyProperties(e, ##);
			Date date = new Date();
			##.setCreateTime(date);
			##.setUpdateTime(date);
			return ##;
		}).collect(Collectors.toList());
		^-^.batchInsert(##s);
	};

	/** 
	 * 
	 * 编辑
	 * @param
	 * */
	@Override
	public void edit(-** *-*) {
		#-# ## = new #-#();
		BeanUtils.copyProperties(*-*, ##);
		Date date = new Date();
		##.setUpdateTime(date);
		^-^.update(##);
	};


	/** 
	 * 
	 * 批量编辑
	 * @param
	 * */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void batchEdit(List<-**> list) {
		List<#-#> ##s = list.stream().map(e -> {
			#-# ## = new #-#();
			BeanUtils.copyProperties(e, ##);
			Date date = new Date();
			##.setUpdateTime(date);
			return ##;
		}).collect(Collectors.toList());
		^-^.batchUpdate(##s);
	};

	/** 
	 * 
	 * 删除
	 * @param
	 * */
	public void delete(List<String> ids) {
		^-^.delete(ids);
	};

	/** 
	 * 
	 * 删除
	 * @param
	 * */
	public void delete(List<Integer> ids) {
		^-^.delete(ids);
	};
}