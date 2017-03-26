package cn.choleece.oschina.util;

import com.relops.snowflake.Snowflake;

/**
 * Created by choleece on 2017/3/26.
 */
public class SnowFlagKit {
    private static Snowflake snowflake;

    private static int node = 1;

    public static synchronized Snowflake getInstance() {
        if (snowflake != null) {
            return snowflake;
        }
        return new Snowflake(node);
    }
}
