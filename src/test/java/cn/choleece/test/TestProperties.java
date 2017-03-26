package cn.choleece.test;


import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by choleece on 2017/3/23.
 */
public class TestProperties {
    private static final Logger logger = Logger.getLogger(TestProperties.class);


    public static void main(String[] args) throws IOException {
        new InitDB().initDB();
    }

    private static class InitDB {
        public void initDB() throws IOException {
            Properties properties = new Properties();
            properties.load(getClass().getResourceAsStream("/db.properties"));

            System.out.println("hahaha" + properties.getProperty("user"));
            logger.info("test properties:" + properties.getProperty("user"));

        }
    }
}
