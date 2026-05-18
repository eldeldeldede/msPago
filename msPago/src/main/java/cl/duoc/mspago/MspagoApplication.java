package cl.duoc.mspago;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MspagoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MspagoApplication.class, args);
	}

}
