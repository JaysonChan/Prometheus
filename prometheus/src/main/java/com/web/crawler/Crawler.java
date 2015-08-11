package com.web.crawler;

import cn.edu.hfut.dmic.webcollector.crawler.BreadthCrawler;
import com.web.entity.CrawlerInfoEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jayson   2015-08-11 16:34
 * @since v1.0
 */
public abstract class Crawler extends BreadthCrawler {
    private static final Logger LOGGER = LoggerFactory.getLogger(Crawler.class);
    private CrawlerInfoEntity crawlerInfo;

    /**
     * @param crawlPath 维护URL信息的文件夹，如果爬虫需要断点爬取，每次请选择相同的crawlPath
     * @param autoParse 是否自动抽取符合正则的链接并加入后续任务
     */
    public Crawler(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
    }
    public Crawler() {
        super(null, false);
    }
    public CrawlerStatus getCrawlerStatus(){
        return getStatus() == cn.edu.hfut.dmic.webcollector.crawler.Crawler.RUNNING ? CrawlerStatus.Running : CrawlerStatus.Stop;
    }

    public void start(){
        try {
            super.start(crawlerInfo.getDepth());
        } catch (Exception e) {
            LOGGER.error("" , e);
        }
    }

    /**getter、setter方法**/
    public CrawlerInfoEntity getCrawlerInfo() {
        return crawlerInfo;
    }

    public void setCrawlerInfo(CrawlerInfoEntity crawlerInfo) {
        this.crawlerInfo = crawlerInfo;
    }
}