package top.zpliu.cloud.rocketmq.consume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding({ MessageChannelService.class })
public class RocketMqConsumeApplication {
    public static void main(String[] args) {
        SpringApplication.run(RocketMqConsumeApplication.class,args);
    }
}
