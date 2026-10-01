package co.edu.unicordoba.decorator.reportes_sin_patron;

import co.edu.unicordoba.decorator.reportes_sin_patron.controller.SinDecoratorController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TallerDecoratorReportesSinPatronApplication {

    public static void main(String[] args) {
        SpringApplication.run(TallerDecoratorReportesSinPatronApplication.class, args);
    }

    /**
     * Ejecuta la versión sin patrón directamente en la consola al iniciar.
     */
    @Bean
    public CommandLineRunner run(SinDecoratorController controller) {
        return args -> {
            System.out.println("\n--------------------------------------------------");
            System.out.println("EJECUCIÓN EN CONSOLA (VERSIÓN SIN DECORATOR - DEFECTO):");
            controller.ejecutarDemostracion().forEach(System.out::println);
            System.out.println("--------------------------------------------------\n");
        };
    }
}