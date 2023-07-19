package dev.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.UUID;

@Slf4j
@Aspect
@Component
public class LogAspect {

    // cmd option shift l
    // cmd opt v
    //    @Before()
//    @After()
//    @AfterReturning()
    @Around("execution(* dev.controller.*.controller.*.*(..))")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Signature signature = pjp.getSignature();
//        String name = signature.getName();

//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
//        String pathInfo = request.getPathInfo();
//        request.getMethod();
        UUID uuid = UUID.randomUUID();

        log.info("경로: {} / {}", uuid, signature);

//        return pjp.proceed();

        Object p = pjp.proceed();
        stopWatch.stop();
        log.info("{} / {} 종료", uuid, signature);

        log.info("{}\n", stopWatch.prettyPrint());
        return p;
    }
}
