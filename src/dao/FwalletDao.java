package dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import pojo.Fwallet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FwalletDao extends AbstractDao{

    private static FwalletDao fwalletDao;
    private static Log logger = LogFactory.getLog(FwalletDao.class);

    public static FwalletDao instance(){
        if(fwalletDao == null){
            fwalletDao = new FwalletDao();
        }
        return fwalletDao;
    }

    //常规插入数据操作
    public Integer insertBasicFwallet(Fwallet fwallet){
        int num = 1;
        Integer success = null;
        String sql = "insert into `fwallet` (fwid";
        List<Object> values = new ArrayList<Object>();
        Object[] value = null;
        //必填字段
        if(fwallet.getFwid() == null){
            logger.fatal("Fwallet表必填字段Id为空！");
            return null;
        }
        values.add(fwallet.getFwid());
        if(fwallet.getFwcolor() != null){
            sql = sql + ",fwcolor";
            values.add(fwallet.getFwcolor());
            num++;
        }
        if(fwallet.getFwdescribe() != null) {
            sql = sql + ",fwdescribe";
            values.add(fwallet.getFwdescribe());
            num++;
        }
        if(fwallet.getFwid() != null){
            sql = sql + ",fwimg";
            values.add(fwallet.getFwimg());
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

    public Map<String,String> getFwalletIdByFwallet(Fwallet fwallet){
        Map<String,String> id = null;
        String sql = "select `fwid` from `fwallet` where ";
        List<Object> values = new ArrayList<Object>();
        int num = 0;
        if(fwallet.getFwcolor() != null){
            sql = sql + "fwcolor like ?";
            num = 1;
            values.add(fwallet.getFwcolor());
        }
        if(fwallet.getFwdescribe() != null){
            if(num == 0)
            sql = sql + "fwdescribe like ?";
            else{
                sql = sql +",fwdescribe like ?";
            }
            values.add(fwallet.getFwdescribe());
        }
        if(fwallet.getFwimg() != null){
            if(num == 0){
                sql = sql + "fwimg like ?";
            }
            else{
                sql = sql + ",fwimg like ?";
            }
            values.add(fwallet.getFwimg());
        }
        id = super.find(sql,values.toArray());
        return id;
    }
}
