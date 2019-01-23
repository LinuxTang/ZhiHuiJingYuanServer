package pojo;

import org.apache.commons.beanutils.ConvertUtils;

import java.lang.reflect.Field;
import java.util.Map;

public class Forder {

    private String foid;
    private String foname;
    private String fodescribe;
    private String foimg;

    public Forder() {
    }

    public String getFoid() {
        return foid;
    }

    public void setFoid(String foid) {
        this.foid = foid;
    }

    public String getFoname() {
        return foname;
    }

    public void setFoname(String foname) {
        this.foname = foname;
    }

    public String getFodescribe() {
        return fodescribe;
    }

    public void setFodescribe(String fodescribe) {
        this.fodescribe = fodescribe;
    }

    public String getFoimg() {
        return foimg;
    }

    public void setFoimg(String foimg) {
        this.foimg = foimg;
    }

    @Override
    public String toString() {
        return "Forder{" +
                "foid='" + foid + '\'' +
                ", foname='" + foname + '\'' +
                ", fodescribe='" + fodescribe + '\'' +
                ", foimg='" + foimg + '\'' +
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
