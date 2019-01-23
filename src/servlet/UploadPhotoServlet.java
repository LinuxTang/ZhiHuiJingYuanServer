package servlet;


import Utils.UploadFileImg;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


public class UploadPhotoServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String fileName = UploadFileImg.instance().UploadImg(request);
        if(fileName == null) return;
        String realSavePath = fileName;
        Writer out1 = response.getWriter();
        out1.write(realSavePath);
        System.out.println("***" + realSavePath);
        out1.flush();
        out1.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

}
