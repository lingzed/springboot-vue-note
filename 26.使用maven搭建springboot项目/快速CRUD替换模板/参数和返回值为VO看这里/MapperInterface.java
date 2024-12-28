package com.ling.mappers;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface :@@ {
	/** 
	 * 
	 * 条件查询
	 * @param  
	 * */
	List<#-#> selectByCondition(>:-::- %%);

	/** 
	 * 
	 * 查询所有
	 * */
	List<#-#> selectAll();

	/** 
	 * 
	 * 通过id查询
	 * @param
	 * */
	#-# selectById(String id);

	/** 
	 * 
	 * 通过id查询
	 * @param
	 * */
	#-# selectById(Integer id);

	/** 
	 * 
	 * 添加
	 * @param
	 * */
	void insert(&& &-&);

	/** 
	 * 
	 * 批量添加
	 * @param
	 * */
	void batchInsert(List<&&> list);

	/** 
	 * 
	 * 编辑
	 * @param
	 * */
	void update(-** *-*);

	/** 
	 * 
	 * 批量编辑
	 * @param
	 * */
	void batchUpdate(List<-**> list);

	/** 
	 * 
	 * 删除
	 * @param
	 * */
	void delete(List<String> list);

	/** 
	 * 
	 * 删除
	 * @param
	 * */
	void delete(List<Integer> list);
}