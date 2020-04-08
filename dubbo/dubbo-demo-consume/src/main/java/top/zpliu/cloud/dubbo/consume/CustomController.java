package top.zpliu.cloud.dubbo.consume;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import top.zpliu.cloud.dubbo.consume.api.UserService;

@Component
@Slf4j
public class CustomController implements CommandLineRunner {


    @Reference
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        log.info("hello...init...");
        System.out.println(userService.isExist("1"));
    }


}
