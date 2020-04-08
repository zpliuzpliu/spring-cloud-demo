package top.zpliu.cloud.rocketmq.produce;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

@Component
@Slf4j
public class CustomRunner implements CommandLineRunner {

    @Autowired
    private MessageChannelService messageChannelService;

    @Override
    public void run(String... args) throws Exception {
        log.info("hello...init...");
//        int count = 0;
//        while (true) {
////            Scanner scanner = new Scanner(System.in);
////            String msg = scanner.nextLine();
//            String msg = "count:" + (count++);
//            Message<String> message = MessageBuilder.withPayload(msg)
//                    .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
//                    .setHeader("test", String.valueOf("~~~"))
//                    .setHeader(RocketMQHeaders.TAGS, "spring cloud demo").build();
//
//            messageChannelService.output1().send(message);
//            Thread.sleep(2000);
//        }

        // COMMIT_MESSAGE message
        sendTransactionalMsg("transactional-msg1", 1);
        // ROLLBACK_MESSAGE message
        sendTransactionalMsg("transactional-msg2", 2);
        // ROLLBACK_MESSAGE message
        sendTransactionalMsg("transactional-msg3", 3);
        // COMMIT_MESSAGE message
        sendTransactionalMsg("transactional-msg4", 4);
    }


    public <T> void sendTransactionalMsg(T msg, int num) throws Exception {
        MessageBuilder builder = MessageBuilder.withPayload(msg)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON);
        builder.setHeader("test", String.valueOf(num));
        builder.setHeader(RocketMQHeaders.TAGS, "binder");
        Message message = builder.build();
        messageChannelService.output1().send(message);
    }
}
