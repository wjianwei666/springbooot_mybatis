package com.sean;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 系统启动人口类 
 * 
 * ClassName: Application
 * @Description: 系统启动人口类 
 * @author  Wang Jianwei
 * @date 2016-1-22
 */
@Configuration
@ComponentScan({"com.sean.*"})
@EnableAutoConfiguration
public class Application {
	
	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
	}
	
}