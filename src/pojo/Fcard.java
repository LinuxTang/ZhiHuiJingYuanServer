package pojo;

import org.apache.commons.beanutils.ConvertUtils;

import java.lang.reflect.Field;
import java.util.Map;

public class Fcard {

    private String fcid;
    private String fcsno;
    private String fcname;
    private String fcacademic;
    private String fcdescribe;
    private String fcimg;

    public Fcard() {
    }

    public String getFcid() {
        return fcid;
    }

    public void setFcid(String fcid) {
        this.fcid = fcid;
    }

    public String getFcsno() {
        return fcsno;
    }

    public void setFcsno(String fcsno) {
        this.fcsno = fcsno;
    }

    public String getFcname() {
        return fcname;
    }

    public void setFcname(String fcname) {
        this.fcname = fcname;
    }

    public String getFcacademic() {
        return fcacademic;
    }

    public void setFcacademic(String fcacademic) {
        this.fcacademic = fcacademic;
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
        return "Fcard{" +
                "fcid='" + fcid + '\'' +
                ", fcsno='" + fcsno + '\'' +
                ", fcname='" + fcname + '\'' +
                ", fcacademic='" + fcacademic + '\'' +
                ", fcdescribe='" + fcdescribe + '\'' +
                ", fcimg='" + fcimg + '\'' +
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
