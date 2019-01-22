package com.bootdo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by yuantousanfen on 2019/1/22.
 * 在 SpringBootApplication 上使用@ServletComponentScan 注解后，
 * Servlet、Filter、Listener 可以直接通过 @WebServlet、@WebFilter、@WebListener 注解自动注册，
 * 无需其他代码。
 *@EnableTransactionManagement // 开启注解事务管理，等同于xml配置文件中的 <tx:annotation-driven />
 *
 */
@SpringBootApplication
@EnableTransactionManagement
@ServletComponentScan
@EnableCaching
@MapperScan("com.bootdo.*.dao")
public class BootdoApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootdoApplication.class,args);
    }
}
