package com.ling.service;

import com.ling.entity.vo.PageBean;

import java.util.List;

public interface :@@ {
	/** 
	 * 
	 * 条件查询
	 * @param  
	 * */
	PageBean<#-#> findByCondition(>:-::- %%);

	/** 
	 * 
	 * 查询所有
	 * */
	List<#-#> findAll();

	/** 
	 * 
	 * 通过id查询
	 * @param
	 * */
	#-# findById(String id);

	/** 
	 * 
	 * 通过id查询
	 * @param
	 * */
	#-# findById(Integer id);

	/** 
	 * 
	 * 添加
	 * @param
	 * */
	void add(&& &-&);

	/** 
	 * 
	 * 批量添加
	 * @param
	 * */
	void batchAdd(List<&&> list);

	/** 
	 * 
	 * 编辑
	 * @param
	 * */
	void edit(-** *-*);

	/** 
	 * 
	 * 批量编辑
	 * @param
	 * */
	void batchEdit(List<-**> list);

	/** 
	 * 
	 * 删除
	 * @param
	 * */
	void delete(List<String> ids);

	/** 
	 * 
	 * 删除
	 * @param
	 * */
	void delete(List<Integer> ids);
}