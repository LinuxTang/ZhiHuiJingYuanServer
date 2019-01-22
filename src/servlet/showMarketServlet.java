package servlet;

import dao.MarketDao;
import net.sf.json.JSONArray;
import pojo.encapsulation.AllMarketShowList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class showMarketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        MarketDao marketDao = new MarketDao();
        List<AllMarketShowList> maketList = marketDao.selectAllMarkets();
        JSONArray json = JSONArray.fromObject(maketList);

        response.setCharacterEncoding("utf-8");
        Writer out = response.getWriter();
        out.write(json.toString());
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
