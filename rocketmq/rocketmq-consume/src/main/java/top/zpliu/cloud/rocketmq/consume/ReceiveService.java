package top.zpliu.cloud.rocketmq.consume;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
public class ReceiveService {

	@StreamListener("input1")
	public void receiveInput1(String receiveMsg) {
		System.out.println("testChannel receive: " + receiveMsg);
	}

}
