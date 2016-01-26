package com.test;

import org.logicalcobwebs.proxool.CompositeConnectionListener;
import org.logicalcobwebs.proxool.ProxoolFacade;
import org.logicalcobwebs.proxool.configuration.JAXPConfigurator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by liuxinlong on 16/1/4.
 */
public class TestDao {

    Connection conn=null;


    public static void main(String[] args) {
        TestDao td = new TestDao();
        td.getUsrInfoWithProxool(1);
    }

    /**
     * Proxool实现
     * @throws
     */
    public void getUsrInfoWithProxool(int id)  {
        String sql="SELECT * FROM team WHERE id=" + id;
        try {
            //PropertyConfigurator.configure("resource/proxool.properties");
            JAXPConfigurator.configure("/Users/liuxinlong/workspace_java/prox_test/src/main/resources/proxool.xml", false);
            ProxoolFacade.addConnectionListener("mysql", new CompositeConnectionListener());
            Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
            conn = DriverManager.getConnection("proxool.mysql");
            Statement st=conn.createStatement();
            ResultSet result=st.executeQuery(sql);
            while(result.next()) {
                System.out.println("Proxool:begin");
                System.out.println("Name:" + result.getString("TEAM_NAME"));
                System.out.println("Proxool:end");
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}