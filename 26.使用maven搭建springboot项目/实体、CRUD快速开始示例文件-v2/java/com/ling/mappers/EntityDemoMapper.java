package com.ling.mappers;

import com.ling.entity.dto.EntityDemoQuery;
import com.ling.entity.po.EntityDemo;
import com.ling.entity.vo.EntityDemoVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EntityDemoMapper {

    /**
     * 条件查询，返回po集
     *
     * @param entityDemoParam 查询条件
     * @return
     */
    List<EntityDemo> selectByCondition(EntityDemoQuery entityDemoParam);

    /**
     * 条件查询，返回vo集
     *
     * @param entityDemoParam 查询条件
     * @return
     */
    List<EntityDemoVo> selectVoListByCondition(EntityDemoQuery entityDemoParam);

    /**
     * 查询所有
     *
     * @return
     */
    List<EntityDemo> selectAll();

    /**
     * 通过id查询
     *
     * @param id id
     * @return
     */
    EntityDemo selectById(String id);

//    /**
//     * 通过id查询
//     *
//     * @param id id
//     * @return
//     */
//    EntityDemo selectById(Integer id);

//    /**
//     * 通过 xxx 查询
//     *
//     * @param xxx xxx
//     * @return
//     */
//    EntityDemo selectByxxx(String xxx);

    /**
     * 添加
     *
     * @param entityDemo 实体
     */
    void insert(EntityDemo entityDemo);

    /**
     * 批量添加
     *
     * @param list 实体集合
     */
    void batchInsert(List<EntityDemo> list);

    /**
     * 编辑
     *
     * @param entityDemo 实体
     */
    void update(EntityDemo entityDemo);

    /**
     * 批量编辑
     *
     * @param list 实体集合
     */
    void batchUpdate(List<EntityDemo> list);

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
