package com.qf.cofig;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.qf.rules.CustomerRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {

    /**
     * 实现负载均衡只需要加上@LoadBanlanced就可以了。
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate()  {
        return new RestTemplate();
    }


    /**
     * 可以改变Ribbon的负载均衡策略，通过返回IRule的方式
     *
     * @return
     */
    @Bean
    public IRule randomRule() {

        //return new RandomRule();
        return new CustomerRule();
    }

}
