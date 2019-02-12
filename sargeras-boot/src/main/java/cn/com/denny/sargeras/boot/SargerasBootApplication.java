package cn.com.denny.sargeras.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(exclude={MongoAutoConfiguration.class},
scanBasePackages = "cn.com.denny.sargeras")
public class SargerasBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SargerasBootApplication.class, args);
    }
}
