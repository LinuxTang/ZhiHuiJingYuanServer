package dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import pojo.Forder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class ForderDao extends AbstractDao {

    private static ForderDao forderDao;
    private static Log logger = LogFactory.getLog(ForderDao.class);

    public static ForderDao instance(){
        if(forderDao == null){
            forderDao = new ForderDao();
        }
        return forderDao;
    }

    //常规插入数据操作
    public Integer insertBasicForder(Forder forder){
        int num = 3;
        Integer success = null;
        String sql = "insert into `forder` (foid";
        List<Object> values = new ArrayList<Object>();
        Object[] value = null;
        //必填字段
        if(forder.getFoid() == null){
            logger.fatal("Forder表必填字段Id为空！");
            return null;
        }
        values.add(forder.getFoid());
        if(forder.getFodescribe() != null) {
            sql = sql + ",fodescribe";
            values.add(forder.getFodescribe());
            num++;
        }
        if(forder.getFoimg() != null){
            sql = sql + ",foimg";
            values.add(forder.getFoimg());
            num++;
        }

        value = values.toArray();
        sql = sql + ") values (";
        for(int i = 0; i < num; i++){
            sql = sql + "?";
            if(i != num - 1){
                sql = sql + ",";
            }
        }
        sql = sql + ")";
        success = super.update(sql,value);
        if(success == 0) success = null;
        return success;
    }

    //删除操作
    public Integer deleteBasicForder(String id){
        String sql = "delete from `foid` where foid = ?";
        Object[] value = new Object[]{id};
        Integer success = null;
        success = super.update(sql,value);
        if(success == 0) success = null;
        return success;
    }

    //更新操作

    /**
     * sql的格式为 where后面的语句
     * @param field
     * @param sql xx=? and | or xx=?
     * @return
     */
    public Integer updateBasicForder(Map<String,Object> field, String sql){
        Integer success = null;
        String Nsql = "update `forder` set ";
        List<Object> values = null;
        Object[] value = null;
        if(field != null && field.size() > 0){
            values = new ArrayList<Object>();
            int i = 0;
            for(String key : field.keySet()){
                if(i != 0) Nsql +=",";
                Nsql = Nsql + key + " = ?";
                values.add(field.get(key));
            }
            Nsql = Nsql + " where " + sql;
        }
        if(values != null){
            value = values.toArray();
            success = super.update(sql,value);
        }
        return success;
    }

    //查找
    //sql格式 xx=xx and|or xx=xx...
    public List<Forder> selectBasicForder(String sql){
        String runSql = "select * from `forder`";
        if(sql != null){
            runSql = runSql + "where " + sql;
        }
        List<Forder> forderList = null;
        Vector<Vector<Object>> lists = null;
        if((lists = super.select(runSql,null)) != null){
            for(int i = 0; i < lists.size(); i++){
                Forder forder = new Forder();
                Vector<Object> list = lists.get(i);
                forder.setFoid(list.get(0).toString());
                forder.setFoname(list.get(1).toString());
                forder.setFodescribe(list.get(2).toString());
                forder.setFoimg(list.get(3).toString());
                forderList.add(forder);
            }
        }
        return forderList;
    }
}
