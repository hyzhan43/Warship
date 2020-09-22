package com.hy.zhan.springbootwarship.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * author：  HyZhan
 * create：  2018/11/12 15:10
 * desc：    TODO
 */
@Data
public class PageRsp<T> {

    @ApiModelProperty("当前页")
    private int curPage;

    @ApiModelProperty("页数")
    private int totalPages;

    @ApiModelProperty("当前页 数量")
    private int size = 10;

    @ApiModelProperty("总数")
    private long total;

    @ApiModelProperty("数据")
    private List<T> list;
}
