package com.imooc.page;

import lombok.Data;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.github.pagehelper.Page;

/**
 * 对分页数据进行包装
 *
 * @param <T> 返回集类型
 * @author wangguanghui
 */
@SuppressWarnings({"rawtypes", "unchecked"})
@Data
public class PageInfo<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private int pageNum;

    private int pageSize;

    /**
     * 总记录数
     */
    private long total;

    /**
     * 总页数
     */
    private int pages;

    /**
     * 结果集
     */
    private List<T> list;

    public PageInfo(List<T> list) {
        if (list instanceof Page) {
            Page page = (Page) list;
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();

            this.pages = page.getPages();
            this.list = page;
            this.total = page.getTotal();
        } else if (list instanceof Collection) {
            this.pageNum = 1;
            this.pageSize = list.size();

            this.pages = 1;
            this.list = list;
            this.total = list.size();
        }
    }
}
