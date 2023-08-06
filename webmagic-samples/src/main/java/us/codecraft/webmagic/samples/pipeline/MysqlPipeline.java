package us.codecraft.webmagic.samples.pipeline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.samples.Ershoufang;
import us.codecraft.webmagic.util.JDBC;


import java.util.Map;

public class MysqlPipeline implements Pipeline {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final JDBC jdbc = new JDBC();

    /**
     * Process extracted results.
     *
     * @param resultItems resultItems
     * @param task        task
     */
    @Override
    public void process(ResultItems resultItems, Task task) {
        Map<String, Object> map = resultItems.getAll();
        if (null != map && map.size() != 0) {
            Object[] keyset = map.keySet().toArray();
            try {
                for (Object key : keyset) {
                    Ershoufang ershoufang = (Ershoufang) map.get((String)key);
                    logger.info("mysql入库开始，url: " + resultItems.getRequest().getUrl());
                    logger.info(ershoufang.toString());
                    String sql = "insert into ershoufang values('" + ershoufang.getHouseCode() + "','" + ershoufang.getTitle() + "','" +
                            ershoufang.getLocation() + "','" + ershoufang.getDesc() + "','" + ershoufang.getPrice() + "','"
                            + ershoufang.getHouseType() + "','" + ershoufang.getFloor() + "','" + ershoufang.getHouseAge() + "','" +
                            ershoufang.getUnitPrice() + "','" + ershoufang.getAreaByChina() + "','" + ershoufang.getSize() + "','"
                            + ershoufang.getRenovationCondition() + "','" + ershoufang.getLocalArea() + "',now())";
                    logger.info(sql);
                    jdbc.insert(sql);
                    logger.info("mysql入库结束，url: " + resultItems.getRequest().getUrl());
                }
            } catch (Exception e) {
                logger.error("mysql入库异常", e);
            }
        }
    }
}
