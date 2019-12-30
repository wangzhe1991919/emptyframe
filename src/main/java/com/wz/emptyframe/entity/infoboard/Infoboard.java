package com.wz.emptyframe.entity.infoboard;

import com.wz.emptyframe.entity.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangzhe
 * @since 2019-12-30
 */
@ApiModel(value="Infoboard对象", description="")
public class Infoboard extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String seri;

    private String boardName;

    private String etcHex;

    private String stationConverge;

    private String stationCode;

    private String kmm;

    private String lng;

    private String lat;

    private String etcType;

    private String uniteCode;

    private String uniteName;

    private String dir;

    private String chargeDept;

    private String roadCode;

    private String roadName;

    public String getSeri() {
        return seri;
    }

    public void setSeri(String seri) {
        this.seri = seri;
    }
    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }
    public String getEtcHex() {
        return etcHex;
    }

    public void setEtcHex(String etcHex) {
        this.etcHex = etcHex;
    }
    public String getStationConverge() {
        return stationConverge;
    }

    public void setStationConverge(String stationConverge) {
        this.stationConverge = stationConverge;
    }
    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }
    public String getKmm() {
        return kmm;
    }

    public void setKmm(String kmm) {
        this.kmm = kmm;
    }
    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
    public String getEtcType() {
        return etcType;
    }

    public void setEtcType(String etcType) {
        this.etcType = etcType;
    }
    public String getUniteCode() {
        return uniteCode;
    }

    public void setUniteCode(String uniteCode) {
        this.uniteCode = uniteCode;
    }
    public String getUniteName() {
        return uniteName;
    }

    public void setUniteName(String uniteName) {
        this.uniteName = uniteName;
    }
    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }
    public String getChargeDept() {
        return chargeDept;
    }

    public void setChargeDept(String chargeDept) {
        this.chargeDept = chargeDept;
    }
    public String getRoadCode() {
        return roadCode;
    }

    public void setRoadCode(String roadCode) {
        this.roadCode = roadCode;
    }
    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    @Override
    public String toString() {
        return "Infoboard{" +
            "seri=" + seri +
            ", boardName=" + boardName +
            ", etcHex=" + etcHex +
            ", stationConverge=" + stationConverge +
            ", stationCode=" + stationCode +
            ", kmm=" + kmm +
            ", lng=" + lng +
            ", lat=" + lat +
            ", etcType=" + etcType +
            ", uniteCode=" + uniteCode +
            ", uniteName=" + uniteName +
            ", dir=" + dir +
            ", chargeDept=" + chargeDept +
            ", roadCode=" + roadCode +
            ", roadName=" + roadName +
        "}";
    }
}
