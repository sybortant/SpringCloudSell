package cn.gamesource.order.controller;//package cn.gamesource.order.controller;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
///**
// * @author: LEIYU
// */
//@Slf4j
//@RestController
//public class ClientController {
//
//    //2.第二种方式;
////    @Autowired
////    private LoadBalancerClient loadBalancerClient;
//
//    //3.第三种方式;
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @GetMapping("/getProductMsg")
//    public String getProductMsg() {
//        //1.restTemplate 第一种方式 地址写死了;
////        RestTemplate restTemplate = new RestTemplate();
////        String msg = restTemplate.getForObject("http://localhost:8000/msg", String.class);
////        log.info("[Response]数据,response={}",msg);
//
//        //2.第二种方式 LoadBalancerClient通过应用名来随机获取服务地址,拼接地址,使用restTemplate请求;
////        ServiceInstance productInstance = loadBalancerClient.choose("PRODUCT");
////        String url = String.format("http://%s:%s", productInstance.getHost(), productInstance.getPort()) + "/msg";
////        RestTemplate restTemplate = new RestTemplate();
////        String msg = restTemplate.getForObject(url, String.class);
////        log.info("[Response]数据,response={}", msg);
//
//            //3.第三种方式; 利用 LoadBalanced注解+RestTemplate 实现负载均衡调用;地址写要调用的服务名
//        String msg = restTemplate.getForObject("http://PRODUCT/msg", String.class);
//        log.info("[Response]数据,response={}", msg);
//        return msg;
//    }
//
//}
