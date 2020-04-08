package top.zpliu.cloud.feign.consumer;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
public class SentinelTest {
    public static void main(String[] args){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 100, 100, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        for (int i = 0; i < 1000; i++) {
            final int a = i;
            executor.execute(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    HttpGet httpGet = new HttpGet("http://localhost:8070/echo-feign/ABC");
                    CloseableHttpResponse response = httpClient.execute(httpGet);
                    HttpEntity responseEntity = response.getEntity();
                    System.out.println("请求 "+ a +"响应状态为:" + response.getStatusLine()+" 响应内容为:" + EntityUtils.toString(responseEntity));
                    response.close();
                }
            });
        }
        System.out.println("执行完毕");
    }
}
