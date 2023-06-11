package se.kontek.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.kontek.backend.model.HouseLoan;

import java.util.Scanner;

@SpringBootApplication
public class LoanConverterApplication {

	public static void main(String[] args) {

		SpringApplication.run(LoanConverterApplication.class, args);

		Scanner stdin = new Scanner ( System.in );
		System.out.println("Insert loan type:");
		int loanAmount = stdin.nextInt();

		System.out.println("Insert payback time (years:");
		int paybackTime = stdin.nextInt();

		HouseLoan houseLoan1 = new HouseLoan("house", loanAmount, paybackTime, 3.5);
		System.out.println(houseLoan1.getPlan());


	}

}
