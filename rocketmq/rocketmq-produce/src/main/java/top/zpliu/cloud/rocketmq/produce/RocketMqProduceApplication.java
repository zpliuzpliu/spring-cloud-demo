package top.zpliu.cloud.rocketmq.produce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding({ MessageChannelService.class })
public class RocketMqProduceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RocketMqProduceApplication.class,args);
    }
}
