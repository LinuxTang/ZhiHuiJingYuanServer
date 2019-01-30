package dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import pojo.Lose;
import pojo.encapsulation.AllItemsShowList;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class LoseDao extends AbstractDao {

    private static LoseDao loseDao;
    private static Log logger = LogFactory.getLog(LoseDao.class);

    public static LoseDao instance(){
        if(loseDao == null){
            loseDao = new LoseDao();
        }
        return loseDao;
    }

    //查找所有丢失物品表信息
    public List<AllItemsShowList> findLoseItems() {
        String sql = "select lgpid as pid,lggid as gid,lgname,lgplace as place,lgtime as date,lgstatus as status,name,photo_url from lose,user where sno = lgpid";
        Vector<Map<String,String>> items = null;
        items = super.select(sql,null);
        List<AllItemsShowList> allItemsShowLists = null;
        if(items != null){
            allItemsShowLists = new ArrayList<AllItemsShowList>();
            for(int i = 0; i < items.size(); i++){
                    String table = null;
                    AllItemsShowList allItemsShowList = new AllItemsShowList();
                    table = items.get(i).get("lgname"); // 获取表名
                    //设置pid，gid，name，place，date，status,photo_url
                    allItemsShowList.setParameters(items.get(i));
                    //查找具体的表
                    String prefix = table.substring(0,2); //得到0，1合在一起的字符串
                    sql = "select "+prefix+"describe as content, "+prefix+"img as img_url from "+table+" where "+prefix+"id = ?";
                    Object[] values = new Object[]{allItemsShowList.getGid()};
                    Map<String,String> item = super.find(sql,values);
                    allItemsShowList.setParameters(item); //设置content和img_url
                    allItemsShowLists.add(allItemsShowList);
                }
            }
        return allItemsShowLists;
    }

    //添加丢失物品信息
    public Integer addLostItemMessage(Lose lose){
        Integer success = null;
        int num = 1;
        String sql = "insert into `lose` (lgid";
        List<Object> values = new ArrayList<Object>();
        Object[] value = null;
        //必填字段
        if(lose.getLgid() == null){
            logger.fatal("Fwallet表必填字段Id为空！");
            return null;
        }
        values.add(lose.getLgid());
        if(lose.getLgpid() != null){
            sql = sql + ",lgpid";
            values.add(lose.getLgpid());
            num++;
        }
        if(lose.getLggid() != null) {
            sql = sql + ",lggid";
            values.add(lose.getLggid());
            num++;
        }
        if(lose.getLgname() != null){
            sql = sql + ",lgname";
            values.add(lose.getLgname());
            num++;
        }
        if(lose.getLgplace() != null){
            sql = sql +",lgplace";
            values.add(lose.getLgplace());
            num++;
        }
        if(lose.getLgtime() != null){
            sql = sql +",lgtime";
            values.add(lose.getLgtime());
            num++;
        }
        if(lose.getLgstatus() != null){
            sql = sql +",lgstatus";
            values.add(lose.getLgstatus());
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
}
