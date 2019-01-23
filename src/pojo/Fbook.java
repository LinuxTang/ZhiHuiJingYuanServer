package pojo;

import org.apache.commons.beanutils.ConvertUtils;

import java.lang.reflect.Field;
import java.util.Map;

public class Fbook {

    private String fbid;
    private String fbname;
    private String fbdescribe;
    private String fbimg;
    private String fbauthor;

    public Fbook() {
    }

    public String getFbid() {
        return fbid;
    }

    public void setFbid(String fbid) {
        this.fbid = fbid;
    }

    public String getFbname() {
        return fbname;
    }

    public void setFbname(String fbname) {
        this.fbname = fbname;
    }

    public String getFbdescribe() {
        return fbdescribe;
    }

    public void setFbdescribe(String fbdescribe) {
        this.fbdescribe = fbdescribe;
    }

    public String getFbimg() {
        return fbimg;
    }

    public void setFbimg(String fbimg) {
        this.fbimg = fbimg;
    }

    public String getFbauthor() {
        return fbauthor;
    }

    public void setFbauthor(String fbauthor) {
        this.fbauthor = fbauthor;
    }

    @Override
    public String toString() {
        return "Fbook{" +
                "fbid='" + fbid + '\'' +
                ", fbname='" + fbname + '\'' +
                ", fbdescribe='" + fbdescribe + '\'' +
                ", fbimg='" + fbimg + '\'' +
                ", fbauthor='" + fbauthor + '\'' +
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
