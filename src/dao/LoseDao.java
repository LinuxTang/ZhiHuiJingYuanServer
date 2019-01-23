package dao;

import pojo.encapsulation.AllItemsShowList;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class LoseDao extends AbstractDao {

    private static LoseDao loseDao;

    public static LoseDao instance(){
        if(loseDao == null){
            loseDao = new LoseDao();
        }
        return loseDao;
    }

    //查找所有丢失物品表信息
    public List<AllItemsShowList> findLoseItems() {
        String sql = "select lgpid,lggid,lgname,lgplace,lgtime,lgstatus,name,photo_url from lose,user where sno = lgpid";
        Vector<Vector<Object>> items = null;
        items = super.select(sql,null);
        List<AllItemsShowList> allItemsShowLists = null;
        if(items != null){
            allItemsShowLists = new ArrayList<AllItemsShowList>();
            for(int i = 0; i < items.size(); i++){
                    String table = null;
                    AllItemsShowList allItemsShowList = new AllItemsShowList();
                    allItemsShowList.setPid(items.get(i).get(0).toString());  //人id
                    allItemsShowList.setGid(items.get(i).get(1).toString()); //物品id
                    table = items.get(i).get(2).toString(); // 获取表名
                    allItemsShowList.setPlace(items.get(i).get(3).toString()); //地点
                    allItemsShowList.setDate(items.get(i).get(4).toString()); //日期
                    allItemsShowList.setStatus(Integer.parseInt(items.get(i).get(5).toString())); //状态
                    allItemsShowList.setName(items.get(i).get(6).toString()); //人名
                    allItemsShowList.setPhoto_url(items.get(i).get(7).toString()); //头像照片

                    //查找具体的表
                    String prefix = table.substring(0,2); //得到0，1合在一起的字符串
                    System.out.println(prefix);
                    sql = "select "+prefix+"describe, "+prefix+"img from "+table+" where "+prefix+"id = ?";
                    Object[] values = new Object[]{allItemsShowList.getGid()};
                    Object[] item = super.find(sql,values);
                    if(item != null){
                        allItemsShowList.setContent(String.valueOf(item[0]));
                        allItemsShowList.setImg_url(String.valueOf(item[1]));
                    }
                    allItemsShowLists.add(allItemsShowList);
                }
            }
        return allItemsShowLists;
    }

    //添加丢失物品信息
    public Integer addLostItemMessage(){
        return null;
    }
}
