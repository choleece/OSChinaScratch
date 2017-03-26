package cn.choleece.oschina.po;

import cn.choleece.oschina.constant.DateType;
import cn.choleece.oschina.util.DateKit;

import java.util.Date;

/**
 * Created by choleece on 2017/3/23.
 */
public class OSNews {

    private String newsTitle;

    private String newsPartContent;

    private String newsUrl;

    private Date publishTime;

    private Date scratchTime;

    private String readTimes;

    private String conmentTimes;

    private String thumbTimes;

    private String awardTimes;

    private String newsType;

    public OSNews() {
    }

    public OSNews(String newsTitle, String newsPartContent, String newsUrl,
                  long publishTime, String readTimes, String conmentTimes,
                  String thumbTimes, String awardTimes, String newsType) {
        this.newsTitle = newsTitle;
        this.newsPartContent = newsPartContent;
        this.newsUrl = newsUrl;
        this.publishTime = new Date(1l);
        this.readTimes = readTimes.equals("") ? "0" : readTimes;
        this.conmentTimes = conmentTimes.equals("") ? "0" : conmentTimes;
        this.thumbTimes = thumbTimes.equals("") ? "0" : thumbTimes;
        this.awardTimes = awardTimes.equals("") ? "0" : awardTimes;
        this.newsType = newsType;
        this.scratchTime = new Date(publishTime);

    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsPartContent() {
        return newsPartContent;
    }

    public void setNewsPartContent(String newsPartContent) {
        this.newsPartContent = newsPartContent;
    }

    public String getNewsUrl() {
        return newsUrl;
    }

    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getScratchTime() {
        return scratchTime;
    }

    public void setScratchTime(Date scratchTime) {
        this.scratchTime = scratchTime;
    }

    public String getReadTimes() {
        return readTimes;
    }

    public void setReadTimes(String readTimes) {
        this.readTimes = readTimes;
    }

    public String getConmentTimes() {
        return conmentTimes;
    }

    public void setConmentTimes(String conmentTimes) {
        this.conmentTimes = conmentTimes;
    }

    public String getThumbTimes() {
        return thumbTimes;
    }

    public void setThumbTimes(String thumbTimes) {
        this.thumbTimes = thumbTimes;
    }

    public String getAwardTimes() {
        return awardTimes;
    }

    public void setAwardTimes(String awardTimes) {
        this.awardTimes = awardTimes;
    }

    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }
}
