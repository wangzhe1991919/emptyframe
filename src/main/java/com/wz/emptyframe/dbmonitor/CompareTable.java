package com.wz.emptyframe.dbmonitor;

import java.util.List;

/**
 * @author ta0546 wz
 * @time 2019/2/27
 */
public class CompareTable extends BaseCompare{

    /**
     * 表中字段对比情况
     */
    private List<CompareField> compareFieldList;

    public List<CompareField> getCompareFieldList() {
        return compareFieldList;
    }

    public void setCompareFieldList(List<CompareField> compareFieldList) {
        this.compareFieldList = compareFieldList;
    }
}
