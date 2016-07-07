package sdkd.com.ec.im;

import sdkd.com.ec.model.EYNotice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ydf_m on 2016/7/7.
 */
public class EYNoticeImport extends Execute{
    public List<EYNotice> getNotices(){
        List<EYNotice> newsList = new ArrayList<EYNotice>();
        String sql = "select * from easybuy_notices order by en_create_time desc limit 0,7";
        try {
            ResultSet rs = this.executeSearch(sql,null);
            while (rs.next()){
                EYNotice news = new EYNotice();
                news.setEn_title(rs.getString("en_title"));
                //添加到集合中
                newsList.add(news);
            }
            //rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return newsList;
    }
}
