package top.zpliu.cloud.feign.consumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.zpliu.cloud.feign.consumer.service.EchoService;

@RestController
@RefreshScope
public class EchoController {

    @Value("${user.name}")
    String userName;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EchoService echoService;

    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        return userName + string;
    }

    @GetMapping(value = "/echo-rest/{str}")
    public String rest(@PathVariable String str) {
        return restTemplate.getForObject("http://client-feign-provider/echo/" + str, String.class);
    }

    @GetMapping(value = "/echo-feign/{str}")
    @SentinelResource(value = "feign")
    public String feign(@PathVariable String str) {
        return echoService.echo(str);
    }
}