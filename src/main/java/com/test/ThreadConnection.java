package com.test;

import com.pool.ConnectionPoolManager;
import com.pool.IConnectionPool;

import java.sql.Connection;

/**
 * Created by liuxinlong on 16/1/6.
 */
public class ThreadConnection implements Runnable {

    private IConnectionPool pool;
    @Override
    public void run() {

        pool = ConnectionPoolManager.getInstance().getPool();
    }

    public Connection getConnection(){
        Connection conn = null;
//        if(pool != null && pool.isActive()){
//            conn = pool.getConnection();
//        }
        conn = ConnectionPoolManager.getInstance().getConnection();
        return conn;
    }

    public Connection getCurrentConnection(){
        Connection conn = null;
        if(pool != null && pool.isActive()){
            conn = pool.getCurrentConnecton();
        }
        return conn;
    }

}
