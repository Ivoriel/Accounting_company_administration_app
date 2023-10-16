package pl.tkosinski.accountingadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "pl.tkosinski.accountingadmin")
@Configuration
@SpringBootApplication
public class AccountingAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountingAdminApplication.class, args);
	}

}
