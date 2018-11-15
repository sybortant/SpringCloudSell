package cn.gamesource.selleureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注册中心
 *
 * @author LEIYu
 */
@SpringBootApplication
@EnableEurekaServer
public class SellEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellEurekaApplication.class, args);
    }
}
