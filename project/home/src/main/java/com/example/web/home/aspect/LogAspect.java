package com.example.web.home.aspect;

import com.example.web.entity.LogEntity;
import com.example.web.repository.impl.LogMongoRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;


@Aspect
@Component
public class LogAspect {
    @Autowired
    private LogMongoRepository logMongoRepository;

    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    // 配置织入点
    // execution(<修饰符> <返回类型> <类路径> <方法名>(<参数列表>) <异常模式> )
    @Pointcut("(execution(* com.example.web..* (..))) && !execution(* com.example.web.home.aspect..* (..)))")
//    @Pointcut("(execution(* com.example.web..* (..)))")
    public void logPointCut() {
    }

    /**
     * 拦截异常操作
     *
     * @param joinPoint 切点
     * @param e         异常
     */
    @AfterThrowing(value = "logPointCut()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e) {
        handleLog(joinPoint, e, null);
    }

    protected void handleLog(final JoinPoint joinPoint, final Exception e, Object jsonResult) {
        try {
            System.out.println("hhhh" + e.getMessage());
            LogEntity logEntity = new LogEntity();
            logEntity.setCode("java-ex-10001");
            logEntity.setExType("Exception Type");
            logEntity.setMessage("Exception Message");
            logEntity.setDetails("Exception Details");
            logEntity.setLogTime(LocalDateTime.now());

            logMongoRepository.insertOne(null);
//            throw new RuntimeException("asdasdsasd");
        } catch (Exception exp) {
            // 记录本地异常日志
            log.error("==前置通知异常==");
            log.error("异常信息:{}", exp.getMessage());
            exp.printStackTrace();
        }
    }
}
