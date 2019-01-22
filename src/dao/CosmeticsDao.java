package dao;

import pojo.Fcosmetics;

public class CosmeticsDao extends AbstractDao {
    public int insertCosmetics(Fcosmetics fcosmetics){
        String sql = "insert into fcosmetics(fcid,fcname,fctype,fcdescribe,fcimg) " +
                "values(?,?,?,?,?)";
        Object[] data = new Object[]{fcosmetics.getFcid(),fcosmetics.getFcname(),fcosmetics.getFctype(),fcosmetics.getFcdescribe(),fcosmetics.getFcimg()};
        return super.update(sql,data);
    }
}
