package com.example.jdbcstudentjdk17;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
public class DBConnection {

    public static DataSource getMySQLDataSource() {
        Properties props = new Properties();
        FileInputStream fis = null;
        BasicDataSource ds = new BasicDataSource();
        InputStream inputStream;
        try {
            fis = new FileInputStream("\\db.properties");
            props.load(fis);
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
        ds.setDriverClassName(props.getProperty("MYSQL_DB_DRIVER_CLASS"));
        ds.setUrl(props.getProperty("MYSQL_DB_URL"));
        ds.setUsername(props.getProperty("MYSQL_DB_USERNAME"));
        ds.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
        return ds;
    }
}
