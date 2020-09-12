package com.itstyle.seckill.tuomin;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: qiyu
 * @Date: 2020/9/12 10:37 下午
 * @Description:
 */
@Data
@NoArgsConstructor
public class Page<T> implements Serializable {

    private int currentPageNum;//当前页
    private int pageSize=5;//每页显示的条数
    private int totalRecords;//总记录条数
    private int startIndex;//查询的开始记录索引
    private int totalPageNum;//总页数
    private int prePageNum;//上一页
    private int nextPageNum;//下一页
    private List<T> records;//分好页的结果集（最多只能有5个对象）

    //用于显示页码的属性。我们的需求是页面上最多只显示9个页码。当前页在允许的情况下永远居中
    private int beginPageNum;
    private int endPageNum;

    public Page(int currentPageNum, int pageSize, List<T> records) {
        this.currentPageNum = currentPageNum;
        this.pageSize = pageSize;
        this.records = records;
    }
}
