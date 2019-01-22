package pojo;

public class Fudisk {

    private String fuid;
    private String funame;
    private String fusize;
    private String fudescribe;
    private String fuimg;

    public Fudisk() {
    }

    public String getFuid() {
        return fuid;
    }

    public void setFuid(String fuid) {
        this.fuid = fuid;
    }

    public String getFuname() {
        return funame;
    }

    public void setFuname(String funame) {
        this.funame = funame;
    }

    public String getFusize() {
        return fusize;
    }

    public void setFusize(String fusize) {
        this.fusize = fusize;
    }

    public String getFudescribe() {
        return fudescribe;
    }

    public void setFudescribe(String fudescribe) {
        this.fudescribe = fudescribe;
    }

    public String getFuimg() {
        return fuimg;
    }

    public void setFuimg(String fuimg) {
        this.fuimg = fuimg;
    }

    @Override
    public String toString() {
        return "Fudisk{" +
                "fuid='" + fuid + '\'' +
                ", funame='" + funame + '\'' +
                ", fusize='" + fusize + '\'' +
                ", fudescribe='" + fudescribe + '\'' +
                ", fuimg='" + fuimg + '\'' +
                '}';
    }
}
