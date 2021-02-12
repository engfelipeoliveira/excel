package br.com.trader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import br.com.trader.service.MainService;

@SpringBootApplication
@EnableScheduling
public class ExcelApplication implements CommandLineRunner{

private final MainService mainService;
	
	public ExcelApplication(MainService mainService) {
		this.mainService = mainService;
	}

	public static void main(String[] args) {
		SpringApplication.run(ExcelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
	
	@Scheduled(cron = "* * * * * *")
	private void execute() throws Exception {
		this.mainService.execute();
	}

}
