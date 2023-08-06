package us.codecraft.webmagic.samples;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.samples.pipeline.MysqlPipeline;
import us.codecraft.webmagic.samples.pipeline.OneFilePipeline;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class Mango517PageProcessor implements PageProcessor {

//    private Site site = Site
//            .me()
//            .setDomain("www.517.cn")
////            .setSleepTime(3000)
//            .setUserAgent(
//                    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");
    private final Site site = Site.me();

    private static final String ERSHOUFANG_URL = "https://www\\.517\\.cn/ershoufang/\\d+";

    /**
     * Processes the page, extract URLs to fetch, extract the data and store.
     *
     * @param page page
     */
    @Override
    public void process(Page page) {
        if(page.getUrl().regex(ERSHOUFANG_URL).match()) {
            Ershoufang ershoufang = new Ershoufang();
            ershoufang.setTitle(page.getHtml().xpath("//div[@class='d-title']/text()").get());
            ershoufang.setPrice(page.getHtml().xpath("//span[@class='d-price-number']/text()").get() + "万");
            ershoufang.setUnitPrice(page.getHtml().xpath("//div[@class='d-price-item-container']/span/text()").get());
            ershoufang.setHouseType(page.getHtml().xpath("//div[@class='d-area-left']/div[@class='d-area-title']/text()").get());
            ershoufang.setFloor(page.getHtml().xpath("//div[@class='d-area-left']/div[@class='d-area-subtitle']/text()").get());
            ershoufang.setAreaByChina(page.getHtml().xpath("//div[@class='d-area-center']/div[@class='d-area-title']/text()").get());
            ershoufang.setHouseAge(page.getHtml().xpath("//div[@class='d-area-center']/div[@class='d-area-subtitle']/text()").get());
            ershoufang.setSize(page.getHtml().xpath("//div[@class='d-area-right']/div[@class='d-area-title']/text()").get());
            ershoufang.setRenovationCondition(page.getHtml().xpath("//div[@class='d-area-right']/div[@class='d-area-subtitle']/text()").get());
            ershoufang.setLocation(page.getHtml().xpath("//ul[@class='d-list-container']/li[1]/a[1]/text()").get());
            ershoufang.setLocalArea(page.getHtml().xpath("//ul[@class='d-list-container']/li[2]/a/text()").get());
            ershoufang.setHouseCode(page.getHtml().xpath("//a[@id='SetSeeHouseIdCookie']/text()").get());
            ershoufang.setDesc(page.getHtml().xpath("//div[@class='d-special-container']").replace("<[^>]+>|&[^>^;]+;", "").get());
            page.putField(ershoufang.getTitle(),ershoufang);
        } else {
            List<String> dataIdList = page.getHtml().xpath("//li[@class='m-list-item' and @data-id]/@data-id").all();
            for (String dataId : dataIdList) {
                page.addTargetRequest("https://www.517.cn/ershoufang/"+ dataId);
            }
            // 获取下一页url
            List<String> pageAitems = page.getHtml().xpath("//div[@class='m-page']/a").all();
            String nextUrl = page.getHtml().xpath("//div[@class='m-page']/a[" + pageAitems.size() + "]/@href").get();
            if(nextUrl != null)
                page.addTargetRequest(nextUrl);
        }




    }

    /**
     * Returns the site settings.
     *
     * @return site
     * @see Site
     */
    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Spider.create(new Mango517PageProcessor())
                .addUrl("https://www.517.cn/ershoufang/a2-sq1537/")
                .addPipeline(new OneFilePipeline("P:\\webmagic\\webmagictest.txt"))
                .addPipeline(new ConsolePipeline())
                .addPipeline(new MysqlPipeline())
                .thread(100).run();
    }
}
