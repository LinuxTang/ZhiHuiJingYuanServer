package dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import pojo.Fclothes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class FclothesDao extends AbstractDao{

    private static FclothesDao fclothesDao;
    private static Log logger = LogFactory.getLog(FclothesDao.class);

    public static FclothesDao instance(){
        if(fclothesDao == null){
            fclothesDao = new FclothesDao();
        }
        return fclothesDao;
    }

    //常规插入数据操作
    public Integer insertBasicFclothes(Fclothes fclothes){
        int num = 3;
        Integer success = null;
        String sql = "insert into `fclothes` (fcid";
        List<Object> values = new ArrayList<Object>();
        Object[] value = null;
        //必填字段
        if(fclothes.getFcid() == null){
            logger.fatal("Fclothes表必填字段Id为空！");
            return null;
        }
        values.add(fclothes.getFcid());
        if(fclothes.getFcsex() != null){
            sql = sql + ",fcsex";
        }
        if(fclothes.getFcdescribe() != null) {
            sql = sql + ",fcdescribe";
            values.add(fclothes.getFcdescribe());
            num++;
        }
        if(fclothes.getFcimg() != null){
            sql = sql + ",fcimg";
            values.add(fclothes.getFcimg());
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
    public Integer deleteBasicFclothes(String id){
        String sql = "delete from `fclothes` where fcid = ?";
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
    public Integer updateBasicFclothes(Map<String,Object> field, String sql){
        Integer success = null;
        String Nsql = "update `fclothes` set ";
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
            success = super.update(Nsql,value);
        }
        return success;
    }

    //查找
    //sql格式 xx=xx and|or xx=xx...
    public List<Fclothes> selectBasicFclothes(String sql){
        String runSql = "select * from `fclothes`";
        if(sql != null){
            runSql = runSql + "where " + sql;
        }
        List<Fclothes> fclothesList = null;
        Vector<Vector<Object>> lists = null;
        if((lists = super.select(runSql,null)) != null){
            for(int i = 0; i < lists.size(); i++){
                Fclothes fclothes = new Fclothes();
                Vector<Object> list = lists.get(i);
                fclothes.setFcid(list.get(0).toString());
                fclothes.setFccolor(list.get(1).toString());
                fclothes.setFcsex(list.get(2).toString());
                fclothes.setFcdescribe(list.get(3).toString());
                fclothes.setFcimg(list.get(4).toString());
                fclothesList.add(fclothes);
            }
        }
        return fclothesList;
    }

}
