package cn.choleece.oschina;

import cn.choleece.oschina.init.InitConfig;
import cn.choleece.oschina.model.Keyword;
import cn.choleece.oschina.model.News;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * 程序入口
 */
public class Entry {
    public static void main(String[] args) throws Exception {

        new InitConfig().initALlConfig();

        List<News> news = News.dao.find("select * from TOSNews");

        System.out.println(JSONObject.toJSONString(news));

        System.out.println(JSONObject.toJSONString(Keyword.dao.find("select Keyword from TKeyword")));
    }
}
