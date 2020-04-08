package top.zpliu.cloud.dubbo.consume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DubboDemoConsumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboDemoConsumeApplication.class, args);
    }

}
