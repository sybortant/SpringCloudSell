package cn.gamesource.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author leiyu
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"cn.gamesource.product.client"})
public class SellOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellOrderApplication.class, args);
    }
}
