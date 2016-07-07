package sdkd.com.ec.im;

/**
 * Created by ydf_m on 2016/7/6.
 */
public class EYRegisterImport extends Execute{
    public void setUser(String userName, String passWord){
        String sql = "insert into easybuy_user(eu_user_name, eu_password) values('" + userName + "', '"+ passWord + "')";

        this.executeModify(sql, null);
    }
}
