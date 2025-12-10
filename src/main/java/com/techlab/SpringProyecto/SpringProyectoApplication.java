package com.techlab.SpringProyecto;

import com.techlab.SpringProyecto.model.Producto;
import com.techlab.SpringProyecto.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringProyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProyectoApplication.class, args);
	}

}
