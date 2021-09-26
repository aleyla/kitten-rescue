package com.leyla.kittenrescue;

import com.leyla.kittenrescue.client.WhichApiClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableConfigurationProperties(WhichApiClientConfig.class)
public class KittenRescueApplication {

    public static void main(String[] args) {
        SpringApplication.run(KittenRescueApplication.class, args);
    }

}
