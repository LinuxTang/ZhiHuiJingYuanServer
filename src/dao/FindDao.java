package dao;

import pojo.encapsulation.AllItemsShowList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
        String sql = "select `fpid` as pid,`fgid` as gid,`gtname`,`replace` as place,`retime` as date,`restatus` as status,`name`,`photo_url` from `reback`,`user` where `sno` = `fpid`";
        Vector<Map<String,String>> items = null;
        items = super.select(sql,null);
        List<AllItemsShowList> allItemsShowLists = null;
        if(items != null){
            allItemsShowLists = new ArrayList<AllItemsShowList>();
            for(int i = 0; i < items.size(); i++){
                String table = null;
                AllItemsShowList allItemsShowList = new AllItemsShowList();
                table = items.get(i).get("gtname"); // 获取表名
                allItemsShowList.setParameters(items.get(i));
                //查找具体的表
                String prefix = table.substring(0,2); //得到0，1合在一起的字符串
                sql = "select "+prefix+"describe as content, "+prefix+"img as img_url from "+table+" where "+prefix+"id = ?";
                Object[] values = new Object[]{allItemsShowList.getGid()};
                Map<String,String> item = super.find(sql,values);
                allItemsShowList.setParameters(item);
                System.out.println(allItemsShowList);
                allItemsShowLists.add(allItemsShowList);
            }
        }
        return allItemsShowLists;
    }
}
