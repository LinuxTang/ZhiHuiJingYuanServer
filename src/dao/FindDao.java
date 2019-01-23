package dao;

import pojo.encapsulation.AllItemsShowList;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class FindDao extends AbstractDao {

    private static FindDao findDao;

    public static FindDao instance(){
        if(findDao == null){
            findDao = new FindDao();
        }
        return findDao;
    }

    public List<AllItemsShowList> selectFindItems(){
        //有时候还是规范写，将字段都用``框起来，可能是和mysql里面的某个字段冲突了
        String sql = "select `fpid`,`fgid`,`gtname`,`replace`,`retime`,`restatus`,`name`,`photo_url` from `reback`,`user` where `sno` = `fpid`";
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
}
