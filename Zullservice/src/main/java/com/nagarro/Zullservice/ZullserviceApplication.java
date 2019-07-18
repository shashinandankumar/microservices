package com.nagarro.Zullservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.nagarro.filter.ErrorFilter;
import com.nagarro.filter.PostFilter;
import com.nagarro.filter.PreFilter;
import com.nagarro.filter.RouteFilter;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZullserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZullserviceApplication.class, args);
	}
	@Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }

    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }

    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }

    @Bean
    public RouteFilter routeFilter() {
        return new RouteFilter();
    }

}
