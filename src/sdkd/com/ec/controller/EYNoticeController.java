package sdkd.com.ec.controller;

import sdkd.com.ec.im.EYNoticeImport;
import sdkd.com.ec.model.EYNotice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by ydf_m on 2016/7/7.
 */
@WebServlet(name = "EYNoticeController")
public class EYNoticeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EYNoticeImport noticeImport = new EYNoticeImport();
        List<EYNotice> list = noticeImport.getNotices();
        request.setAttribute("noticesList",list);


        //跳转
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
