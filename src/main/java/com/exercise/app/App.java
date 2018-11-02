package com.exercise.app;

import com.exercise.hello.EnableHelloStarter;
import com.exercise.hello.HelloService;
import com.exercise.hello.properties.HelloServiceExtendProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan //默认扫描所在包下面的class。
//@SpringBootApplication //等同于上面三个注解
@EnableHelloStarter //启用自定义的starter模块。相当于导入Auto Configuration类；其中的package name尽量不要和调用者的package name相同。
@RestController
public class App {

    @Autowired
    HelloServiceExtendProperties helloServiceExtendProperties;
    @Autowired
    private HelloService helloService;

    @RequestMapping("/")
    public String index() {
        helloService.setMsg(helloServiceExtendProperties.getMsg());
        return helloService.sayHello();
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
