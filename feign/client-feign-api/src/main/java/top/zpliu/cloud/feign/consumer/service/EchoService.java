package top.zpliu.cloud.feign.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.zpliu.cloud.feign.consumer.fallback.EchoServiceFallbackFactory;

@FeignClient(name = "client-feign-provider",fallbackFactory = EchoServiceFallbackFactory.class)
public interface EchoService {

    @GetMapping(value = "/echo/{str}")
    String echo(@PathVariable("str") String str);

}
