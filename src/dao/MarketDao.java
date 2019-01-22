package dao;

import Utils.JDBCUtil;
import pojo.Market;
import pojo.encapsulation.AllMarketShowList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class MarketDao extends AbstractDao{
    public int marketInsert(Market market){
//        Connection conn = JDBCUtil.getConn();
//        PreparedStatement preStmt = null;
        String sql = "insert into market(mkid,mkpid,mkgid,mktime,mkprice,mkname,mktitle,mkimg) " +
                "values(?,?,?,?,?,?,?,?)";
        Object[] data = new Object[]{market.getMkId(),market.getMkPid(),market.getMkGid(),market.getMkTime(),market.getMkPrice(),market.getMkName(),market.getMkTitle(),market.getMkImg()};
        return super.update(sql,data);
        //        try{
//            preStmt = conn.prepareStatement(sql);
//            preStmt.setString(1,market.getMkId());
//            preStmt.setString(2,market.getMkPid());
//            preStmt.setString(3,market.getMkGid());
//            preStmt.setString(4,market.getMkTime());
//            preStmt.setDouble(5,market.getMkPrice());
//            preStmt.setString(6,market.getMkName());
//            preStmt.setString(7,market.getMkTitle());
//            preStmt.executeUpdate();
//        }catch (SQLException e){
//            e.printStackTrace();
//        }finally {
//            JDBCUtil.closeConn(null,preStmt,conn);
//        }
    }

    public List<AllMarketShowList> selectAllMarkets(){
        List<AllMarketShowList> marketShowList = new ArrayList<AllMarketShowList>();
        AllMarketShowList marketItem = null;
        String sql = "select mkid,mktitle,mkprice,mkimg from market";
        Vector<Vector<Object>> dataTable = super.select(sql,null);
        Vector<Object> dataLine;
        for(int i = 0; i < dataTable.size(); i++){
            dataLine = dataTable.get(i);
            marketItem = new AllMarketShowList();
            marketItem.setMkid(dataLine.get(0).toString());
            marketItem.setMkTitle(dataLine.get(1).toString());
            marketItem.setMkPrice(dataLine.get(2).toString());
            marketItem.setMkImg(dataLine.get(3).toString());
            marketShowList.add(marketItem);
        }
        return marketShowList;
    }
}
