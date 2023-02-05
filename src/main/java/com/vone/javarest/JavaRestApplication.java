package com.vone.javarest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vone.javarest.entity.ThreadEntity;

@SpringBootApplication
public class JavaRestApplication {

	public static void main(String[] args) {
		System.out.println(ThreadEntity.getComments());
		System.out.println(ThreadEntity.comments);
		SpringApplication.run(JavaRestApplication.class, args);
	}

}
