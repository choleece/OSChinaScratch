package cn.choleece.oschina.init;


import com.jfinal.ext.plugin.tablebind.AutoTableBindPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by choleece on 2017/3/23.
 */
public class InitConfig {

    private static final Logger logger = Logger.getLogger(InitConfig.class);

    public void initALlConfig() throws IOException {
        initDB();
    }


    private void initDB() throws IOException {
        Properties properties = new Properties();
        properties.load(getClass().getResourceAsStream("/db.properties"));

        DruidPlugin dp = new DruidPlugin(properties.getProperty("db"), properties.getProperty("user"), properties.getProperty("password"));
        dp.set(Integer.valueOf(properties.getProperty("initialSize")), Integer.valueOf(properties.getProperty("minIdle")),
                Integer.valueOf(properties.getProperty("maxActive")));
        dp.setRemoveAbandonedTimeoutMillis(6 * 1000);

        AutoTableBindPlugin atbp = new AutoTableBindPlugin(dp);
        atbp.autoScan(false);
        atbp.addScanPackages("cn.choleece.oschina.model");
        atbp.setShowSql(false);

        dp.start();
        atbp.start();


        logger.warn("finish initDB()");
    }

}
