import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

class UserBean {
    private String name;
    private int age;
    private String sex;
    private Date birthday;
    private String address;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getSex(){
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday(){
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}

public class Honey {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/d");

        try {
            UserBean userBean = new UserBean();
            userBean.setName("上山 孝幸");
            userBean.setAge(40);
            userBean.setSex("男性");
            userBean.setBirthday(sdf.parse("1980/10/02"));
            userBean.setAddress("石川");

            Map<String, UserBean> map = new HashMap<String, UserBean>();
            map.put("user", userBean);
            XLSTransformer transformer = new XLSTransformer();
            transformer.transformXLS("docs/templete.xls", map, "docs/output.xls");

        } catch (ParseException | IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
    }
}