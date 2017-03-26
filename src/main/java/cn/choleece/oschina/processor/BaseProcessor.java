package cn.choleece.oschina.processor;

import cn.choleece.oschina.constant.Parameters;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by choleece on 2017/3/25.
 */
public abstract class BaseProcessor implements PageProcessor {

    protected Site site = Site.me().setRetryTimes(Parameters.RETRY_TIMES).setSleepTime(Parameters.SLEEP_TIME)
            .setCycleRetryTimes(Parameters.CYCLE_RETRY_TIMES).setTimeOut(Parameters.TIME_OUT).setCharset("utf-8")
            .setUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");

    @Override
    public Site getSite() {
        return site;
    }

    @Override
    public void process(Page page) {

    }
}
