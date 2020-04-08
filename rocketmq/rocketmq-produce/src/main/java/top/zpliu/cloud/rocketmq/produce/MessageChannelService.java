package top.zpliu.cloud.rocketmq.produce;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MessageChannelService {

    @Output("output1")
    MessageChannel output1();

}
