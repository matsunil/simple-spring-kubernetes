package edu.vyurik.spring.kubernetes.simpleserver;

import edu.vyurik.spring.kubernetes.simpleserver.controller.SimpleServerController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KubernetesSimpleServerApplication implements CommandLineRunner {
    private static final Log log = LogFactory.getLog(SimpleServerController.class);

    public static void main(String[] args) {
        SpringApplication.run(KubernetesSimpleServerApplication.class, args);
    }

    public void run(String... args) throws Exception {
        log.info("Simple Server Started! ");
    }

}
