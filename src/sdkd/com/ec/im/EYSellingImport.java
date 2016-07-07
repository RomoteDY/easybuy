package sdkd.com.ec.im;

import com.sun.org.apache.xpath.internal.SourceTree;
import sdkd.com.ec.model.EYProduct;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ydf_m on 2016/7/6.
 */
public class EYSellingImport extends Execute{
    public EYProduct getSellingDetil(int id){
        String sql = "select * from easybuy_product where ep_id=?";
        List<Object> params = new ArrayList<Object>();
        params.add(id+"");
        EYProduct selling = new EYProduct();
        try {
            ResultSet rs = this.executeSearch(sql,params);
            while (rs.next()){
                selling.setEp_id(rs.getInt("ep_id"));
                selling.setEp_name(rs.getString("ep_name"));
                selling.setEp_price(rs.getDouble("ep_price"));
                selling.setEp_stock(rs.getInt("ep_stock"));
                selling.setEp_picture(rs.getString("ep_picture"));
                selling.setEp_description(rs.getString("ep_description"));
            }
            //rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        }
        System.out.println(selling.getEp_name());
        return selling;
    }
    public List<EYProduct> getHotSelling(){
        List<EYProduct> sellingList = new ArrayList<EYProduct>();
        String sql = "select * from easybuy_product order by epc_views desc limit 0,12;";
        try {
            ResultSet rs = this.executeSearch(sql,null);
            while (rs.next()){
                EYProduct selling = new EYProduct();
                selling.setEp_id(rs.getInt("ep_id"));
                selling.setEp_name(rs.getString("ep_name"));
                selling.setEp_price(rs.getDouble("ep_price"));
                selling.setEp_stock(rs.getInt("ep_stock"));
                selling.setEp_picture(rs.getString("ep_picture"));
                //添加到集合中
                sellingList.add(selling);
            }
            //rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return sellingList;
    }
}
