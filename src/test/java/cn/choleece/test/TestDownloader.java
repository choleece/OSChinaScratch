package cn.choleece.test;

import cn.choleece.oschina.constant.Parameters;
import cn.choleece.oschina.init.InitConfig;
import cn.choleece.oschina.pipeline.OSChinaPipeline;
import cn.choleece.oschina.processor.OSChinaBackendProcessor;
import us.codecraft.webmagic.Spider;

import java.io.IOException;

/**
 * Created by choleece on 2017/3/25.
 */
public class TestDownloader {
    public static void main(String[] args) throws IOException {
        new InitConfig().initALlConfig();

        Spider.create(new OSChinaBackendProcessor(Parameters.RECOMMEND_NEWS))
                .addUrl(OSChinaBackendProcessor.getRecomentBlogUrl()
                        .replace("page", "1").replace("territory", Parameters.NEWS_TERRITORY))
                .addPipeline(new OSChinaPipeline()).run();
    }

}
