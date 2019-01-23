package pojo;

import org.apache.commons.beanutils.ConvertUtils;

import java.lang.reflect.Field;
import java.util.Map;

public class Fwallet {

    private String fwid;
    private String fwcolor;
    private String fwdescribe;
    private String fwimg;

    public Fwallet() {
    }

    public String getFwid() {
        return fwid;
    }

    public void setFwid(String fwid) {
        this.fwid = fwid;
    }

    public String getFwcolor() {
        return fwcolor;
    }

    public void setFwcolor(String fwcolor) {
        this.fwcolor = fwcolor;
    }

    public String getFwdescribe() {
        return fwdescribe;
    }

    public void setFwdescribe(String fwdescribe) {
        this.fwdescribe = fwdescribe;
    }

    public String getFwimg() {
        return fwimg;
    }

    public void setFwimg(String fwimg) {
        this.fwimg = fwimg;
    }

    @Override
    public String toString() {
        return "Fwallet{" +
                "fwid='" + fwid + '\'' +
                ", fwcolor='" + fwcolor + '\'' +
                ", fwdescribe='" + fwdescribe + '\'' +
                ", fwimg='" + fwimg + '\'' +
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
