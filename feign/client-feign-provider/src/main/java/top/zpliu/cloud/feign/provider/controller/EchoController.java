package top.zpliu.cloud.feign.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.zpliu.cloud.common.exception.InternalApiException;

@RestController
public class EchoController {

    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) throws InterruptedException {
        if(string.contains("error")){
            throw new InternalApiException("5995","error " + string);
        }
        if(string.contains("logicError")){
            throw new InternalApiException("5996","logicError " + string);
        }
        Thread.sleep(100);
        return "Hello " + string;
    }

}