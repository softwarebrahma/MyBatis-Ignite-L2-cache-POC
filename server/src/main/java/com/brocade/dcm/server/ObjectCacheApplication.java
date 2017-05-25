package com.brocade.dcm.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
//@MapperScan("com.brocade.dcm.domain.mapper")
public class ObjectCacheApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ObjectCacheApplication.class);;
	}
	
	
}
