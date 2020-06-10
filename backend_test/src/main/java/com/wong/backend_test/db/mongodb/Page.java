package com.wong.backend_test.db.mongodb;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Page<T> {
    private Long total;
    private Long totalPage;
    private Integer pageIndex;
    private Integer pageSize;
    private List<T> data;

}
