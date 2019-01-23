package pojo;

import org.apache.commons.beanutils.ConvertUtils;

import java.lang.reflect.Field;
import java.util.Map;

public class Fclothes {

    private String fcid;
    private String fcsex;
    private String fcdescribe;
    private String fcimg;
    private String fccolor;

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

    public String getFccolor() {
        return fccolor;
    }

    public void setFccolor(String fccolor) {
        this.fccolor = fccolor;
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
