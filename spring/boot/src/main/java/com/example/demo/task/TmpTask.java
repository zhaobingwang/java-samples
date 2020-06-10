package com.example.demo.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TmpTask {
    @Scheduled(cron = "${task.tmp.default.cron}")
    public void printTime() {
        log.info(String.valueOf(System.currentTimeMillis()));
    }
}
