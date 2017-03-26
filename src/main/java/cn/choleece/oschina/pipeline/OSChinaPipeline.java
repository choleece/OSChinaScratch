package cn.choleece.oschina.pipeline;

import cn.choleece.oschina.model.News;
import cn.choleece.oschina.po.OSNews;
import cn.choleece.oschina.util.SnowFlagKit;
import cn.choleece.oschina.util.StrKit;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;

import java.util.List;

/**
 * Created by choleece on 2017/3/25.
 */
public class OSChinaPipeline extends OnsePipeline {

    private static final Logger logger = Logger.getLogger(OSChinaPipeline.class);

    @Override
    public void process(ResultItems resultItems, Task task) {
        List<OSNews> osNews = resultItems.get("news");

        System.out.println(JSONObject.toJSONString(osNews));

        osNews.forEach(item -> insertNews(item));

    }

    public void insertNews(OSNews osNews) throws RuntimeException{
        News news = News.dao.findFirst("select * from TOSNews where NewsUrl = ?", osNews.getNewsUrl());

        if (news!= null) {
            news.set("ReadTimes", osNews.getReadTimes());
            news.dao.update();
        } else {
            news = News.dao;
            String partContent = osNews.getNewsPartContent();
            if (partContent.length() > 20) {
                partContent = partContent.substring(0, 20);
            }
            news.set("NewsTitle", StrKit.clearEmpty(osNews.getNewsTitle()))
                    .set("NewsID", SnowFlagKit.getInstance().next())
                    .set("NewsPartContent", StrKit.clearEmpty(partContent))
                    .set("NewsUrl", osNews.getNewsUrl()).set("PublishTime", osNews.getPublishTime())
                    .set("CratchTime", osNews.getScratchTime()).set("ReadTimes", osNews.getReadTimes())
                    .set("CommentTimes", osNews.getConmentTimes()).set("ThumbUpTimes", osNews.getThumbTimes())
                    .set("AwardTimes", osNews.getAwardTimes()).set("NewsType", osNews.getNewsType());
            news.save();

            logger.info("save succeed");
        }
    }
}
