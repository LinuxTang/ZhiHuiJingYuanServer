package pojo;

public class Fclothes {

    private String fcid;
    private String fcsex;
    private String fcdescribe;
    private String fcimg;

    public Fclothes() {
    }

    public String getFcid() {
        return fcid;
    }

    public void setFcid(String fcid) {
        this.fcid = fcid;
    }

    public String getFcsex() {
        return fcsex;
    }

    public void setFcsex(String fcsex) {
        this.fcsex = fcsex;
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

    @Override
    public String toString() {
        return "Fclothes{" +
                "fcid='" + fcid + '\'' +
                ", fcsex='" + fcsex + '\'' +
                ", fcdescribe='" + fcdescribe + '\'' +
                ", fcimg='" + fcimg + '\'' +
                '}';
    }
}
