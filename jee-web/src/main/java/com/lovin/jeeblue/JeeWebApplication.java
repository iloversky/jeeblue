package com.lovin.jeeblue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("application.properties")
// 通配符没用
//@MapperScan("com.lovin.jeeblue.*.mapper")
@ComponentScan(basePackages="com.lovin.jeeblue")
public class JeeWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(JeeWebApplication.class, args);
	}

}
