package cz.uhk.fim.ppro;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cz.uhk.fim.ppro.model.Zlomek;
import cz.uhk.fim.ppro.tools.Kalkulacka;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Aplikace Springbiit s AOP
 * @see CommandLineRunner
 * @see Kalkulacka
 * @see Zlomek
 * @see cz.uhk.fim.ppro.aop.KalkulackaAspect
 */
@SpringBootApplication
public class PproAopApplication implements CommandLineRunner {

	@Autowired
	Kalkulacka kalkulacka;
	
	public static void main(String[] args) {
		SpringApplication.run(PproAopApplication.class, args);
	}

	/**
	 * Spousti aplikaci
	 * @param args incoming main method arguments
	 * @throws Exception
	 */
	@Override
	public void run(String... args) throws Exception {
		Zlomek a = new Zlomek(4,3);
		Zlomek b = new Zlomek(2,11);

		System.out.println("Soucet : "+kalkulacka.plus(a, b).zkratit());
		System.out.println("Rozdil : "+kalkulacka.minus(a, b).zkratit());
		System.out.println("Soucin : "+kalkulacka.krat(a, b).zkratit());
		System.out.println("Podil : "+kalkulacka.deleno(a, b).zkratit());

	}

	//beana s loggerem
	@Bean
	Logger getLogger() {
		return org.slf4j.LoggerFactory.getLogger(PproAopApplication.class);
	}

}
