package com.pool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuxinlong on 16/1/6.
 */
public class DBInitInfo {

    public  static List<DBbean> beans = null;
    static{
        beans = new ArrayList<DBbean>();
        // 这里数据 可以从xml 等配置文件进行获取
        // 为了测试，这里我直接写死
        DBbean beanOracle = new DBbean();
        beanOracle.setDriverName("com.mysql.jdbc.Driver");
        beanOracle.setUrl("jdbc:mysql://192.168.66.202:3306/test_koudaitong");
        beanOracle.setUserName("test_koudaitong");
        beanOracle.setPassword("nPMj9WWpZr4zNmjz");

        beanOracle.setMinConnections(5);
        beanOracle.setMaxConnections(100);

        beanOracle.setPoolName("testPool");
        beans.add(beanOracle);
    }
}
