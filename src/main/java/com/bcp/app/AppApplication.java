package com.bcp.app;

import com.bcp.app.model.CreditType;
import com.bcp.app.model.document.Credit;
import com.bcp.app.service.CreditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

@Slf4j
@SpringBootApplication
public class AppApplication implements CommandLineRunner {

	@Autowired
	private CreditService creditService;

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//creditService.create(new Credit(CreditType.PERSONAL,200,45,12,0.12));
		/*Flux.just(new Credit(CreditType.PERSONAL,200,45,12,0.12),
				new Credit(CreditType.PERSONAL,200,45,12,0.12)
				)
				.flatMap(credit -> creditService.create(credit))
				.subscribe(creditService -> log.info(creditService.toString()));*/
	}
}
