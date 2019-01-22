package pojo;

public class Fcosmetics {
    private String fcid;
    private String fcname;
    private String fctype;
    private String fcdescribe;
    private String fcimg;

    public String getFcid() {
        return fcid;
    }

    public void setFcid(String fcid) {
        this.fcid = fcid;
    }

    public String getFcname() {
        return fcname;
    }

    public void setFcname(String fcname) {
        this.fcname = fcname;
    }

    public String getFctype() {
        return fctype;
    }

    public void setFctype(String fctype) {
        this.fctype = fctype;
    }

    public String getFcdescribe() {
        return fcdescribe;
    }

    public void setFcdescribe(String fcdescribe) {
        this.fcdescribe = fcdescribe;
    }

    public String getFcimg() {
        return fcimg;
    }

    public void setFcimg(String fcimg) {
        this.fcimg = fcimg;
    }

    public Fcosmetics() {
    }

    @Override
    public String toString() {
        return "Fcosmetics{" +
                "fuid='" + fcid + '\'' +
                ", fcname='" + fcname + '\'' +
                ", fctype='" + fctype + '\'' +
                ", fcdescribe='" + fcdescribe + '\'' +
                ", fcimg='" + fcimg + '\'' +
                '}';
    }
}
