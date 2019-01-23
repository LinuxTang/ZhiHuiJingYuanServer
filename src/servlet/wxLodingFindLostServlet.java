package servlet;

import dao.FindDao;
import dao.LoseDao;
import net.sf.json.JSONObject;
import pojo.encapsulation.AllItemsShowList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class wxLodingFindLostServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        response.setHeader("Access-Control-Allow-Origin", "*");

        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        //有前端页面确定首先填充的是丢失物品
        Map<String,Object> allitems = new HashMap<String,Object>();

        //查找丢失表 还有关联的user表和丢失物品表
        List<AllItemsShowList> lostItems = LoseDao.instance().findLoseItems();
        allitems.put("lostItemsList",lostItems);

        //捡到物品 同上
        List<AllItemsShowList> findItems = FindDao.instance().selectFindItems();
        allitems.put("findItemsList",findItems);

        JSONObject jsonObject = JSONObject.fromObject(allitems);
        Writer out = response.getWriter();
        String jsonstr = jsonObject.toString();
        out.write(jsonstr);
        System.out.println(jsonstr);
        out.flush();
    }
}
