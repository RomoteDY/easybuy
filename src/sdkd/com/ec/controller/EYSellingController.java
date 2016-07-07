package sdkd.com.ec.controller;

import sdkd.com.ec.im.EYSellingImport;
import sdkd.com.ec.model.EYProduct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by ydf_m on 2016/7/6.
 */
@WebServlet(name = "EYSelling")
public class EYSellingController extends HttpServlet {
    EYSellingImport sellingimport = new EYSellingImport();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String flag=request.getParameter("flag");
        if("detil".equals(flag)){
            selldetil(request,response);
        }else{
            hotsell(request,response);
        }
    }
    public void hotsell(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<EYProduct> list = sellingimport.getHotSelling();
        request.setAttribute("sellingList",list);
        request.getRequestDispatcher("/category.do").forward(request,response);

    }
    public void selldetil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p_id=request.getParameter("id");
        int id=Integer.parseInt(p_id);
        EYProduct e=sellingimport.getSellingDetil(id);
        request.setAttribute("pdetil",e);
        request.getRequestDispatcher("product-view.jsp").forward(request,response);

    }
}
