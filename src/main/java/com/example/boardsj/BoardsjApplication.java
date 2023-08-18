package com.example.boardsj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.boardsj.**.mappers")
public class BoardsjApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardsjApplication.class, args);
	}

}
