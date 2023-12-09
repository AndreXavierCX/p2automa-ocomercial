package com.unilins.p2springboot.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.unilins.p2springboot.entities.*;
import com.unilins.p2springboot.repositories.*;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	@Autowired
	private ClienteRepository clienteRep;

	@Autowired
	private CarroRepository carroRep;

	@Autowired
	private AluguelRepository aluguelRepository;

	public void run(String... args) throws Exception {
		Cliente cliente1 = new Cliente(null, "José Oliveira", "111.222.333-44", "(11) 98765-4321", "1234567890");
		Cliente cliente2 = new Cliente(null, "Patrícia Lima", "222.333.444-55", "(22) 99999-8888", "0987654321");
		Cliente cliente3 = new Cliente(null, "Fernanda Pereira", "333.444.555-66", "(33) 87654-1234", "5678901234");
		Cliente cliente4 = new Cliente(null, "Ricardo Santos", "444.555.666-77", "(44) 11111-2222", "9876543210");
		Cliente cliente5 = new Cliente(null, "Mariana Silva", "555.666.777-88", "(55) 33333-4444", "5432109876");
		clienteRep.saveAll(Arrays.asList(cliente1, cliente2, cliente3, cliente4, cliente5));

		Carro carro1 = new Carro(null, "Volkswagen", "Jetta", "XYZ5678", (float) 180.0);
		Carro carro2 = new Carro(null, "Fiat", "Uno", "UVW1234", (float) 120.0);
		Carro carro3 = new Carro(null, "Renault", "Sandero", "LMN9012", (float) 135.0);
		Carro carro4 = new Carro(null, "Hyundai", "HB20", "PQR3456", (float) 155.0);
		Carro carro5 = new Carro(null, "Kia", "Sportage", "STU7890", (float) 200.0);
		carroRep.saveAll(Arrays.asList(carro1, carro2, carro3, carro4, carro5));

		Aluguel aluguel1 = new Aluguel(carro1, cliente1, "20/07/2023", "25/07/2023", (float) 160.75);
		Aluguel aluguel2 = new Aluguel(carro4, cliente2, "20/08/2023", "25/08/2023", (float) 175.0);
		Aluguel aluguel3 = new Aluguel(carro3, cliente5, "20/09/2023", "25/09/2023", (float) 185.25);
		aluguelRepository.saveAll(Arrays.asList(aluguel1, aluguel2, aluguel3));

	}
}
