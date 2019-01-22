package dao;

import pojo.Fudisk;

public class UDiskDao extends AbstractDao {
    public int insertUDisk(Fudisk fudisk){
        String sql = "insert into fudisk(fuid,funame,fusize,fudescribe,fuimg) " +
                "values(?,?,?,?,?)";
        Object[] data = new Object[]{fudisk.getFuid(),fudisk.getFuname(),fudisk.getFusize(),fudisk.getFudescribe(),fudisk.getFuimg()};
        return super.update(sql,data);
    }
}
