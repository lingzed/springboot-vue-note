package com.ling.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ling.commons.CommonMsg;
import com.ling.entity.dto.EntityDemoDto;
import com.ling.entity.dto.EntityDemoQuery;
import com.ling.entity.po.EntityDemo;
import com.ling.entity.vo.EntityDemoVo;
import com.ling.entity.vo.PageBean;
import com.ling.exception.BusinessException;
import com.ling.mappers.EntityDemoMapper;
import com.ling.service.EntityDemoService;
import com.ling.utils.StrUtil;
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
public class EntityDemoServiceImpl implements EntityDemoService {
    private Logger log = LoggerFactory.getLogger(EntityDemoServiceImpl.class);

    @Resource
    private EntityDemoMapper entityDemoMapper;

    /**
     * 条件查询，返回po集
     *
     * @param entityDemoParam 查询条件
     * @return
     */
    @Override
    public PageBean<EntityDemo> findByCondition(EntityDemoQuery entityDemoParam) {
        try {
            PageHelper.startPage(entityDemoParam.getPage(), entityDemoParam.getPageSize());
            List<EntityDemo> list = entityDemoMapper.selectByCondition(entityDemoParam);
            Page<EntityDemo> p = (Page<EntityDemo>) list;
            return PageBean.of(p.getTotal(),
                    entityDemoParam.getPage(),
                    entityDemoParam.getPageSize(),
                    p.getPages(),
                    p.getResult());
        } catch (Exception e) {
            throw new BusinessException(CommonMsg.QUERY_FAIL, e);
        }
    }

    /**
     * 条件查询，返回vo集
     *
     * @param entityDemoParam 查询条件
     * @return
     */
    @Override
    public PageBean<EntityDemoVo> findVoListByCondition(EntityDemoQuery entityDemoParam) { // 返回vo
        try {
            PageHelper.startPage(entityDemoParam.getPage(), entityDemoParam.getPageSize());
            List<EntityDemoVo> list = entityDemoMapper.selectVoListByCondition(entityDemoParam);
            Page<EntityDemoVo> p = (Page<EntityDemoVo>) list;
            return PageBean.of(p.getTotal(),
                    entityDemoParam.getPage(),
                    entityDemoParam.getPageSize(),
                    p.getPages(),
                    p.getResult());
        } catch (Exception e) {
            throw new BusinessException(CommonMsg.QUERY_FAIL, e);
        }
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<EntityDemo> findAll() {
        try {
            return entityDemoMapper.selectAll();
        } catch (Exception e) {
            throw new BusinessException(CommonMsg.QUERY_FAIL, e);
        }
    }

    /**
     * 通过id查询，返回vo
     *
     * @param id id
     * @return
     */
    @Override
    public EntityDemoVo findVoById(String id) {
        try {
            EntityDemo entityDemo = entityDemoMapper.selectById(id);
            return entityDemo2Vo(entityDemo);
        } catch (Exception e) {
            throw new BusinessException(CommonMsg.QUERY_FAIL, e);
        }
    }

    /**
     * 通过id查询，返回po
     *
     * @param id id
     * @return
     */
    @Override
    public EntityDemo findById(String id) {
        try {
            return entityDemoMapper.selectById(id);
        } catch (Exception e) {
            throw new BusinessException(CommonMsg.QUERY_FAIL, e);
        }
    }

//    /**
//     * 通过id查询，返回vo
//     *
//     * @param id id
//     * @return
//     */
//    @Override
//    public EntityDemoVo findVoById(Integer id) {
//        try {
//            EntityDemo entityDemo = entityDemoMapper.selectById(id);
//            return entityDemo2Vo(entityDemo);
//        } catch (Exception e) {
//            throw new BusinessException(CommonMsg.QUERY_FAIL, e);
//        }
//    }

//    /**
//     * 通过id查询，返回po
//     *
//     * @param id id
//     * @return
//     */
//    @Override
//    public EntityDemo findById(Integer id) {
//        try {
//            return entityDemoMapper.selectById(id);
//        } catch (Exception e) {
//            throw new BusinessException(CommonMsg.QUERY_FAIL, e);
//        }
//    }

//    /**
//     * 通过 xxx 查询，返回vo
//     *
//     * @param xxx xxx
//     * @return
//     */
//    @Override
//    public EntityDemoVo findVoByxxx(xxx xxx) {
//        try {
//            EntityDemo entityDemo = entityDemoMapper.selectById(xxx);
//            return entityDemo2Vo(entityDemo);
//        } catch (Exception e) {
//            throw new BusinessException(CommonMsg.QUERY_FAIL, e);
//        }
//    }

//    /**
//     * 通过 xxx 查询，返回po
//     *
//     * @param xxx xxx
//     * @return
//     */
//    @Override
//    public EntityDemo findById(xxx xxx) {
//        try {
//            return entityDemoMapper.selectById(xxx);
//        } catch (Exception e) {
//            throw new BusinessException(CommonMsg.QUERY_FAIL, e);
//        }
//    }

    /**
     * entityDemo 转换为 vo
     *
     * @param entityDemo po
     * @return
     */
    private EntityDemoVo entityDemo2Vo(EntityDemo entityDemo) {
        EntityDemoVo entityDemoVo = new EntityDemoVo();
        BeanUtils.copyProperties(entityDemo, entityDemoVo);
        return entityDemoVo;
    }

    /**
     * 添加
     *
     * @param entityDemo po
     */
    @Override
    public void add(EntityDemo entityDemo) {
        try {
            entityDemoMapper.insert(repairEntityDemo(entityDemo));
        } catch (Exception e) {
            throw new BusinessException(CommonMsg.ADD_FAIL, e);
        }
    }

    /**
     * 批量添加
     *
     * @param list po集合
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void batchAdd(List<EntityDemo> list) {
        try {
            List<EntityDemo> newList = list.stream().map(this::repairEntityDemo).collect(Collectors.toList());
            entityDemoMapper.batchInsert(newList);
        } catch (Exception e) {
            throw new BusinessException(CommonMsg.ADD_FAIL, e);
        }
    }

    /**
     * 添加
     *
     * @param entityDemoDto dto
     */
    @Override
    public void dto4Add(EntityDemoDto entityDemoDto) {
        try {
            EntityDemo entityDemo = new EntityDemo();
            entityDemo.setStringField(entityDemoDto.getStringField());
            entityDemo.setIntField(entityDemoDto.getIntField());
            entityDemo.setDateField(entityDemoDto.getDateField());
            add(entityDemo);
        } catch (Exception e) {
            throw new BusinessException(CommonMsg.ADD_FAIL, e);
        }
    }

    /**
     * 批量添加
     *
     * @param list dto集合
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void dto4BatchAdd(List<EntityDemoDto> list) {
        try {
            List<EntityDemo> newList = list.stream().map(e -> {
                EntityDemo entityDemo = new EntityDemo();
                entityDemo.setStringField(e.getStringField());
                entityDemo.setIntField(e.getIntField());
                entityDemo.setDateField(e.getDateField());
                return repairEntityDemo(entityDemo);
            }).collect(Collectors.toList());
            entityDemoMapper.batchInsert(newList);
        } catch (Exception e) {
            throw new BusinessException(CommonMsg.ADD_FAIL, e);
        }
    }

    /**
     * 补充 entityDemo 字段
     *
     * @param entityDemo po
     * @return
     */
    private EntityDemo repairEntityDemo(EntityDemo entityDemo) {
        Date date = new Date();
        entityDemo.setId(StrUtil.getRandomNum(10));
        entityDemo.setCreateTime(date);
        entityDemo.setUpdateTime(date);
        return entityDemo;
    }

    /**
     * 编辑
     *
     * @param entityDemo po
     */
    @Override
    public void edit(EntityDemo entityDemo) {
        try {
            Date date = new Date();
            entityDemo.setUpdateTime(date);
            entityDemoMapper.update(entityDemo);
        } catch (Exception e) {
            throw new RuntimeException(CommonMsg.EDIT_FAIL, e);
        }
    }

    /**
     * 批量添加
     *
     * @param list po集合
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void batchEdit(List<EntityDemo> list) {
        try {
            List<EntityDemo> newList = list.stream().map(e -> {
                Date date = new Date();
                e.setUpdateTime(date);
                return e;
            }).collect(Collectors.toList());
            entityDemoMapper.batchUpdate(newList);
        } catch (Exception e) {
            throw new RuntimeException(CommonMsg.EDIT_FAIL, e);
        }
    }

    /**
     * 编辑
     *
     * @param entityDemoDto dto
     */
    @Override
    public void dto4Edit(EntityDemoDto entityDemoDto) {
        try {
            EntityDemo entityDemo = new EntityDemo();
            entityDemo.setId(entityDemoDto.getId());
            entityDemo.setStringField(entityDemoDto.getStringField());
            entityDemo.setIntField(entityDemoDto.getIntField());
            entityDemo.setDateField(entityDemoDto.getDateField());
            edit(entityDemo);
        } catch (Exception e) {
            throw new RuntimeException(CommonMsg.EDIT_FAIL, e);
        }
    }

    /**
     * 批量编辑
     *
     * @param list dto集合
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void dto4BatchEdit(List<EntityDemoDto> list) {
        try {
            List<EntityDemo> newList = list.stream().map(e -> {
                EntityDemo entityDemo = new EntityDemo();
                entityDemo.setId(e.getId());
                entityDemo.setStringField(e.getStringField());
                entityDemo.setIntField(e.getIntField());
                entityDemo.setDateField(e.getDateField());
                Date date = new Date();
                entityDemo.setUpdateTime(date);
                return entityDemo;
            }).collect(Collectors.toList());
            entityDemoMapper.batchUpdate(newList);
        } catch (Exception e) {
            throw new RuntimeException(CommonMsg.EDIT_FAIL, e);
        }
    }

    /**
     * 删除/批量删除
     *
     * @param ids id集合
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<String> ids) {
        try {
            entityDemoMapper.delete(ids);
        } catch (Exception e) {
            throw new RuntimeException(CommonMsg.DELETE_FAIL, e);
        }
    }

//    /**
//     * 删除/批量删除
//     *
//     * @param ids id集合
//     */
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public void delete(List<Integer> ids) {
//        try {
//            entityDemoMapper.delete(ids);
//        } catch (Exception e) {
//            throw new RuntimeException(CommonMsg.DELETE_FAIL, e);
//        }
//    }
}
