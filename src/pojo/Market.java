package pojo;

import org.apache.commons.beanutils.ConvertUtils;

import java.lang.reflect.Field;
import java.sql.Date;
import java.util.Map;

public class Market {
    private String mkid;
    private String mkpid;
    private String mkgid;
    private String mktime;
    private Double mkprice;
    private String mkname;
    private String mktitle;
    private String mkimg;

    public Market() {
    }

    public String getMkid() {
        return mkid;
    }

    public void setMkid(String mkid) {
        this.mkid = mkid;
    }

    public String getMkpid() {
        return mkpid;
    }

    public void setMkpid(String mkpid) {
        this.mkpid = mkpid;
    }

    public String getMkgid() {
        return mkgid;
    }

    public void setMkgid(String mkgid) {
        this.mkgid = mkgid;
    }

    public String getMktime() {
        return mktime;
    }

    public void setMktime(String mktime) {
        this.mktime = mktime;
    }

    public Double getMkprice() {
        return mkprice;
    }

    public void setMkprice(Double mkprice) {
        this.mkprice = mkprice;
    }

    public String getMkname() {
        return mkname;
    }

    public void setMkname(String mkname) {
        this.mkname = mkname;
    }

    public String getMktitle() {
        return mktitle;
    }

    public void setMktitle(String mktitle) {
        this.mktitle = mktitle;
    }

    public String getMkimg() {
        return mkimg;
    }

    public void setMkimg(String mkimg) {
        this.mkimg = mkimg;
    }

    @Override
    public String toString() {
        return "Market{" +
                "mkid='" + mkid + '\'' +
                ", mkpid='" + mkpid + '\'' +
                ", mkgid='" + mkgid + '\'' +
                ", mktime='" + mktime + '\'' +
                ", mkprice=" + mkprice +
                ", mkname='" + mkname + '\'' +
                ", mktitle='" + mktitle + '\'' +
                ", mkimg='" + mkimg + '\'' +
                '}';
    }

    public void setParameters(Map<String,String> map){
        Class clazz = this.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields){
            String fieldName = field.getName();
            if(map.containsKey(fieldName)){
                try {
                    field.set(this, ConvertUtils.convert(map.get(fieldName), field.getType()));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
