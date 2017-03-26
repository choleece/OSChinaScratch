package cn.choleece.test;

import cn.choleece.oschina.init.InitConfig;
import cn.choleece.oschina.model.Keyword;
import cn.choleece.oschina.model.News;

import java.io.IOException;
import java.util.List;

/**
 * Created by choleece on 2017/3/23.
 */
public class TestJFinalSQL {
    public static void main(String[] args) throws IOException, InterruptedException {

        new InitConfig().initALlConfig();

        List<News> newss = News.dao.find("select * from TOSNews where NewsTitle = ?", "测试");

        System.out.println(newss.toString());

        assert newss.size() != 0;

    }
}
