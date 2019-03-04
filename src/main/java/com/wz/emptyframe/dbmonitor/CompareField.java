package com.wz.emptyframe.dbmonitor;

/**
 * @author ta0546 wz
 * @time 2019/2/27
 */
public class CompareField extends BaseCompare{

    private String basicType;

    private String followType;

    private String basicLength;

    private String followLength;

    private String basicDesc;

    private String followDesc;

    public String getBasicType() {
        return basicType;
    }

    public void setBasicType(String basicType) {
        this.basicType = basicType;
    }

    public String getFollowType() {
        return followType;
    }

    public void setFollowType(String followType) {
        this.followType = followType;
    }

    public String getBasicLength() {
        return basicLength;
    }

    public void setBasicLength(String basicLength) {
        this.basicLength = basicLength;
    }

    public String getFollowLength() {
        return followLength;
    }

    public void setFollowLength(String followLength) {
        this.followLength = followLength;
    }

    public String getBasicDesc() {
        return basicDesc;
    }

    public void setBasicDesc(String basicDesc) {
        this.basicDesc = basicDesc;
    }

    public String getFollowDesc() {
        return followDesc;
    }

    public void setFollowDesc(String followDesc) {
        this.followDesc = followDesc;
    }
}
