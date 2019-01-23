package servlet;

import pojo.Fwallet;
import pojo.Lose;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class wxLostItemServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {

        //判断为哪种物品的发布
        String category = request.getParameter("cate");
        Lose lose = new Lose();
//        Map<String,String[]> map =  request.getParameterMap();
//        Iterator<Map.Entry<String, String[]>> it = map.entrySet().iterator();
//        while(it.hasNext()){
//            Map.Entry<String, String[]> entry = it.next();
//            System.out.println("key = " +entry.getKey() + "and value = "+entry.getValue()[0]);
////        }
//        System.out.println();
        if("钱包".equals(category)){
            Fwallet fwallet = new Fwallet();
            if(request.getParameter("color") != null){
                fwallet.setFwcolor(request.getParameter("color"));
            }
            if(request.getParameter("date") != null){
                lose.setLgtime(request.getParameter("date"));
            }
            if(request.getParameter("place") != null){
                lose.setLgplace(request.getParameter("place"));
            }
            if(request.getParameter("message") != null){
                fwallet.setFwdescribe(request.getParameter("message"));
            }
            if(request.getParameter("img") != null){
                fwallet.setFwimg(request.getParameter("img"));
            }
            System.out.println(fwallet);

        }


    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
