package com.ling.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean<T> {
    private Long total;         // 总记录数
    private Integer page;       // 当前页码
    private Integer pageSize;   // 每页显示条数
    private Integer pageTotal;  // 总页数
    private List<T> rows;       // 当前页数据

    public PageBean(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public static <T> PageBean<T> of(Long total, List<T> rows) {
        return new PageBean<>(total, rows);
    }

    public static <T> PageBean<T> of(Long total, Integer page, Integer pageSize, Integer pageTotal,
                                     List<T> rows) {
        return new PageBean<>(total, page, pageSize, pageTotal, rows);
    }
}
