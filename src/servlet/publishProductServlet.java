package servlet;

import Utils.UploadFileImg;
import dao.CosmeticsDao;
import dao.MarketDao;
import dao.UDiskDao;
import net.sf.json.JSONObject;
import pojo.Fcosmetics;
import pojo.Fudisk;
import pojo.Market;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class publishProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        //生成上传图片的文件名
        String fileName = UUID.randomUUID().toString().replace("-","");
        //指定上传文件的相对路径
        String filePath = "market/";
        UploadFileImg uploadImg = new UploadFileImg();
        //上传图片到指定文件夹并获取表单数据和图片名
        Map<String,String> map = uploadImg.UploadImg(request,filePath,fileName);
        String jsonstr = map.get("productInfo");
        String saveFileName = map.get("saveFileName");
        JSONObject json = JSONObject.fromObject(jsonstr);

        //将发布物品事件信息保存在数据库中
        Market market = new Market();
        String mkid = UUID.randomUUID().toString().replace("-","");
        String gid = UUID.randomUUID().toString().replace("-","");
        market.setMkId(mkid);
        market.setMkGid(gid);
        market.setMkPid(json.getString("uid"));
        market.setMkTitle(json.getString("pTitle"));
        market.setMkPrice(Double.valueOf(json.getString("pPrice")));
        market.setMkTime(new Date().toString());
        market.setMkName(json.getString("pType"));
        market.setMkImg(filePath + saveFileName);
        MarketDao marketDao = new MarketDao();
        marketDao.marketInsert(market);

        //根据物品种类将物品存放在物品表中
        String productType = json.getString("pType");
        //
        switch (productType){
            case "0":
                Fcosmetics fcosmetics = new Fcosmetics();
                fcosmetics.setFcid(gid);
                fcosmetics.setFcname(json.getString("cosName"));
                fcosmetics.setFctype(json.getString("cosType"));
                fcosmetics.setFcdescribe(json.getString("desc"));
                fcosmetics.setFcimg(filePath + saveFileName);
                CosmeticsDao cosmeticsDao = new CosmeticsDao();
                cosmeticsDao.insertCosmetics(fcosmetics);
                break;
            case "1":
                Fudisk fudisk = new Fudisk();
                fudisk.setFuid(gid);
                fudisk.setFuname(json.getString("uName"));
                fudisk.setFusize(json.getString("uSize"));
                fudisk.setFudescribe(json.getString("desc"));
                fudisk.setFuimg(filePath + saveFileName);
                UDiskDao uDiskDao = new UDiskDao();
                uDiskDao.insertUDisk(fudisk);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
