package com.example.demo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TmpTask {
    @Scheduled(cron = "${task.tmp.default.cron}")
    public void printTime() {
        System.out.println(System.currentTimeMillis());
    }
}
