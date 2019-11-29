package cn.evan.schedule;


import cn.evan.comment.HadoopTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


/**
 * @Description
 * @ClassName ScheduleTask
 * @Author Evan
 * @date 2019.11.07 16:50
 */

/**
 * 测试串行并行时，去掉@EnableScheduling的注释
 * 测试动态定时任务，注释@EnableScheduling
 */
@Slf4j
@Component
//@EnableScheduling
public class ScheduleTask {

    @Autowired
    private HadoopTemplate hadoopTemplate;


    @Scheduled(cron = "0/2 * * * * ?")
    public void scanHdfs() throws InterruptedException {
        log.info("执行定时任务1");

        List<Map<String, Object>> result = hadoopTemplate.listFiles("/user/test/", null);

    }
}
