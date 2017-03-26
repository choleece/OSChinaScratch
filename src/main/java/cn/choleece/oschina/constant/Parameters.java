package cn.choleece.oschina.constant;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by choleece on 2017/3/25.
 */
public class Parameters {

    // 开源中国服务端开发管理领域博客
    public static final String NEWS_TERRITORY = "428640";

    // 最新的文章
    public static final String RECENT_NEWS = "recent";

    // 推荐的文章
    public static final String RECOMMEND_NEWS = "recommend";


    // Site 设置
    public static final int RETRY_TIMES = 2;
    public static final int CYCLE_RETRY_TIMES = 5;
    public static final int SLEEP_TIME = 1000;
    public static final int TIME_OUT = 5000;

    // 新闻引用失效时间，距今超过n小时的新闻不更新引用数
    public static int NEWS_EXPIRE_HOURS = 24;
    // 新闻失效时间，距今超过n小时的新闻不保存
    public static int NEWS_SAVE_EXPIRE_HOURS = 24 * 2;
    // 转发量小于n的新闻不保存
    public static int NEWS_LOW_QUOTO_IGNORE_COUNT = 5;
    // 删除距今超过n天的新闻
    public static int NEWS_DELETE_DAYS = 30;
    // 删除距今超过n天的新闻审核
    public static int AUDITNEWS_DELETE_DAYS = 7;

    // user_agents
    private static List<String> AGENTS;
    private static final String AGENTS_PATH = System.getProperty("os.name").toLowerCase().contains("linux")
            ? "user_agents.txt" : "src/main/resources/user_agents.txt";

    public static void initAgents() {
        AGENTS = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(AGENTS_PATH));
            String s;
            while ((s = reader.readLine()) != null) {
                AGENTS.add(s);
            }
            reader.close();
        } catch (Exception e) {
            Logger.getLogger(Parameters.class).error(AGENTS_PATH + " not exists!");
        }
    }

    public static String randomAgent() {
        if (AGENTS == null) {
            throw new IllegalStateException("should call initAgents() first!");
        }

        int size = AGENTS.size();
        if (size <= 0) {
            Logger.getLogger(Parameters.class).error("no agent found in " + AGENTS_PATH);
            return null;
        }

        int index = new Random().nextInt(size);
        return AGENTS.get(index);
    }
}
