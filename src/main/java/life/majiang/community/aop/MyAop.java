//package life.majiang.community.aop;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Arrays;
//
//@Component
//@Aspect
//@Slf4j
//public class MyAop
//{
//    //execution()参数:"(返回值类型,方法(参数类型))"
//    @Pointcut("execution(public String life.majiang.community.controller.HelloAopController.hello(String))" )
//    public void log()
//    {
//        log.info("方法执行中...");
//    }
//
//    @Before(argNames = "joinPoint",value = "log()")
//    public void beforeExcution(JoinPoint joinPoint)
//    {
//        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest req = requestAttributes.getRequest();
//        log.info("前置通知开启=====================");
//
//        log.info("URL : " + req.getRequestURL().toString());
//        log.info("HTTP_METHOD : " + req.getMethod());
//        log.info("IP : " + req.getRemoteAddr());
//        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
//
//        log.info("前置通知结束=====================");
//
//    }
//
//    @AfterReturning(returning = "ret",pointcut = "log()") //后置返回
//    public void doAfterReturning(Object ret)throws Throwable
//    {
//        // 处理完请求，返回内容
//        log.info("RESPONSE : " + ret);
//    }
//
//    @Around("log()")
//    public Object watch(ProceedingJoinPoint joinPoint)
//    {
//        Object result = null;
//        try {
//            log.info("接受请求前...");
//            result = joinPoint.proceed();
//            log.info("执行结果:"+result);
//            log.info("执行完啦!");
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//
//        return result;
//
//    }
//
//}
