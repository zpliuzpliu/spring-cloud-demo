package top.zpliu.cloud.feign.consumer.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zpliu.cloud.common.constant.ApiResultCode;
import top.zpliu.cloud.common.dto.ApiResponse;
import top.zpliu.cloud.common.exception.InternalApiException;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ApiResponse processDefaultException(HttpServletResponse response, Exception e) {
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setContentType("application/json;charset=UTF-8");
        ApiResponse result = new ApiResponse(ApiResultCode.INTERNAL_SERVER_ERROR);
        log.error("未知异常错误，错误信息：{}",e);
        return result;
    }

    @ExceptionHandler(InternalApiException.class)
    @ResponseBody
    public ApiResponse processApiException(HttpServletResponse response, InternalApiException e) {
        response.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
        response.setContentType("application/json;charset=UTF-8");
        ApiResponse result = new ApiResponse(ApiResultCode.INTERNAL_SERVER_ERROR);
        result.setCode(e.getCode());
        result.setMsg(e.getMsg());
        log.error("API异常错误，错误码：{}，错误信息：{}",e.getCode(),e.getMsg());
        log.error("API异常错误：",e);
        return result;
    }

}
