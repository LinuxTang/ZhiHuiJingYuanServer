package servlet;

import Utils.UploadFileImg;
import dao.CosmeticsDao;
import dao.MarketDao;
import dao.UDiskDao;
import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import pojo.Fcosmetics;
import pojo.Fudisk;
import pojo.Market;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.*;

public class publishProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        String filePath = null;
        UploadFileImg uploadFileImg = new UploadFileImg();
        filePath = uploadFileImg.UploadImg(request);
        if(filePath != null){
            System.out.println(filePath+ "<------------------------");
            response.setCharacterEncoding("utf-8");
            Writer out = response.getWriter();
            out.write(filePath);
            out.flush();
        }else{
            String fieldJsonStr = request.getParameter("productInfo");
            String photoPath = request.getParameter("filePath");
            JSONObject fieldJson = JSONObject.fromObject(fieldJsonStr);
            Map<String,String> fieldMap = (Map<String,String>)fieldJson;
            Market market = new Market();
            market.setParameters(fieldMap);
            String mkid = UUID.randomUUID().toString().replace("-","");
            String mkgid = UUID.randomUUID().toString().replace("-","");
            market.setMkid(mkid);
            market.setMkgid(mkgid);
            market.setMktime(new Date().toString());
            market.setMkimg(photoPath);
            System.out.println(market);


            switch (market.getMkname()){
                case "0" :
                    Fcosmetics fcosmetics = new Fcosmetics();
                    fcosmetics.setParameters(fieldMap);
                    fcosmetics.setFcid(mkgid);
                    fcosmetics.setFcimg(photoPath);
                    System.out.println(fcosmetics.toString());
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
