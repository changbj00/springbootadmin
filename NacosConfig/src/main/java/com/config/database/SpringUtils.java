package com.config.database;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
@Slf4j
@Component
public class SpringUtils implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtils.applicationContext = applicationContext;
    }
    public static <T> T getBean(String beanName) {
        log.info("beanName:{}",beanName);
        try {
            if (applicationContext.containsBean(beanName)) {
                log.info("yes");
                return (T) applicationContext.getBean(beanName);
            }
        } catch (BeansException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> Map<String, T> getBeansOfType(Class<T> baseType)
    {
        return applicationContext.getBeansOfType(baseType);
    }

    public static ApplicationContext getApplicationContext()
    {
        return applicationContext;
    }
}
