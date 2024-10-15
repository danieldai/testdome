package com.danieldai.testdome.spring.aop;

import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.*;
import java.lang.annotation.*;
import java.lang.reflect.Modifier;
import java.util.*;

@Aspect
@Component
public class LoggerAOP {
    @Autowired private Logger logger;

    @Pointcut("@annotation(com.danieldai.testdome.spring.aop.LogExecution)")
    public void Log() {}

    @Before("Log()")
    public void loggingAdvice(JoinPoint jp) {
        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        int modifies = methodSignature.getModifiers();

        if(Modifier.isPublic(modifies)) {
            logger.log(methodSignature.getName());
        }
    }
}

@Component
class NameRepository {
    @LogExecution
    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Mary");
        return names;
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecution {}

interface Logger {
    public void log(String data);
}

@Configuration
@EnableAspectJAutoProxy
@Import({LoggerAOP.class, NameRepository.class})
class Config {
    @Bean
    public Logger logger() {
        return (message) -> System.out.println(message);
    }
}