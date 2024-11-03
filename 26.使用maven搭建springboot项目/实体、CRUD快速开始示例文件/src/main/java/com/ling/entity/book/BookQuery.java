package com.ling.entity.book;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class BookQuery extends Book {
    private Integer page = 1;
    private Integer pageSize = 10;
    private Date startDate;
    private Date endDate;
}
