package pojo;

import org.apache.commons.beanutils.ConvertUtils;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Map;

public class Lose {

    private String lgid;
    private String lgtime;
    private String lgname;
    private String lgplace;
    private String lgpid;
    private String lgstatus;
    private String lggid;

    public Lose() {
    }

    public String getLgid() {
        return lgid;
    }

    public void setLgid(String lgid) {
        this.lgid = lgid;
    }

    public String getLgtime() {
        return lgtime;
    }

    public void setLgtime(String lgtime) {
        this.lgtime = lgtime;
    }

    public String getLgname() {
        return lgname;
    }

    public void setLgname(String lgname) {
        this.lgname = lgname;
    }

    public String getLgplace() {
        return lgplace;
    }

    public void setLgplace(String lgplace) {
        this.lgplace = lgplace;
    }

    public String getLgpid() {
        return lgpid;
    }

    public void setLgpid(String lgpid) {
        this.lgpid = lgpid;
    }

    public String getLgstatus() {
        return lgstatus;
    }

    public void setLgstatus(String lgstatus) {
        this.lgstatus = lgstatus;
    }

    public String getLggid() {
        return lggid;
    }

    public void setLggid(String lggid) {
        this.lggid = lggid;
    }

    @Override
    public String toString() {
        return "Lose{" +
                "lgid='" + lgid + '\'' +
                ", lgtime='" + lgtime + '\'' +
                ", lgname='" + lgname + '\'' +
                ", lgplace='" + lgplace + '\'' +
                ", lgpid='" + lgpid + '\'' +
                ", lgstatus='" + lgstatus + '\'' +
                ", lggid='" + lggid + '\'' +
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
