package com.prahlad.study.splitwise;

import com.prahlad.study.splitwise.registry.CommandRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Scanner;

@SpringBootApplication
@EnableJpaAuditing
@RequiredArgsConstructor
public class SplitwiseApplication implements CommandLineRunner {

    private final CommandRegistry commandRegistry;

    public static void main(String[] args) {

        SpringApplication.run(SplitwiseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(">");
            String input = scanner.nextLine();
            commandRegistry.execute(input);
        }
    }
}
