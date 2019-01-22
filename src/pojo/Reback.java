package pojo;

import java.util.Date;

public class Reback {

    private String reid;
    private Integer restatus;
    private String replace;
    private String retime;
    private String fgid;
    private String gtname;
    private String fpid;

    public Reback() {
    }

    public String getReid() {
        return reid;
    }

    public void setReid(String reid) {
        this.reid = reid;
    }

    public Integer getRestatus() {
        return restatus;
    }

    public void setRestatus(Integer restatus) {
        this.restatus = restatus;
    }

    public String getReplace() {
        return replace;
    }

    public void setReplace(String replace) {
        this.replace = replace;
    }

    public String getRetime() {
        return retime;
    }

    public void setRetime(String retime) {
        this.retime = retime;
    }

    public String getFgid() {
        return fgid;
    }

    public void setFgid(String fgid) {
        this.fgid = fgid;
    }

    public String getGtname() {
        return gtname;
    }

    public void setGtname(String gtname) {
        this.gtname = gtname;
    }

    public String getFpid() {
        return fpid;
    }

    public void setFpid(String fpid) {
        this.fpid = fpid;
    }

    @Override
    public String toString() {
        return "Reback{" +
                "reid='" + reid + '\'' +
                ", restatus=" + restatus +
                ", replace='" + replace + '\'' +
                ", retime='" + retime + '\'' +
                ", fgid='" + fgid + '\'' +
                ", gtname='" + gtname + '\'' +
                ", fpid='" + fpid + '\'' +
                '}';
    }
}
