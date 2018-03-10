package com.hersa.sample.project.web.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BeanUtils implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        context = applicationContext;

    }

    public static <T> T getBean(Class<T> beanClass) {

        return context.getBean("", beanClass);
    }

}