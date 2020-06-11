package com.example.demo.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TmpTask {
    //    @Scheduled(cron = "${task.tmp.default.cron}")
    @Scheduled(cron = "0/30 0/1 * * * ?")
    public void sample1() {
        log.info("cron: " + String.valueOf(System.currentTimeMillis()));
    }

    // fixedDelay 和fixedDelayString 一个固定延迟时间执行,上个任务完成后,延迟多久执行
    // 如下表示: 上一次执行完毕时间点之后10秒再执行
    @Scheduled(fixedDelay = 10 * 1000)
    public void sample2() {
        log.info("fixedDelay: " + String.valueOf(System.currentTimeMillis()));
    }

    // fixedRate 和fixedRateString一个固定频率执行,上个任务开始后多长时间后开始执行
    // 如下表示: 上一次开始执行时间点之后5秒再执行
    @Scheduled(fixedRate = 5 * 1000)
    public void sample3() {
        log.info("fixedRate: " + String.valueOf(System.currentTimeMillis()));
    }

    // initialDelay 和initialDelayString表示一个初始延迟时间,第一次被调用前延迟的时间
    // 如下表示: 第一次延迟2秒后执行，之后按 fixedRate 的规则每5秒执行一次
    @Scheduled(initialDelay = 2 * 1000, fixedRate = 5 * 1000)
    public void sample4() {
        log.info("initialDelay: " + String.valueOf(System.currentTimeMillis()));
    }
}
