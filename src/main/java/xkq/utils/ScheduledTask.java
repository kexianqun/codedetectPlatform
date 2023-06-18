package xkq.utils;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ScheduledTask {

    @Scheduled(cron="0 0 04 * * ?")
    public void scheduledTask() {
        System.out.println("sdfsdfsfsfssssssssssssssssss-----------------------------------------------------------");
        System.out.println("任务执行时间：" + LocalDateTime.now());
        System.out.println("sdfsdfsfsfssssssssssssssssss-----------------------------------------------------------");

    }

}