package com.bestpay.tools.test.dubbo;

import com.bestpay.tools.test.dubbo.tester.DubboTester;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
@Slf4j
public class App 
{
    @Getter
    static private ClassPathXmlApplicationContext context;

    static private App app;

    @Autowired
    @Getter
    private DubboTester dubboTester;

    public static void StartApp(){
        context = new ClassPathXmlApplicationContext("spring/spring-context.xml");
        context.start();
        context.registerShutdownHook();

        app = context.getBean("myApp", App.class);

        app.getDubboTester().Test(context);
    }

    public static void main( String[] args )
    {
        log.info("测试开始");
        StartApp();
    }
}
