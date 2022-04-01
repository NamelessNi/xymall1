package com.xy.xymall;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement  // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@ComponentScan("com.xy.xymall.*")

public class XymallApplication {

    public static void main(String[] args) {
        SpringApplication.run(XymallApplication.class, args);
    }

}
