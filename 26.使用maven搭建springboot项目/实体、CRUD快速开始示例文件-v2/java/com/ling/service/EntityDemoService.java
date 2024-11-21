package com.ling.service;

import com.ling.entity.dto.EntityDemoDto;
import com.ling.entity.dto.EntityDemoQuery;
import com.ling.entity.po.EntityDemo;
import com.ling.entity.vo.EntityDemoVo;
import com.ling.entity.vo.PageBean;

import java.util.List;

public interface EntityDemoService {

    /**
     * 条件查询，返回po集
     *
     * @param entityDemoParam 查询条件
     * @return
     */
    PageBean<EntityDemo> findByCondition(EntityDemoQuery entityDemoParam);

    /**
     * 条件查询，返回vo集
     *
     * @param entityDemoParam 查询条件
     * @return
     */
    PageBean<EntityDemoVo> findVoListByCondition(EntityDemoQuery entityDemoParam);

    /**
     * 查询所有
     *
     * @return
     */
    List<EntityDemo> findAll();   // 返回实体

    /**
     * 通过id查询，返回vo
     *
     * @param id id
     * @return
     */
    EntityDemoVo findVoById(String id);

    /**
     * 通过id查询，返回po
     *
     * @param id id
     * @return
     */
    EntityDemo findById(String id);

//    /**
//     * 通过id查询，返回vo
//     *
//     * @param id id
//     * @return
//     */
//    EntityDemoVo findById(Integer id);

//    /**
//     * 通过id查询，返回po
//     *
//     * @param id id
//     * @return
//     */
//    EntityDemo findById(Integer id);

//    /**
//     * 通过 xxx 查询，返回vo
//     *
//     * @param xxx xxx
//     * @return
//     */
//    EntityDemoVo findByxxx(String xxx);

//    /**
//     * 通过 xxx 查询，返回po
//     *
//     * @param xxx xxx
//     * @return
//     */
//    EntityDemo findByxxx(String xxx);

    /**
     * 添加
     *
     * @param entityDemo po
     */
    void add(EntityDemo entityDemo);

    /**
     * 批量添加
     *
     * @param list po集合
     */
    void batchAdd(List<EntityDemo> list);

    /**
     * 添加
     *
     * @param entityDemoDto dto
     */
    void dto4Add(EntityDemoDto entityDemoDto);

    /**
     * 批量添加
     *
     * @param list dto集合
     */
    void dto4BatchAdd(List<EntityDemoDto> list);

    /**
     * 编辑
     *
     * @param entityDemo po
     */
    void edit(EntityDemo entityDemo);

    /**
     * 批量编辑
     *
     * @param list po集合
     */
    void batchEdit(List<EntityDemo> list);


    /**
     * 编辑
     *
     * @param entityDemoDto dto
     */
    void dto4Edit(EntityDemoDto entityDemoDto);

    /**
     * 批量编辑
     *
     * @param list dto集合
     */
    void dto4BatchEdit(List<EntityDemoDto> list);

    /**
     * 删除/批量删除
     *
     * @param list id集合
     */
    void delete(List<String> list);

//    /**
//     * 删除/批量删除
//     *
//     * @param ids id集合
//     */
//    void delete(List<Integer> ids);
}
