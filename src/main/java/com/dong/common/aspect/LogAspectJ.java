package com.dong.common.aspect;

import com.alibaba.druid.support.json.JSONUtils;
import com.dong.system.entity.User;
import com.dong.system.service.ILogService;
import com.dong.util.HttpContextRequestUtil;
import com.dong.util.ShiroUtils;
import com.dong.util.httpIpUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;

@Aspect
@Component
public class LogAspectJ {
   @Autowired
   ILogService logService;

    @Pointcut("@annotation(com.dong.common.aspect.Log)")
    public void pointCutLog(){}

    @Around("pointCutLog()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        com.dong.system.entity.Log log = new com.dong.system.entity.Log();
        if(ShiroUtils.getUser()!=null){
            log.setUserid(ShiroUtils.getUserId());
            log.setUsername(ShiroUtils.getUser().getUsername());
        }//退出获取


        long start = System.currentTimeMillis();
        Object proceed = point.proceed();
        long end = System.currentTimeMillis();

        if(ShiroUtils.getUser()!=null) {
            log.setUserid(ShiroUtils.getUserId());
            log.setUsername(ShiroUtils.getUser().getUsername());
        }//登录获取

        insertDatabase(point,log,start,end);
        return proceed;
    }

    public void insertDatabase(ProceedingJoinPoint joinPoint, com.dong.system.entity.Log log, Long start, Long end){

        log.setCreatetime(LocalDateTime.now());//创建时间
        log.setTime(LocalDateTime.ofInstant(Instant.ofEpochMilli(end), ZoneId.systemDefault()));//结束时间
        log.setConsumetime(((Long)(end-start)).toString());//总耗时

        Object[] args = joinPoint.getArgs();//参数太大就不往数据库写了
        //Arrays.toString(args);
     /*   StringBuffer str = new StringBuffer();
        Arrays.stream(args).forEach((a)->{
        });*/

        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        Log annotation = method.getAnnotation(Log.class);
        String value = annotation.value();
        log.setOperation(value);

        String classname = joinPoint.getTarget().getClass().getName();//全类名
        String methodname = method.getName();//方法名
        log.setMethod(methodname);
        log.setOperationmethod(classname+"."+methodname);
        HttpServletRequest httpServletRequest = HttpContextRequestUtil.getHttpServletRequest();
        String realIp = httpIpUtils.getRealIp(httpServletRequest);
        log.setIp(realIp);//IP地址





        logService.save(log);

    }

    public static void main (String[] args) {
        System.out.println(LocalDateTime.now());
    }
}
