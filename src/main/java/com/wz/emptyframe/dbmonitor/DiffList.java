package com.wz.emptyframe.dbmonitor;

import java.util.List;

/**
 * 去重后元素不同的两个List
 * @author ta0546 wz
 * @time 2019/3/2
 */
public class DiffList<E> {

    private List<E> basicList;

    private List<E> followList;

    public void setList(List<E> basic,List<E> follow) {
        setBasicList(basic);
        setFollowList(follow);
    }

    public List<E> getBasicList() {
        return basicList;
    }

    public void setBasicList(List<E> basicList) {
        this.basicList = basicList;
    }

    public List<E> getFollowList() {
        return followList;
    }

    public void setFollowList(List<E> followList) {
        this.followList = followList;
    }
}
