package top.zpliu.cloud.rocketmq.consume;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MessageChannelService {

    @Input("input1")
    SubscribableChannel input1();

}
