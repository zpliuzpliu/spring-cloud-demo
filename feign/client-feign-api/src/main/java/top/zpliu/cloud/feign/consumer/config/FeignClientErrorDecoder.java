package top.zpliu.cloud.feign.consumer.config;

import com.alibaba.fastjson.JSON;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import top.zpliu.cloud.common.constant.ApiResultCode;
import top.zpliu.cloud.common.dto.ApiResponse;
import top.zpliu.cloud.common.exception.InternalApiException;

import java.io.IOException;

@Configuration
public class FeignClientErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        if (response.status() != HttpStatus.OK.value()) {
            if (response.status() == HttpStatus.SERVICE_UNAVAILABLE.value()) {
                String errorContent;
                try {
                    errorContent = Util.toString(response.body().asReader());
                    ApiResponse apiResponse = JSON.parseObject(errorContent, ApiResponse.class);
                    InternalApiException internalApiException = new InternalApiException(apiResponse.getCode(),apiResponse.getMsg());
                    return internalApiException;
                } catch (IOException e) {
                    return new InternalApiException(ApiResultCode.INTERNAL_SERVER_ERROR);
                }
            }
        }
        return new InternalApiException(ApiResultCode.INTERNAL_SERVER_ERROR);
    }
}
