package com.epc.product;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages={"com.epc.product"})// same as @Configuration @EnableAutoConfiguration @ComponentScan combined
@EnableJSONDoc
public class EPCProductMgmtApiApp {
	public static void main(String[] args) {
		SpringApplication.run(EPCProductMgmtApiApp.class, args);
	}
}
