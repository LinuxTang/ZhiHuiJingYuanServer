package pojo;

import java.sql.Date;

public class Market {
    private String mkId;
    private String mkPid;
    private String mkGid;
    private String mkTime;
    private Double mkPrice;
    private String mkName;
    private String mkTitle;
    private String mkImg;

    public Market() {
    }

    public String getMkId() {
        return mkId;
    }

    public void setMkId(String mkId) {
        this.mkId = mkId;
    }

    public String getMkPid() {
        return mkPid;
    }

    public void setMkPid(String mkPid) {
        this.mkPid = mkPid;
    }

    public String getMkGid() {
        return mkGid;
    }

    public void setMkGid(String mkGid) {
        this.mkGid = mkGid;
    }

    public String getMkTime() {
        return mkTime;
    }

    public void setMkTime(String mkTime) {
        this.mkTime = mkTime;
    }

    public Double getMkPrice() {
        return mkPrice;
    }

    public void setMkPrice(Double mkPrice) {
        this.mkPrice = mkPrice;
    }

    public String getMkName() {
        return mkName;
    }

    public void setMkName(String mkName) {
        this.mkName = mkName;
    }

    public String getMkTitle() {
        return mkTitle;
    }

    public void setMkTitle(String mkTitle) {
        this.mkTitle = mkTitle;
    }

    public String getMkImg() {
        return mkImg;
    }

    public void setMkImg(String mkImg) {
        this.mkImg = mkImg;
    }

    @Override
    public String toString() {
        return "Market{" +
                "mkId='" + mkId + '\'' +
                ", mkPid='" + mkPid + '\'' +
                ", mkGid='" + mkGid + '\'' +
                ", mkTime='" + mkTime + '\'' +
                ", mkPrice=" + mkPrice +
                ", mkName='" + mkName + '\'' +
                ", mkTitle='" + mkTitle + '\'' +
                ", mkImg='" + mkImg + '\'' +
                '}';
    }
}
