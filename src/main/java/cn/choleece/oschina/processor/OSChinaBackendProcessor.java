package cn.choleece.oschina.processor;

import cn.choleece.oschina.constant.DateType;
import cn.choleece.oschina.po.OSNews;
import cn.choleece.oschina.util.DateKit;
import com.alibaba.fastjson.JSONObject;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.selector.Html;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by choleece on 2017/3/25.
 */
public class OSChinaBackendProcessor extends BaseProcessor {

    private String newsType;

    private static String recomentBlogUrl = "https://www.oschina.net/action/ajax/get_more_recommend_blog?classification=territory&p=page";

    private static String recentBolgUrl = "https://www.oschina.net/action/ajax/get_more_recent_blog?classification=territory&p=page";

    public static String getRecomentBlogUrl() {
        return recomentBlogUrl;
    }

    public static void setRecomentBlogUrl(String recomentBlogUrl) {
        OSChinaBackendProcessor.recomentBlogUrl = recomentBlogUrl;
    }

    public static String getRecentBolgUrl() {
        return recentBolgUrl;
    }

    public static void setRecentBolgUrl(String recentBolgUrl) {
        OSChinaBackendProcessor.recentBolgUrl = recentBolgUrl;
    }

    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    public OSChinaBackendProcessor() {
    }

    public OSChinaBackendProcessor(String newsType) {
        this.newsType = newsType;
    }

    @Override
    public void process(Page page) {
        Html html = page.getHtml();
        List<String> contents = html.xpath("//div[@class='box-aw']").all();

        List<OSNews> osNews = new ArrayList<OSNews>();

        contents.forEach(item -> {
            Html temp = new Html(item);
            String partContent = temp.xpath("section").get().
                    replaceAll("<section class=\"blog-brief text-gradient\">|</section>", "");
            String newsUrl = temp.xpath("//header/a/@href").get();
            String newsTitle = temp.xpath("//header/a/@title").get();
            List<String> spans = temp.xpath("//footer/span").all();

            long publishTime = this.getPublishDate(spans.get(2).replaceAll("\\D", ""), spans.get(2));

            String readTimes = "";

            if (spans.size() == 4) {
                readTimes = spans.get(3).replaceAll("\\D", "");
            }
            osNews.add(new OSNews(newsTitle, partContent, newsUrl, publishTime, readTimes, "",
                    "", "", this.getNewsType()));
        });

        page.putField("news", osNews);

    }

    // 获取博客发布的时间
    private long getPublishDate(String timeBefore, String span) {
        if (span.matches(".*分钟.*")) {
            return DateKit.getDate(DateType.MINUTE, timeBefore);
        } else if (span.matches(".*小时.*")) {
            return DateKit.getDate(DateType.HOUR, timeBefore);
        } else if (span.matches(".*天.*")) {
            return DateKit.getDate(DateType.DAY, timeBefore);
        } else if (span.matches(".*月.*")) {
            return DateKit.getDate(DateType.MONTH, timeBefore);
        } else if (span.matches(".*年.*")) {
            return DateKit.getDate(DateType.YEAR, timeBefore);
        } else {
            return DateKit.getDate(DateType.NOW, timeBefore);
        }
    }
}